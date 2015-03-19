import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class Client implements Balle.BallListener
{
    private Socket socket = null;
    private boolean isConnected = false;
//constructeur
    public Client() 
    {

    }
//communication avec le serveur
    public void communicate() 
    {
        while (!isConnected) 
        {
            try {
                	socket = new Socket("localHost", 4445);
                	System.out.println("Client Connecte");
                	isConnected = true;
                	//lancer la balle du client
                	Balle.lancer_la_balle(this);                
                	Balle.f.setTitle("Balle client.");
            	} 
            catch (SocketException se) 
            {
                se.printStackTrace();           
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
//changer la localisation du client
	public void changedLocation(double x, double y) 
	{
		if (socket.isConnected()) 
		{					
			try {
					//envoyer les coordonnees
					socket.getOutputStream().write((int)x);
					socket.getOutputStream().write((int)y);
				}
			catch (IOException e) 
			{			
				e.printStackTrace();
			}						
		}
		
	}
//programme principal
    public static void main(String[] args) 
    {
    	Client client = new Client();
        client.communicate();
    }
}
