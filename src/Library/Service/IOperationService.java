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
public interface IOperationService extends Remote{
    public boolean save(String clientname, String bookname, String author, 
            String returndate, String status) throws RemoteException;
    
}
