package pt.ipb.sd.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {

    public static String NAME = "SESSAO";
    public static int PORT = 1099;

    public static void main(String[] args) {

        if( args.length < 1) {
            System.err.println("O IP do servidor deve ser passado por parametro");
            System.exit(-1);
        }
        System.getProperties().setProperty("java.security.policy", "security.policy");
        System.getProperties().setProperty("java.rmi.server.useCodebaseOnly", "false");
        System.getProperties().setProperty("java.rmi.server.hostname", args[0]);

        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            LocateRegistry.createRegistry(PORT);
            Sessao sessao = new Sessao();
            Naming.rebind(NAME, sessao);
            System.out.println("Servidor RMI ligado em: " + args[0] + ":" + PORT);
            System.out.println("\t|- Nome registrado: " + NAME);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
