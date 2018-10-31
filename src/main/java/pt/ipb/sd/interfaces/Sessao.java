package pt.ipb.sd.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sessao extends Remote {

    public NavegadorRemote login() throws RemoteException;
}
