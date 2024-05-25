package sudoku_solver;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class gui2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField[] fields;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gui2 frame = new gui2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public gui2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 730);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(66, 165, 871, 377);
        contentPane.add(panel);
        panel.setLayout(null);
        fields = new JTextField[81];
        int index = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                fields[index] = new JTextField();
                fields[index].setBounds(10 + col * 95, 10 + row * 40, 85, 32);
                fields[index].setHorizontalAlignment(JTextField.CENTER);  // Align text to the center
                fields[index].setFont(new Font("Default", Font.BOLD, 18));  // Set font to bold and size to 18
                panel.add(fields[index]);
                fields[index].setColumns(10);
                index++;
            }
        }


        addSeparators(panel);

        JButton btnSolve = new JButton("Solve");
        btnSolve.setFont(new Font("Tahoma", Font.BOLD, 21));
        btnSolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[][] board = new char[9][9];
                for (int i = 0; i < 81; i++) {
                    String text = fields[i].getText();
                    board[i / 9][i % 9] = text.isEmpty() ? '.' : text.charAt(0);
                }

                Solution solver = new Solution();
                solver.solveSudoku(board);

                for (int i = 0; i < 81; i++) {
                    fields[i].setText(board[i / 9][i % 9] == '.' ? "" : String.valueOf(board[i / 9][i % 9]));
                }
            }
        });
        btnSolve.setBounds(422, 590, 145, 34);
        contentPane.add(btnSolve);
        
        JLabel lblNewLabel = new JLabel("Sudoku Solver");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(213, 31, 589, 96);
        contentPane.add(lblNewLabel);
    }

    private void addSeparators(JPanel panel) {
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBackground(new Color(0, 0, 0));
        separator.setForeground(new Color(0, 0, 0));
        separator.setBounds(289, 5, 6, 368);
        panel.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setForeground(Color.BLACK);
        separator_1.setBackground(Color.BLACK);
        separator_1.setBounds(574, 5, 6, 367);
        panel.add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setOrientation(SwingConstants.VERTICAL);
        separator_2.setForeground(Color.BLACK);
        separator_2.setBackground(Color.BLACK);
        separator_2.setBounds(858, 5, 6, 368);
        panel.add(separator_2);

        JSeparator separator_3 = new JSeparator();
        separator_3.setOrientation(SwingConstants.VERTICAL);
        separator_3.setForeground(Color.BLACK);
        separator_3.setBackground(Color.BLACK);
        separator_3.setBounds(5, 5, 6, 368);
        panel.add(separator_3);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBackground(new Color(0, 0, 0));
        separator_4.setBounds(6, 370, 853, 2);
        panel.add(separator_4);

        JSeparator separator_5 = new JSeparator();
        separator_5.setBackground(Color.BLACK);
        separator_5.setBounds(5, 244, 853, 2);
        panel.add(separator_5);

        JSeparator separator_6 = new JSeparator();
        separator_6.setBackground(Color.BLACK);
        separator_6.setBounds(5, 124, 853, 2);
        panel.add(separator_6);

        JSeparator separator_7 = new JSeparator();
        separator_7.setBackground(Color.BLACK);
        separator_7.setBounds(5, 5, 853, 2);
        panel.add(separator_7);
    }
}
