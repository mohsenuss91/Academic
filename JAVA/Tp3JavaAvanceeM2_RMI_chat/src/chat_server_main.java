import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class chat_server_main {


	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		server imlp=new server();
		Registry reg=LocateRegistry.createRegistry(1099);
		reg.bind("rmi//localhost:1099/RMI_CHAT", imlp);
		System.out.println("Le serveur est demare...");
	}

}
