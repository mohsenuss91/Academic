

import java.io.IOException;

//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class Client implements Balle.BallListener{
    private Socket socket = null;
    //private ObjectInputStream inputStream = null;
    //private ObjectInputStream inStream = null;
    private boolean isConnected = false;

    public Client() {

    }

    public void communicate() {

    	
        while (!isConnected) {
            try {
                socket = new Socket("localHost", 4445);
                System.out.println("Client Connecte");
                isConnected = true;
                
                Balle.lancer_la_balle(this);
                
                Balle.f.setTitle("Balle client.");




            } catch (SocketException se) {
                se.printStackTrace();
                // System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
	@Override
	public void changedLocation(double x, double y) {
		if (socket.isConnected()) {
			
			
			try {
				socket.getOutputStream().write((int)x);
				socket.getOutputStream().write((int)y);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

    public static void main(String[] args) {
    	Client client = new Client();
        client.communicate();
    }


}
