
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    //private ObjectOutputStream outputStream = null;


    public Server() {

    }

    public void communicate() {
        try {
            serverSocket = new ServerSocket(4445);
            System.out.println("Serveur demmare..");
            
            socket = serverSocket.accept();
            int x, y;

            Balle ball = Balle.lancer_la_balle();
            
            
            Balle.f.setTitle("Balle serveur.");
            
            while (socket.isConnected()) {
            	
                x = socket.getInputStream().read();
                y = socket.getInputStream().read();
                ball.changeLocation(x, y);
            	
            }

            
            
            
            		
           // outputStream = new ObjectOutputStream(socket.getOutputStream());
           // outputStream.writeObject(balle_env);
            
            
            System.out.println("balle envoye");

            socket.close();

        } catch (SocketException se) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	Server server = new Server();
        server.communicate();
    }
}