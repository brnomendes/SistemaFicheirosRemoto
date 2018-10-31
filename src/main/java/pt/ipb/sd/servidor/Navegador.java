package pt.ipb.sd.servidor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import pt.ipb.sd.interfaces.NavegadorRemote;

public class Navegador extends UnicastRemoteObject implements NavegadorRemote {

    private String diretoriaAtual = File.separator;

    public Navegador() throws RemoteException {
        super();
    }

    @Override
    public String cd(String diretoria) throws RemoteException {
        Path atual = Paths.get(this.diretoriaAtual);
        Path dir = Paths.get(diretoria);

        if (dir.isAbsolute()) {
            atual = dir;
        } else {
            atual = atual.resolve(dir).normalize();
        }

        if (Files.exists(atual, LinkOption.NOFOLLOW_LINKS)) {
            this.diretoriaAtual = atual.toString();
            return this.diretoriaAtual;
        } else {
            return "";
        }
    }

    @Override
    public String[] ls() throws RemoteException {
        return new File(this.diretoriaAtual).list();
    }

    @Override
    public boolean mkdir(String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean touch(String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean rm(String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean rmdir(String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String file(String nome) throws RemoteException {
        File ficheiro = new File(this.diretoriaAtual + File.separator + nome);

        if (ficheiro.exists() && ficheiro.isFile()) {
            return "Tamanho: " + ficheiro.length();
        } else {
            return "Diretório";
        }
    }

    @Override
    public String cat(String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean write(String nome, String conteudo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sair() throws RemoteException {
        unexportObject(this, true);
    }

    // PARA TESTES
    public static void main(String[] args) {

        try {
            Navegador n = new Navegador();
//            System.out.println(n.cd("/home/bruno/"));
//            System.out.println(Arrays.toString(n.ls()));
            System.exit(0);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
