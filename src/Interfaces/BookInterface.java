/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Library.Model.Book;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jean claude
 */
public interface BookInterface extends Remote {
    public void save(Book b)throws RemoteException;
    public void update(Book b)throws RemoteException;
    public void delete(Book b)throws RemoteException;
}
