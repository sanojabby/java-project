/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.Service;

import Library.Dao.ClientDao;
import Library.Model.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jean claude
 */
public class ClientService extends UnicastRemoteObject implements IClientService {

    public ClientService() throws RemoteException {
        super();
    }

    @Override
    public boolean save(String regno, String firstName, String lastName, String phoneNumber, String emailAddress, String clientCategory, String image) throws RemoteException {
        
        Client c = new Client(regno, firstName, lastName, phoneNumber, emailAddress, clientCategory, image);
        
        ClientDao cdao = new ClientDao();
        cdao.saveClient(c);
        return true;
    }
    
}
