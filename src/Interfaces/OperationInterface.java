/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Library.Model.Checkout;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jean claude
 */
public interface OperationInterface extends Remote{
    public void saveCheck(Checkout ck)throws RemoteException;
}
