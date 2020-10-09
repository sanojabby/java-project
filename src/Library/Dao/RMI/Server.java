/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Dao.RMI;

import Library.Service.BookCategoryService;
import Library.Service.BookService;
import Library.Service.ClientService;
import Library.Service.OperationService;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean claude
 */
public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1201);
            registry.rebind("clientservice", new ClientService());
            registry.rebind("bookcategoryservice", new BookCategoryService());
            registry.rebind("bookservice", new BookService());
            registry.rebind("operationservice", new OperationService());
            System.out.println("Server Started!!");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
