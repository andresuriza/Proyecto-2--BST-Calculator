import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Andres Uriza
 * @author Jose Pablo Esquetini
 *
 * This class creates a server that can take the expressions from the client and evaluate them using the expression
 * tree class
 */
public class Server {
    private DataInputStream in;
    private DataOutputStream out;
    private int port;

    /**
     * Constructor method
     * @param port
     * @throws IOException
     */
    public Server(int port) throws IOException {
        this.port = port;

        ServerSocket server = new ServerSocket(port);




        while (true) {
            Socket sc = server.accept();
            csv_write("clear",null);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            while (true) {
                String exp = null;
                try {
                    exp = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    csv_write("write",exp);
                    out.writeUTF(exp + "CALCULATED");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //ExpressionTree result = new ExpressionTree(in.readUTF());

        }
    }






    /**
     * Writes into the csv file
     * @param action
     * @param operation
     * @throws IOException
     */
    public void csv_write(String action, String operation) throws IOException {
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
            pw.println(operation + "," + "result" + "," + date.format(time));
            pw.flush();
            pw.close();
        }
    }

    /**
     * Main function that creates a server
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Server s = new Server(5000);
    }
}