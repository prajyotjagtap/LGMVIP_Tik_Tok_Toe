import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

	JButton restartButton = new JButton("Restart");
	
	Frame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel titleLabel = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;

    TicTacToe() {
    	restartButton.setFont(new Font("Arial", Font.PLAIN, 20));
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);
        
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(restartButton);
        titlePanel.add(titleLabel);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    	
    	
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        ((JFrame) frame).getContentPane().setBackground(new Color(0, 102, 102));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        titleLabel.setBackground(new Color(0, 76, 153));
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setText("Tic-Tac-Toe");
        titleLabel.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(0, 102, 102));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(238, 238, 238)); 
            buttons[i].addActionListener(this);
        }

        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == restartButton) {
            restartGame();
        }
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        titleLabel.setText("O's Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        titleLabel.setText("X's Turn");
                        check();
                    }
                }
            }
        }
    }
    
    
    public void restartGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(new Color(238, 238, 238));
            buttons[i].setEnabled(true);
        }
        
        titleLabel.setText("Tic-Tac-Toe");
        firstTurn();
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player1Turn = (Math.random() < 0.5);
        titleLabel.setText(player1Turn ? "X's Turn" : "O's Turn");
    }

    public void check() {
        // check X win conditions
        if (buttons[0].getText().equals("X") &&
            buttons[1].getText().equals("X") &&
            buttons[2].getText().equals("X")) {
            xWins(0, 1, 2);
        }
        if (buttons[3].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[5].getText().equals("X")) {
            xWins(3, 4, 5);
        }
        if (buttons[6].getText().equals("X") &&
            buttons[7].getText().equals("X") &&
            buttons[8].getText().equals("X")) {
            xWins(6, 7, 8);
        }
        if (buttons[0].getText().equals("X") &&
            buttons[3].getText().equals("X") &&
            buttons[6].getText().equals("X")) {
            xWins(0, 3, 6);
        }
        if (buttons[1].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[7].getText().equals("X")) {
            xWins(1, 4, 7);
        }
        if (buttons[2].getText().equals("X") &&
            buttons[5].getText().equals("X") &&
            buttons[8].getText().equals("X")) {
            xWins(2, 5, 8);
        }
        if (buttons[0].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[8].getText().equals("X")) {
            xWins(0, 4, 8);
        }
        if (buttons[2].getText().equals("X") &&
            buttons[4].getText().equals("X") &&
            buttons[6].getText().equals("X")) {
            xWins(2, 4, 6);
        }

        // check O win conditions
        if (buttons[0].getText().equals("O") &&
            buttons[1].getText().equals("O") &&
            buttons[2].getText().equals("O")) {
            oWins(0, 1, 2);
        }
        if (buttons[3].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[5].getText().equals("O")) {
            oWins(3, 4, 5);
        }
        if (buttons[6].getText().equals("O") &&
            buttons[7].getText().equals("O") &&
            buttons[8].getText().equals("O")) {
            oWins(6, 7, 8);
        }
        if (buttons[0].getText().equals("O") &&
            buttons[3].getText().equals("O") &&
            buttons[6].getText().equals("O")) {
            oWins(0, 3, 6);
        }
        if (buttons[1].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[7].getText().equals("O")) {
            oWins(1, 4, 7);
        }
        if (buttons[2].getText().equals("O") &&
            buttons[5].getText().equals("O") &&
            buttons[8].getText().equals("O")) {
            oWins(2, 5, 8);
        }
        if (buttons[0].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[8].getText().equals("O")) {
            oWins(0, 4, 8);
        }
        if (buttons[2].getText().equals("O") &&
            buttons[4].getText().equals("O") &&
            buttons[6].getText().equals("O")) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        titleLabel.setText("X wins");
    }

    public void oWins(int a, int b, int c) {


        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        titleLabel.setText("O wins");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new TicTacToe());
    }
}