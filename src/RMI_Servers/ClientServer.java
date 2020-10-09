/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Servers;

import Interfaces.ClientInterface;
import Library.Model.Client;
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
public class ClientServer extends UnicastRemoteObject implements ClientInterface{

    public ClientServer() throws RemoteException {
        super();
    }
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(6001);
            registry.rebind("Iclient", new ClientServer());
            System.out.println("ClientServer Started!!...");
        } catch (RemoteException ex) {
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Client c) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.save(c);
        trans.commit();
        sess.close();
         }

    @Override
    public void update(Client c) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.update(c);
        trans.commit();
        sess.close();
         }

    @Override
    public void delete(Client c) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.delete(c);
        trans.commit();
        sess.close();
        }
    
}
