import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectOutputStream outputStream = null;


    public server() {

    }

    public void communicate() {
        try {
            serverSocket = new ServerSocket(4445);
            System.out.println("Serveur demmare..");
            
            socket = serverSocket.accept();
            
            balle balle_env= new balle();
          
            balle.lancer_la_balle();
            balle.f.setTitle("Balle serveur.");
            
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(balle_env);
            System.out.println("balle envoye");
                        
            socket.close();

        } catch (SocketException se) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        server server = new server();
        server.communicate();
    }
}
