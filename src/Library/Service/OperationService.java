/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Service;

import Library.Dao.CheckOutDao;
import Library.Model.Checkout;
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
public class OperationService extends UnicastRemoteObject implements IOperationService {

    public OperationService() throws RemoteException {
    }

    @Override
    public boolean save(String clientname, String bookname, String author, String returndate, String status) throws RemoteException {
        try {
            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
            Checkout chout = new Checkout(clientname, bookname, author, df.parse(returndate), status);
            CheckOutDao choutdao= new CheckOutDao(); 
            choutdao.SaveCheckOut(chout);
            return true;
        } catch (ParseException ex) {
            Logger.getLogger(OperationService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
