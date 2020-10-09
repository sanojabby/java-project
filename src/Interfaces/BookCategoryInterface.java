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
public interface BookCategoryInterface extends Remote {
    public void save(Book bc)throws RemoteException;
    public void update(Book bc)throws RemoteException;
    public void delete(Book bc)throws RemoteException;
}
