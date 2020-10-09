/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Dao.RMI;

import Library.Service.IOperationService;
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
public class RMIOperation {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1201);
            IOperationService operationservice = (IOperationService) registry.lookup("operationservice");
            boolean result = operationservice.save("Alex", "RMI_java", "erneus", "2000-05-13", "Check In");
            System.out.println(result ? "Saved Successfully!!" : "Error. can't be Saved!!");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RMIOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
