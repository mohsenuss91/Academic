import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class client {
    private Socket socket = null;
    private ObjectInputStream inputStream = null;
    private ObjectInputStream inStream = null;
    private boolean isConnected = false;

    public client() {

    }

    public void communicate() {

        while (!isConnected) {
            try {
                socket = new Socket("localHost", 4445);
                System.out.println("Client Connecte");
                isConnected = true;
                
                
                inStream = new ObjectInputStream(socket.getInputStream());
                balle balle_recu = null;
				try {
					balle_recu = (balle) inStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
                balle.lancer_la_balle();
                balle.f.setTitle("Balle client.");
                
                


            } catch (SocketException se) {
                se.printStackTrace();
                // System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        client client = new client();
        client.communicate();
    }
}
