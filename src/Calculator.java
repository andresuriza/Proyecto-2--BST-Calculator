import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * @author Andres Uriza
 * @author Jose Pablo Esquetini
 * <p>
 * This class creates an interface as well as a client to connect to a server, its funcionality is based on a calculator
 */
public class Calculator {
    private DataInputStream in;
    private DataOutputStream out;
    private JTextField operationField;
    private String operand = "";
    private String operator = "";
    private String currentData = "first";
    private String operation = "";

    /**
     * Constructor method
     *
     * @param number
     * @throws UnsupportedLookAndFeelException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public Calculator(int number) throws UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {

        Socket sc = new Socket("localhost", 5000);
        System.out.println("Connected");
        in = new DataInputStream(sc.getInputStream());
        out = new DataOutputStream(sc.getOutputStream());

        JFrame window = new JFrame("Calculator" + number);
        window.setResizable(false);
        window.setSize(330, 590);
        window.setLayout(null);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JPanel button_area = new JPanel();
        button_area.setBounds(10, 0, 300, 200);

        operationField = new JTextField(25);
        operationField.setEditable(false);

        JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, addButton,
                minusButton, multiplyButton, divideButton, moduleButton, equalsButton, leftPar, rightPar, clear, history;

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        addButton = new JButton("+");
        minusButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        moduleButton = new JButton("%");
        equalsButton = new JButton("=");
        leftPar = new JButton("(");
        rightPar = new JButton(")");
        clear = new JButton("C");
        history = new JButton("History");


        button0.addActionListener(e -> {
            try {
                button_logic("0", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button1.addActionListener(e -> {
            try {
                button_logic("1", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button2.addActionListener(e -> {
            try {
                button_logic("2", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button3.addActionListener(e -> {
            try {
                button_logic("3", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button4.addActionListener(e -> {
            try {
                button_logic("4", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button5.addActionListener(e -> {
            try {
                button_logic("5", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button6.addActionListener(e -> {
            try {
                button_logic("6", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button7.addActionListener(e -> {
            try {
                button_logic("7", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button8.addActionListener(e -> {
            try {
                button_logic("8", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button9.addActionListener(e -> {
            try {
                button_logic("9", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        addButton.addActionListener(e -> {
            try {
                button_logic("+", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        minusButton.addActionListener(e -> {
            try {
                button_logic("-", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        multiplyButton.addActionListener(e -> {
            try {
                button_logic("*", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        divideButton.addActionListener(e -> {
            try {
                button_logic("/", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        moduleButton.addActionListener(e -> {
            try {
                button_logic("%", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        equalsButton.addActionListener(e -> {
            try {
                button_logic("=", "result");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        leftPar.addActionListener(e -> {
            try {
                button_logic("(", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        rightPar.addActionListener(e -> {
            try {
                button_logic(")", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        clear.addActionListener(e -> {
            try {
                button_logic("C", "clear");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button_area.add(operationField);

        button_area.add(button0);
        button_area.add(button1);
        button_area.add(button2);
        button_area.add(button3);
        button_area.add(button4);
        button_area.add(button5);
        button_area.add(button6);
        button_area.add(button7);
        button_area.add(button8);
        button_area.add(button9);
        button_area.add(addButton);
        button_area.add(minusButton);
        button_area.add(multiplyButton);
        button_area.add(divideButton);
        button_area.add(moduleButton);
        button_area.add(equalsButton);
        button_area.add(leftPar);
        button_area.add(rightPar);
        button_area.add(clear);


        window.add(history);
        history.setBounds(90, 500, 150, 40);

        window.add(button_area);

        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Interprets the button input into an infix operation
     *
     * @param value
     * @param function
     * @throws IOException
     */
    public void button_logic(String value, String function) throws IOException {
        if (function.equals("result")) {
            thread_the_creator();

        } else if (function.equals("clear")) {
            currentData = "first";
            operand = "";
            operator = "";
            operation = "";
        } else {
            switch (currentData) {
                case "first":
                    if (function.equals("operand")) {
                        operation = operation + value;
                        currentData = "operand";
                    }
                    break;
                case "operand":
                    if (function.equals("operand")) {
                        operation = operation + value;
                    } else {
                        operator = value;
                        operation = operation + value;
                        currentData = "operand";
                    }
                    break;
            }
        }
        operationField.setText(operation);
    }

    /**
     * Creates threads
     */
    public void thread_the_creator() {
        new Thread(() -> {
            try {
                out.writeUTF(operationField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                operationField.setText(in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Main function that creates instances of calculators
     *
     * @param args
     * @throws UnsupportedLookAndFeelException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        Calculator C1 = new Calculator(1);
    }
}
