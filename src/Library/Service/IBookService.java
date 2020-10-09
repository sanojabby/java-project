/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jean claude
 */
public interface IBookService extends Remote{
    public boolean save(String bookId, String title, String publishinghouse, String dateofpublication,String author,
            int pages, String bookcategory) throws RemoteException;
}
