import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class client extends UnicastRemoteObject implements client_interface, Runnable
{
	server_interface server;
	String nom=null; 
  //constructeur	
	protected client(String nom, server_interface server) throws RemoteException 
	{
		this.nom=nom;
		this.server=server;
		server.enregistrer_le_client(this);
	}

	private static final long serialVersionUID = 1L;

	//recevoir les msg a partir du serveur
	public void recevoir_message(String msg) throws RemoteException 
	{
		System.out.println(msg);	
	}

//implementation de run()
	public void run() 
	{
		Scanner sc=new Scanner(System.in);
		String msgs;
		//recuperation de msg
		while(true)
		{
			msgs=sc.nextLine();
			try 
			{
				server.envoyer_message( msgs);
			} 
			catch (RemoteException e) 
			{			
				e.printStackTrace();
			}
		}
		
	}

}