package pt.ipb.sd.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface NavegadorRemote extends Remote {

    public String cd(String diretoria) throws RemoteException;

    public List<String> ls() throws RemoteException;

    public boolean mkdir(String nome) throws RemoteException;

    public boolean touch(String nome) throws RemoteException;

    public boolean rm(String nome) throws RemoteException;

    public boolean rmdir(String nome) throws RemoteException;

    public String file(String nome) throws RemoteException;

    public String cat(String nome) throws RemoteException;

    public boolean write(String nome, String conteudo) throws RemoteException;

    public void sair() throws RemoteException;

}
