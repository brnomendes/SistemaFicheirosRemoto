package pt.ipb.sd.servidor;

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
            Registry registry = LocateRegistry.createRegistry(Servidor.PORT);
            Sessao sessao = new Sessao();
            registry.rebind(Servidor.NAME, sessao);
            System.out.println("Servidor RMI ligado em: " + args[0] + ":" + Servidor.PORT);
            System.out.println("\t|- Nome registrado: " + Servidor.NAME);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
