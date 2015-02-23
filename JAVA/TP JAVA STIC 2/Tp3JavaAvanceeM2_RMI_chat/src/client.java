

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class client extends UnicastRemoteObject implements client_interface, Runnable{
	server_interface server;
	String nom=null; 
	
	protected client(String nom, server_interface server) throws RemoteException {
		this.nom=nom;
		this.server=server;
		server.enregistrer_le_client(this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void recevoir_message(String msg) throws RemoteException {
		System.out.println(msg);
		
	}

	@Override
	public void run() {
		Scanner sc=new Scanner(System.in);
		String msgs;
		while(true)
		{
			msgs=sc.nextLine();
			try {
				server.envoyer_message(nom+": "+ msgs);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
