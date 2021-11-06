import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calculator {
    private DataInputStream in;
    private DataOutputStream out;
    private JTextField operationField;
    private String operand = "";
    private String operator = "";
    private String currentData = "first";
    private String operation = "";

    public Calculator(int number) throws UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        /*
        Socket sc = new Socket("localhost", 5000);
        System.out.println("Connected");
        in = new DataInputStream(sc.getInputStream());
        out = new DataOutputStream(sc.getOutputStream());
         */

        JFrame window = new JFrame("Calculator" + number);
        window.setResizable(false);
        window.setSize(330, 590);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JPanel button_area = new JPanel();

        operationField = new JTextField(30);
        operationField.setEditable(false);

        JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, addButton,
                minusButton, multiplyButton, divideButton, moduleButton, equalsButton, leftPar, rightPar, clear;

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
                button_logic(" + ", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        minusButton.addActionListener(e -> {
            try {
                button_logic(" - ", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        multiplyButton.addActionListener(e -> {
            try {
                button_logic(" * ", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        divideButton.addActionListener(e -> {
            try {
                button_logic(" / ", "operator");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        moduleButton.addActionListener(e -> {
            try {
                button_logic(" % ", "operator");
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
                button_logic("( ", "operand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        rightPar.addActionListener(e -> {
            try {
                button_logic(" )", "operand");
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


        window.add(button_area);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void button_logic(String value, String function) throws IOException {
        if (function.equals("result")) {
            System.out.println(operationField.getText());

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

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {

        Calculator C1 = new Calculator(1);

        /*
        public void thread_the_creator() {
            new Thread(() -> {
                // code
            }).start();
        }
         */
    }
}