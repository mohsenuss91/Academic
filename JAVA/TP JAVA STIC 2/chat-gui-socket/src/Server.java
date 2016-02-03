import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * The server that can be run both as a console application or a GUI
 */
public class Server {
	// a unique ID for each connection
	private static int uniqueId;
	// an ArrayList to keep the list of the Client
	private ArrayList<ClientThread> al;
	// if I am in a GUI
	private ServerGUI sg;
	// to afficher time
	private SimpleDateFormat la_date;
	// the port number to listen for connection
	private int port;
	// the boolean that will be turned of to stop the server
	private boolean encore;
	

	/*
	 *  server constructor that receive the port to listen to for connection as parameter
	 *  in console
	 */
	public Server(int port) {
		this(port, null);
	}
	
	public Server(int port, ServerGUI sg) {
		// GUI or not
		this.sg = sg;
		// the port
		this.port = port;
		// to afficher hh:mm:ss
		la_date = new SimpleDateFormat("HH:mm:ss");
		// ArrayList for the Client list
		al = new ArrayList<ClientThread>();
	}
	
	public void start() {
		encore = true;
		/* create socket server and wait for connection requests */
		try 
		{
			// the socket used by the server
			ServerSocket serverSocket = new ServerSocket(port);

			// infinite loop to wait for connections
			while(encore) 
			{
				// format message saying we are waiting
				afficher("Le serveurs attends des clients dans le port " + port + ".");
				
				Socket socket = serverSocket.accept();  	// accept connection
				// if I was asked to stop
				if(!encore)
					break;
				ClientThread t = new ClientThread(socket);  // make a thread of it
				al.add(t);									// save it in the ArrayList
				t.start();
			}
			// I was asked to stop
			try {
				serverSocket.close();
				for(int i = 0; i < al.size(); ++i) {
					ClientThread tc = al.get(i);
					try {
					tc.sInput.close();
					tc.sOutput.close();
					tc.socket.close();
					}
					catch(IOException ioE) {
						// not much I can do
					}
				}
			}
			catch(Exception e) {
				afficher("Exception: " + e);
			}
		}
		// something went bad
		catch (IOException e) {
            String msg = la_date.format(new Date()) + " Exception  ServerSocket: " + e + "\n";
			afficher(msg);
		}
	}		
    /*
     * For the GUI to stop the server
     */
	protected void stop() {
		encore = false;
		// connect to myself as Client to exit statement 
		// Socket socket = serverSocket.accept();
		try {
			new Socket("localhost", port);
		}
		catch(Exception e) {
			// nothing I can really do
		}
	}
	/*
	 * afficher an event (not a message) to the console or the GUI
	 */
	private void afficher(String msg) {
		String time = la_date.format(new Date()) + " " + msg;
		if(sg == null)
			System.out.println(time);
		else
			sg.appendEvent(time + "\n");
	}
	/*
	 *  to diffusion_des_msgs a message to all Clients
	 */
	private synchronized void diffusion_des_msgs(String message) {
		// add HH:mm:ss and \n to the message
		String time = la_date.format(new Date());
		String messageLf = time + " " + message + "\n";
		// afficher message on console or GUI
		if(sg == null)
			System.out.print(messageLf);
		else
			sg.appendRoom(messageLf);     // append in the room window
		
		// we loop in reverse order in case we would have to remove a Client
		// because it has disconnected
		for(int i = al.size(); --i >= 0;) {
			ClientThread ct = al.get(i);
			// try to write to the Client if it fails remove it from the list
			if(!ct.writeMsg(messageLf)) {
				al.remove(i);
				afficher("Client decconnecte: " + ct.utilisateur );
			}
		}
	}

	// for a client who logoff using the LOGOUT message
	synchronized void supprimer_le_client(int id) {
		// scan the array list until we found the Id
		for(int i = 0; i < al.size(); ++i) {
			ClientThread ct = al.get(i);
			// found it
			if(ct.id == id) {
				al.remove(i);
				return;
			}
		}
	}
	
