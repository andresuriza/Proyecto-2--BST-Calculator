import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataInputStream in;
    private DataOutputStream out;
    private int port;


    public Server(int port) throws IOException {
        this.port = port;

        ServerSocket server = new ServerSocket(port);
        System.out.println("Client connected");

        while (true) {
            Socket sc = server.accept();
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            //System.out.println(in.readInt()*2);
        }
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server(5000);
    }
}