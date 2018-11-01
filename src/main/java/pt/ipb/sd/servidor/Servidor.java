package pt.ipb.sd.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    public static String NAME = "SESSAO";
    public static int PORT = 1099;

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("O IP do servidor deve ser passado por parametro");
            System.exit(-1);
        }
        System.setProperty("java.security.policy", "security.policy");
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");
        System.setProperty("java.rmi.server.hostname", args[0]);

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            Sessao sessao = new Sessao();
            registry.rebind(NAME, sessao);
            System.out.println("Servidor RMI ligado em: " + args[0] + ":" + PORT);
            System.out.println("\t|- Nome registrado: " + NAME);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