	/*
	 *  To run as a console application just open a console window and: 
	 * > java Server
	 * > java Server num_port
	 * If the port number is not specified 1234 is used
	 */ 
	public static void main(String[] args) {
		// start server on port 1234 unless a num_port is specified 
		int num_port = 1234;
		switch(args.length) {
			case 1:
				try {
					num_port = Integer.parseInt(args[0]);
				}
				catch(Exception e) {
					System.out.println("Port invalide.");
					System.out.println(" java Server [num_port]");
					return;
				}
			case 0:
				break;
			default:
				System.out.println("java Server [num_port]");
				return;
				
		}
		// create a server object and start it
		Server server = new Server(num_port);
		server.start();
	}

	/** One instance of this thread will run for each client */
	class ClientThread extends Thread {
		// the socket where to listen/talk
		Socket socket;
		ObjectInputStream sInput;
		ObjectOutputStream sOutput;
		// my unique id (easier for deconnection)
		int id;
		// the utilisateur of the Client
		String utilisateur;
		// the only type of message a will receive
		ChatMessage cm;
		// the date I connect
		String date;

		// Constructore
		ClientThread(Socket socket) {
			// a unique id
			id = ++uniqueId;
			this.socket = socket;
			/* Creating both Data Stream */
			System.out.println("Thread Input/Output Streams");
			try
			{
				// create output first
				sOutput = new ObjectOutputStream(socket.getOutputStream());
				sInput  = new ObjectInputStream(socket.getInputStream());
				// read the utilisateur
				utilisateur = (String) sInput.readObject();
				afficher(utilisateur + " just connected.");
			}
			catch (IOException e) {
				afficher("Exception  new Input/output Streams: " + e);
				return;
			}
			// have to catch ClassNotFoundException
			// but I read a String, I am sure it will work
			catch (ClassNotFoundException e) {
			}
            date = new Date().toString() + "\n";
		}

		// what will run forever
		public void run() {
			// to loop until LOGOUT
			boolean encore = true;
			while(encore) {
				// read a String (which is an object)
				try {
					cm = (ChatMessage) sInput.readObject();
				}
				catch (IOException e) {
					afficher(utilisateur + " Exception lire Streams: " + e);
					break;				
				}
				catch(ClassNotFoundException e2) {
					break;
				}
				// the messaage part of the ChatMessage
				String message = cm.getMessage();

				// Switch on the type of message receive
				switch(cm.getType()) {

				case ChatMessage.MESSAGE:
					diffusion_des_msgs(utilisateur + ": " + message);
					break;
				case ChatMessage.deconnecte:
					afficher(utilisateur + " deconnecte .");
					encore = false;
					break;
				case ChatMessage.qui_est_la:
					writeMsg("List of the users connected at " + la_date.format(new Date()) + "\n");
					// scan al the users connected
					for(int i = 0; i < al.size(); ++i) {
						ClientThread ct = al.get(i);
						writeMsg((i+1) + ") " + ct.utilisateur + " since " + ct.date);
					}
					break;
				}
			}
			// remove myself from the arrayList containing the list of the
			// connected Clients
			supprimer_le_client(id);
			close();
		}
		
		// try to close everything
		private void close() {
			// try to close the connection
			try {
				if(sOutput != null) sOutput.close();
			}
			catch(Exception e) {}
			try {
				if(sInput != null) sInput.close();
			}
			catch(Exception e) {};
			try {
				if(socket != null) socket.close();
			}
			catch (Exception e) {}
		}

		/*
		 * Write a String to the Client output stream
		 */
		private boolean writeMsg(String msg) {
			// if Client is still connected send the message to it
			if(!socket.isConnected()) {
				close();
				return false;
			}
			// write the message to the stream
			try {
				sOutput.writeObject(msg);
			}
			// if an error occurs, do not abort just inform the user
			catch(IOException e) {
				afficher("Erreur d'envoi du message a " + utilisateur);
				afficher(e.toString());
			}
			return true;
		}
	}
}

