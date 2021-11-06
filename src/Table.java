import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Andres Uriza
 * @author Jose Pablo Esquetini
 *
 * Class that creates a table to display csv values
 */
public class Table {
    private String[][] rows;

    /**
     * Constructor method
     *
     * @throws IOException
     */
    public Table() throws IOException {
        Scanner csv_reader = new Scanner(new File("csv_files/operations.csv"));
        csv_reader.useDelimiter(",");
        while (csv_reader.hasNext()) {
            csv_reader.next();
        }
        csv_reader.close();

        JFrame op_window = new JFrame();
        op_window.setSize(500, 500);
        op_window.setResizable(false);

        op_window.setTitle("Operations history for");


        String[] columns = {"No.", "Operation", "Result", "Date processed"};

        JTable op_table = new JTable(rows, columns);

        JScrollPane sp = new JScrollPane(op_table);
        op_window.add(sp);

        op_window.setVisible(true);

    }
}