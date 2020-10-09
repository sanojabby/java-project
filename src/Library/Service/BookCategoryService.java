/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Service;

import Library.Dao.BookDao;
import Library.Model.Bookcategory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jean claude
 */
public class BookCategoryService extends UnicastRemoteObject implements IBookCategoryService{

    public BookCategoryService() throws RemoteException {
        super();
    }

    @Override
    public boolean save(String CategoryId, String categoryName) throws RemoteException {
        Bookcategory bc = new Bookcategory(CategoryId, categoryName);
        BookDao bdao = new BookDao();
        bdao.saveBookcategory(bc);
        return true;
    }
    
}
