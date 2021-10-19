import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Calculator {
    private DataInputStream in;
    private DataOutputStream out;

    public Calculator(int number) throws IOException {
        /*
        Socket sc = new Socket("localhost", 5000);
        System.out.println("Connected");
        in = new DataInputStream(sc.getInputStream());
        out = new DataOutputStream(sc.getOutputStream());
         */

        JFrame window = new JFrame("Calculator");
        window.setResizable(false);
        window.setLayout(null);
        window.setSize(330,590);


        JPanel button_area = new JPanel();
        button_area.setBackground(new Color(255, 43, 163, 236));
        button_area.setSize(100,100);
        button_area.setLocation(50,50);

        window.add(button_area);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //out.writeInt(number);
    }

    public static void main(String[] args) throws IOException {
        Calculator C1 = new Calculator(1);
    }
}