import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*
 * The Client with its GUI
 */
public class ClientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// will first hold "Username:", later on "Enter message"
	private JLabel label;
	// to hold the Username and later on the messages
	private JTextField tf;
	// to hold the server address an the port number
	private JTextField tfServer, tfPort;
	// to deconnexion and get the list of the users
	private JButton connexion, deconnexion, membres;
	// for the chat room
	private JTextArea ta;
	// if it is for connection
	private boolean connected;
	// the Client object
	private Client client;
	// the default port number
	private int defaultPort;
	private String defaultHost;

	// Constructor connection receiving a socket number
	ClientGUI(String host, int port) {

		super("Chat Client");
		defaultPort = port;
		defaultHost = host;
		
		// The NorthPanel with:
		JPanel northPanel = new JPanel(new GridLayout(3,1));
		// the server name anmd the port number
		JPanel serverAndPort = new JPanel(new GridLayout(1,5, 1, 3));
		// the two JTextField with default value for server address and port number
		tfServer = new JTextField(host);
		tfPort = new JTextField("" + port);
		tfPort.setHorizontalAlignment(SwingConstants.RIGHT);

		serverAndPort.add(new JLabel("Adresse du serveur:"));
		serverAndPort.add(tfServer);
		serverAndPort.add(new JLabel("Num\u00E9ro de port:"));
		serverAndPort.add(tfPort);
		serverAndPort.add(new JLabel(""));
		// adds the Server an port field to the GUI
		northPanel.add(serverAndPort);

		// the Label and the TextField
		label = new JLabel("Entrer votre nom d'utilisateur", SwingConstants.CENTER);
		northPanel.add(label);
		tf = new JTextField("nom d'utilisateur");
		tf.setBackground(Color.WHITE);
		northPanel.add(tf);
		getContentPane().add(northPanel, BorderLayout.NORTH);

		// The CenterPanel which is the chat room
		ta = new JTextArea("Bienvenue\n", 80, 80);
		JPanel centerPanel = new JPanel(new GridLayout(1,1));
		centerPanel.add(new JScrollPane(ta));
		ta.setEditable(false);
		getContentPane().add(centerPanel, BorderLayout.CENTER);

		// the 3 buttons
		connexion = new JButton("Connexion");
		connexion.addActionListener(this);
		deconnexion = new JButton("Deconnexion");
		deconnexion.addActionListener(this);
		deconnexion.setEnabled(false);		// you have to connexion before being able to deconnexion
		membres = new JButton("Membres connectes");
		membres.addActionListener(this);
		membres.setEnabled(false);		// you have to connexion before being able to Who is in

		JPanel southPanel = new JPanel();
		southPanel.add(connexion);
		southPanel.add(deconnexion);
		southPanel.add(membres);
		getContentPane().add(southPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(408, 276);
		setVisible(true);
		tf.requestFocus();

	}

	// called by the Client to append text in the TextArea 
	void append(String str) {
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}
	// called by the GUI is the connection failed
	// we reset our buttons, label, textfield
	void connectionFailed() {
		connexion.setEnabled(true);
		deconnexion.setEnabled(false);
		membres.setEnabled(false);
		label.setText("Entrer votre nom d'utilisateur");
		tf.setText("nom d'utilisateur");
		// reset port number and host name as a construction time
		tfPort.setText("" + defaultPort);
		tfServer.setText(defaultHost);
		// let the user change them
		tfServer.setEditable(false);
		tfPort.setEditable(false);
		// don't react to a <CR> after the username
		tf.removeActionListener(this);
		connected = false;
	}
		
	/*
	* Button or JTextField clicked
	*/
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// if it is the deconnexion button
		if(o == deconnexion) {
			client.envoyer_le_message(new ChatMessage(ChatMessage.deconnecte, ""));
			return;
		}
		// if it the who is in button
		if(o == membres) {
			client.envoyer_le_message(new ChatMessage(ChatMessage.qui_est_la, ""));				
			return;
		}

		// ok it is coming from the JTextField
		if(connected) {
			// just have to send the message
			client.envoyer_le_message(new ChatMessage(ChatMessage.MESSAGE, tf.getText()));				
			tf.setText("");
			return;
		}
		

		if(o == connexion) {
			// ok it is a connection request
			String username = tf.getText().trim();
			// empty username ignore it
			if(username.length() == 0)
				return;
			// empty serverAddress ignore it
			String server = tfServer.getText().trim();
			if(server.length() == 0)
				return;
			// empty or invalid port numer, ignore it
			String portNumber = tfPort.getText().trim();
			if(portNumber.length() == 0)
				return;
			int port = 0;
			try {
				port = Integer.parseInt(portNumber);
			}
			catch(Exception en) {
				return;   // nothing I can do if port number is not valid
			}

			// try creating a new Client with GUI
			client = new Client(server, port, username, this);
			// test if we can start the Client
			if(!client.start()) 
				return;
			tf.setText("");
			label.setText("Enter votre message:");
			connected = true;
			
			// disable connexion button
			connexion.setEnabled(false);
			// enable the 2 buttons
			deconnexion.setEnabled(true);
			membres.setEnabled(true);
			// disable the Server and Port JTextField
			tfServer.setEditable(false);
			tfPort.setEditable(false);
			// Action listener for when the user enter a message
			tf.addActionListener(this);
		}

	}

	// to start the whole thing the server
	public static void main(String[] args) {
		new ClientGUI("localhost", 1234);
	}

}
