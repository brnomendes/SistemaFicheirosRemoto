package pt.ipb.sd.servidor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

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
        Path path = Paths.get(nome);
        try {
            Files.createDirectory(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean touch(String nome) throws RemoteException {
        Path path = Paths.get(nome);
        if(Files.exists(path)) return false;

        File file = new File(String.valueOf(path));
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Falha ao criar o ficheiro");
        }
        return false;
    }

    @Override
    public boolean rm(String nome) throws RemoteException {
        Path path = Paths.get(nome);
        if(Files.notExists(path) || !Files.isRegularFile(path)) return false;
        File file = new File(String.valueOf(path));
        return file.delete();
    }

    @Override
    public boolean rmdir(String nome) throws RemoteException {
        Path path = Paths.get(nome);
        if(Files.notExists(path) || !Files.isDirectory(path)) return false;
        File file = new File(String.valueOf(path));
        return file.delete();
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
        Path path = Paths.get(nome);
        StringBuilder output = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(output::append);
            return output.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    @Override
    public boolean write(String nome, String conteudo) throws RemoteException {
        Path path = Paths.get(nome);
        if(Files.notExists(path) || !Files.isRegularFile(path)) return false;
        File file = new File(String.valueOf(path));

        if(!file.canWrite()) return false;

        try {
            PrintStream ps = new PrintStream(file);
            ps.append(conteudo);
            ps.flush();
            ps.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void sair() throws RemoteException {
        unexportObject(this, true);
    }
}
