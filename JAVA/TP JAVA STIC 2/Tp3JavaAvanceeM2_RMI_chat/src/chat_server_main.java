import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class chat_server_main 
{
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException 
	{
		server imlp=new server();
		/*
		 * LocateRegistry creates a local reference to the remote registry and will succeed even if no registry is running on the remote host.
		 * 
		 *  createRegistry(port) Creates and exports a Registry instance on the local host that accepts requests on the specified port. 
		 */
		Registry reg=LocateRegistry.createRegistry(1099);
		//registering a name for a remote object that can be used at a later time to look up that remote object
		reg.bind("rmi//localhost:1099/RMI_CHAT", imlp);
		System.out.println("Le serveur est demare...");
	}
}
