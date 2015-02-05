

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface client_interface extends Remote{
	void recevoir_message(String msg) throws RemoteException;

}
