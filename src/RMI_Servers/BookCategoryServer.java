/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Servers;

import Interfaces.BookCategoryInterface;
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
public class BookCategoryServer extends UnicastRemoteObject implements BookCategoryInterface{

    public BookCategoryServer() throws RemoteException {
        super();
    }
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1000);
            registry.rebind("Ibookcategory", new BookCategoryServer());
            System.out.println("BookCategoryServer Started!!...");
        } catch (RemoteException ex) {
            Logger.getLogger(BookCategoryServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void save(Book bc) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.save(bc);
        trans.commit();
        sess.close();
    }

    @Override
    public void update(Book bc) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.update(bc);
        trans.commit();
        sess.close();
    }

    @Override
    public void delete(Book bc) throws RemoteException {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sess.beginTransaction();
        sess.delete(bc);
        trans.commit();
        sess.close();
    }
    
}
