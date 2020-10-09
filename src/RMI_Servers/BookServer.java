/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Servers;

import Interfaces.BookInterface;
import Library.Model.Book;
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
public class BookServer extends UnicastRemoteObject implements BookInterface{

    public BookServer() throws RemoteException {
    }
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.rebind("Ibook", new BookServer());
            System.out.println("BookServer Started!!...");
        } catch (RemoteException ex) {
            Logger.getLogger(BookServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void save(Book b) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.save(b);
        trans.commit();
        sess.close();
    }

    @Override
    public void update(Book b) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.update(b);
        trans.commit();
        sess.close();
    }

    @Override
    public void delete(Book b) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.delete(b);
        trans.commit();
        sess.close();
    }
    
}
