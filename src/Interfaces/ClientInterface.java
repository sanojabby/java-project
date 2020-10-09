/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Library.Model.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jean claude
 */
public interface ClientInterface extends Remote{
    public void save(Client c) throws RemoteException;
    public void update(Client c) throws RemoteException;
    public void delete(Client c) throws RemoteException;
}
