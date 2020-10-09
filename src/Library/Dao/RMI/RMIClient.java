/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Dao.RMI;

import Library.Service.IClientService;
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
public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1201);
            IClientService clientservice = (IClientService) registry.lookup("clientservice");
            boolean result = clientservice.save("0002", "jean_RMI", "CLAUDE", "0788908856", "jean@gmail.com", "Staff", "C:\\Users\\jean claude\\Pictures\\Saved Pictures\\New folder\\black-r1-5784");
            System.out.println(result ? "Saved Successfully" : "Error. can't saved");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
