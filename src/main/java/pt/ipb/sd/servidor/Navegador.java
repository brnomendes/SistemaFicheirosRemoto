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

import pt.ipb.sd.interfaces.NavegadorRemote;

public class Navegador extends UnicastRemoteObject implements NavegadorRemote {

    private String diretoriaAtual = System.getProperty("user.home");

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
        Path path = Paths.get(this.diretoriaAtual + File.separator + nome);
        try {
            Files.createDirectory(path);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean touch(String nome) throws RemoteException {
        Path path = Paths.get(this.diretoriaAtual + File.separator + nome);
        if (Files.exists(path)) {
            return false;
        }

        File file = new File(String.valueOf(path));
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean rm(String nome) throws RemoteException {
        Path path = Paths.get(this.diretoriaAtual + File.separator + nome);
        if (Files.notExists(path) || !Files.isRegularFile(path)) {
            return false;
        }
        File file = new File(String.valueOf(path));
        return file.delete();
    }

    @Override
    public boolean rmdir(String nome) throws RemoteException {
        Path path = Paths.get(this.diretoriaAtual + File.separator + nome);
        if (Files.notExists(path) || !Files.isDirectory(path)) {
            return false;
        }
        File file = new File(String.valueOf(path));
        return file.delete();
    }

    @Override
    public String file(String nome) throws RemoteException {
        File ficheiro = new File(this.diretoriaAtual + File.separator + nome);

        if (ficheiro.exists() && ficheiro.isFile()) {
            try {
                String probe = Files.probeContentType(Paths.get(ficheiro.getAbsolutePath()));
                if (probe != null) {
                    return Navegador.tamanhoLegivel(ficheiro.length()) + "|" + probe;
                }
            } catch (IOException ex) {

            }
            return Navegador.tamanhoLegivel(ficheiro.length()) + "|";
        } else {
            return "Dir";
        }
    }

    @Override
    public String cat(String nome) throws RemoteException {
        Path path = Paths.get(this.diretoriaAtual + File.separator + nome);
        StringBuilder output = new StringBuilder();
        try {
            for (String line : Files.readAllLines(path)) {
                output.append(line);
                output.append(System.lineSeparator());
            }
            return output.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return output.toString();

    }

    @Override
    public boolean write(String nome, String conteudo) throws RemoteException {
        Path path = Paths.get(this.diretoriaAtual + File.separator + nome);
        if (Files.notExists(path) || !Files.isRegularFile(path)) {
            return false;
        }
        File file = new File(String.valueOf(path));

        if (!file.canWrite()) {
            return false;
        }

        try (PrintStream ps = new PrintStream(file)) {
            ps.append(conteudo);
            ps.flush();
            ps.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public void sair() throws RemoteException {
        unexportObject(this, true);
    }

    public static String tamanhoLegivel(long bytes) {
        int unit = 1000;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = String.valueOf(("kMGTPE").charAt(exp - 1));
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
