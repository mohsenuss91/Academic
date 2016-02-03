import java.net.*;
import java.io.*;
import java.util.*;

/*
 * The Client that can be run both as a console or a GUI
 */
public class Client  {

	// for I/O
	private ObjectInputStream sInput;		// to read from the socket
	private ObjectOutputStream sOutput;		// to write on the socket
	private Socket socket;

	// if I use a GUI or not
	private ClientGUI cg;
	
	// the server, the port and the utilisateur
	private String server, utilisateur;
	private int port;

	/*
	 *  Constructor called by console mode
	 *  server: the server address
	 *  port: the port number
	 *  utilisateur: the utilisateur
	 */
	Client(String server, int port, String utilisateur) {
		// which calls the common constructor with the GUI set to null
		this(server, port, utilisateur, null);
	}

	/*
	 * Constructor call when used from a GUI
	 * in console mode the ClienGUI parameter is null
	 */
	Client(String server, int port, String utilisateur, ClientGUI cg) {
		this.server = server;
		this.port = port;
		this.utilisateur = utilisateur;
		// save if we are in GUI mode or not
		this.cg = cg;
	}
	
	/*
	 * To start the dialog
	 */
	public boolean start() {
		// try to connect to the server
		try {
			socket = new Socket(server, port);
		} 
		// if it failed not much I can so
		catch(Exception ec) {
			display("Error connectiong to server:" + ec);
			return false;
		}
		
		String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
		display(msg);
	
		/* Creating both Data Stream */
		try
		{
			sInput  = new ObjectInputStream(socket.getInputStream());
			sOutput = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO) {
			display("Exception creating new Input/output Streams: " + eIO);
			return false;
		}

		// creates the Thread to listen from the server 
		new ListenFromServer().start();
		// Send ourutilisateurto the server this is the only message that we
		// will send as a String. All other messages will be ChatMessage objects
		try
		{
			sOutput.writeObject(utilisateur);
		}
		catch (IOException eIO) {
			display("Exception doing login : " + eIO);
			deconnection();
			return false;
		}
		// success we inform the caller that it worked
		return true;
	}

	/*
	 * To send a message to the console or the GUI
	 */
	private void display(String msg) {
		if(cg == null)
			System.out.println(msg);      // println in console mode
		else
			cg.append(msg + "\n");		// append to the ClientGUI JTextArea (or whatever)
	}
	
	/*
	 * To send a message to the server
	 */
	void envoyer_le_message(ChatMessage msg) {
		try {
			sOutput.writeObject(msg);
		}
		catch(IOException e) {
			display("Exception writing to server: " + e);
		}
	}

	/*
	 * When something goes wrong
	 * Close the Input/Output streams and deconnection not much to do in the catch clause
	 */
	private void deconnection() {
		try { 
			if(sInput != null) sInput.close();
		}
		catch(Exception e) {} // not much else I can do
		try {
			if(sOutput != null) sOutput.close();
		}
		catch(Exception e) {} // not much else I can do
        try{
			if(socket != null) socket.close();
		}
		catch(Exception e) {} // not much else I can do
		
		// inform the GUI
		if(cg != null)
			cg.connectionFailed();
			
	}
	/*
	 * To start the Client in console mode use one of the following command
	 * > java Client
	 * > java Client utilisateur
	 * > java Clientutilisateurnum_port
	 * > java Clientutilisateurnum_port serverAddress
	 * at the console prompt
	 * If the num_port is not specified 1234 is used
	 * If the serverAddress is not specified "localHost" is used
	 * If theutilisateuris not specified "Anonymous" is used
	 * > java Client 
	 * is equivalent to
	 * > java Client Anonymous 1234 localhost 
	 * are eqquivalent
	 * 
	 * In console mode, if an error occurs the program simply stops
	 * when a GUI id used, the GUI is informed of the deconnectionion
	 */
	public static void main(String[] args) {
		// default values
		int num_port = 1234;
		String serverAddress = "localhost";
		String utilisateur= "Votre Nom d'utilisateur";

		// depending of the number of arguments provided we fall through
		switch(args.length) {
			// > javac Clientutilisateurnum_port serverAddr
			case 3:
				serverAddress = args[2];
			// > javac Clientutilisateurnum_port
			case 2:
				try {
					num_port = Integer.parseInt(args[1]);
				}
				catch(Exception e) {
					System.out.println("Port invalide.");
					System.out.println("java Client [utilisateur] [num_port] [serverAddress]");
					return;
				}
			// > javac Client utilisateur
			case 1: 
				utilisateur = args[0];
			// > java Client
			case 0:
				break;
			// invalid number of arguments
			default:
				System.out.println("java Client [utilisateur] [num_port] {serverAddress]");
			return;
		}
		// create the Client object
		Client client = new Client(serverAddress, num_port, utilisateur);
		// test if we can start the connection to the Server
		// if it failed nothing we can do
		if(!client.start())
			return;
		
		// wait for messages from user
		Scanner scan = new Scanner(System.in);
		// loop forever for message from the user
		while(true) {
			System.out.print("> ");
			// read message from user
			String msg = scan.nextLine();
			// logout if message is LOGOUT
			if(msg.equalsIgnoreCase("LOGOUT")) {
				client.envoyer_le_message(new ChatMessage(ChatMessage.deconnecte, ""));
				// break to do the deconnection
				break;
			}
			// message WhoIsIn
			else if(msg.equalsIgnoreCase("WHOISIN")) {
				client.envoyer_le_message(new ChatMessage(ChatMessage.qui_est_la, ""));				
			}
			else {				// default to ordinary message
				client.envoyer_le_message(new ChatMessage(ChatMessage.MESSAGE, msg));
			}
		}
		// done deconnection
		client.deconnection();	
	}

	/*
	 * a class that waits for the message from the server and append them to the JTextArea
	 * if we have a GUI or simply System.out.println() it in console mode
	 */
	class ListenFromServer extends Thread {

		public void run() {
			while(true) {
				try {
					String msg = (String) sInput.readObject();
					// if console mode print the message and add back the prompt
					if(cg == null) {
						System.out.println(msg);
						System.out.print("> ");
					}
					else {
						cg.append(msg);
					}
				}
				catch(IOException e) {
					display("Server has close the connection: " + e);
					if(cg != null) 
						cg.connectionFailed();
					break;
				}
				// can't happen with a String object but need the catch anyhow
				catch(ClassNotFoundException e2) {
				}
			}
		}
	}
}
