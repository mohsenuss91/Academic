import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class chat_client_main {

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, AlreadyBoundException {
		String chat_server_url="rmi//localhost:1099/RMI_CHAT";

		Registry reg=LocateRegistry.getRegistry("localhost",1099);
		server_interface chatserver=(server_interface) reg.lookup(chat_server_url);
		
		System.out.println("**Client**");
		int i=0;
		new Thread(new client("client"+i++,chatserver)).start();
		

	}

}
