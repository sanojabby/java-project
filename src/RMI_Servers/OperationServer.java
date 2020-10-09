/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Servers;

import Interfaces.OperationInterface;
import Library.Model.Checkout;
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
public class OperationServer extends UnicastRemoteObject implements OperationInterface{

    public OperationServer() throws RemoteException {
        super();
    }
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(6003);
            registry.rebind("Ioperation", new OperationServer());
            System.out.println("OperationServer Started!!...");
        } catch (RemoteException ex) {
            Logger.getLogger(OperationServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void saveCheck(Checkout ck) throws RemoteException {
    Session sess = HibernateUtil.getSessionFactory().openSession();
    Transaction trans = sess.beginTransaction();
    sess.save(ck);
    trans.commit();
    }
    
}
