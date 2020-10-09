/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Servers;

import Interfaces.LoginInterface;
import Library.Model.Login;
import Library.Util.HibernateUtil;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jean claude
 */
public class LoginServer extends UnicastRemoteObject implements LoginInterface{

    public LoginServer() throws RemoteException {
        super();
    }
    
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(6004);
            reg.rebind("Ilogin", new LoginServer());
            System.out.println("LoginServer Started!!...");
        } catch (RemoteException ex) {
            Logger.getLogger(LoginServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void save(Login l) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.save(l);
        trans.commit();
        sess.close();
    }
    
}
