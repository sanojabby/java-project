/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Dao.RMI;

import Library.Service.IBookService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean claude
 */
public class RMIBook {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1201);
            IBookService bookservice = (IBookService) registry.lookup("bookservice");
            boolean out = bookservice.save("0002", "Right","Rwanda_lib", "1920-05-12", "Rwema", 4321, "Kinya");
            System.err.println(out ? "Saved Successfully!!" : "Error Ocurred. Can't Saved ");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RMIBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
