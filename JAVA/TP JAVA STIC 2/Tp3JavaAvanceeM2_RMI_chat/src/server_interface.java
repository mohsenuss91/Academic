

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface server_interface extends Remote{
	void enregistrer_le_client(client_interface client) throws RemoteException;
	void envoyer_message(String msg) throws RemoteException;

}
