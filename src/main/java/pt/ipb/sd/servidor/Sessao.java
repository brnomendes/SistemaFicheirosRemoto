package pt.ipb.sd.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import pt.ipb.sd.interfaces.NavegadorRemote;
import pt.ipb.sd.interfaces.SessaoRemote;

public class Sessao extends UnicastRemoteObject implements SessaoRemote {

    public Sessao() throws RemoteException {
        super();
    }

    @Override
    public NavegadorRemote login() throws RemoteException {
        return new Navegador();
    }

}
