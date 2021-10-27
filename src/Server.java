import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void csv_write(String action) throws IOException {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String file_path = "csv_files/operations.csv";

        String expression = "";

        if (action.equals("clear")) {
            FileWriter fw = new FileWriter(file_path, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("");
            pw.flush();
            pw.close();
        } else {
            FileWriter fw = new FileWriter(file_path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(file_path+","+expression+","+date.format(time));
            pw.flush();
            pw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server(5000);
    }
}