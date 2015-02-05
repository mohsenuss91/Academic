

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class server extends UnicastRemoteObject implements server_interface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<client_interface> chat_clients;

	protected server() throws RemoteException {
		chat_clients= new ArrayList<client_interface>();
	}

	@Override
	public synchronized void enregistrer_le_client(client_interface client)
			throws RemoteException {
		this.chat_clients.add(client);
		
	}

	@Override
	public synchronized void envoyer_message(String msg) throws RemoteException {
		int i=0;
		while (i<chat_clients.size()) {
			chat_clients.get(i++).recevoir_message(msg);
			
		}
		
	}


}
