import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class chat_client_main 
{

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, AlreadyBoundException 
	{
		String chat_server_url="rmi//localhost:1099/RMI_CHAT";
		//getRegistry(port) Returns a reference to the remote object Registry on the specified host and port
		Registry reg=LocateRegistry.getRegistry("localhost",1099);
		//lookup(str) Returns the remote reference bound to the specified name in this registry.
		server_interface chatserver=(server_interface) reg.lookup(chat_server_url);
				
		System.out.println("**Client**");		
		new Thread(new client("client",chatserver)).start();		
	}
}