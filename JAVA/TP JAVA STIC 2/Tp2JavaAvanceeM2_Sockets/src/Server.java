import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server 
{
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    //private ObjectOutputStream outputStream = null;

//constructeur 
    public Server() 
    {

    }
//communication
    public void communicate() 
    {
        try {
            //creer serverSocket
        	serverSocket = new ServerSocket(4445);
            System.out.println("Serveur demmare..");
            
            //accepter les clients
            socket = serverSocket.accept();
            int x, y;
            //lancer la balle du serveur
            Balle ball = Balle.lancer_la_balle();                       
            Balle.f.setTitle("Balle serveur.");
            
            //en cas de connexion recuperer les informations du client
            while (socket.isConnected()) 
            {            	
                x = socket.getInputStream().read();
                y = socket.getInputStream().read();
                //changer la position de la balle
                ball.changeLocation(x, y);            	
            }            
            System.out.println("balle envoye");
            socket.close();

        } 
        catch (SocketException se) 
        {
            System.exit(0);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
//programme principal
    public static void main(String[] args) 
    {
    	Server server = new Server();
        server.communicate();
    }
    
}