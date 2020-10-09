 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Service;

import Library.Dao.BookDao;
import Library.Model.Book;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean claude
 */
public class BookService extends UnicastRemoteObject implements IBookService{

    public BookService() throws RemoteException {
        super();
    }

    @Override
    public boolean save(String bookId, String title, String publishinghouse, String dateofpublication, String author, int pages, String bookcategory) throws RemoteException {
        try {
            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
            Book b = new Book(bookId, title, publishinghouse, df.parse(dateofpublication), author, pages, bookcategory);
            BookDao bdao = new BookDao();
            bdao.saveBook(b);
            return true;
        } catch (ParseException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
