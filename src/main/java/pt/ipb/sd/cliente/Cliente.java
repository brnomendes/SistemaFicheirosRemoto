package pt.ipb.sd.cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import pt.ipb.sd.interfaces.NavegadorRemote;
import pt.ipb.sd.interfaces.SessaoRemote;

public class Cliente {

    public static String NAME = "SESSAO";
    public static int PORT = 1099;

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("O IP do servidor deve ser passado por parametro");
            System.exit(-1);
        }
        System.getProperties().setProperty("java.security.policy", "security.policy");
        System.getProperties().setProperty("java.rmi.server.useCodebaseOnly", "false");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            LocateRegistry.getRegistry(PORT);
            SessaoRemote sessao = (SessaoRemote) Naming.lookup(NAME);
            NavegadorRemote nr = sessao.login();

            new ClienteGUI(nr).setVisible(true);

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
