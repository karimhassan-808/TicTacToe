import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int windowHeight = 650;
    int windowWidth = 600;

    JFrame frame = new JFrame("Tic Tac Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel controlPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    JButton restartButton = new JButton("Restart");

    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameFinished = false;
    int turns = 0;

    public TicTacToe() {
        frame.setVisible(true);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Text label
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic Tac Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);

        frame.add(textPanel, BorderLayout.NORTH);

        // Board panel
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.BLACK);
        frame.add(boardPanel, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tile = new JButton();
                board[i][j] = tile;
                boardPanel.add(tile);
                tile.setBackground(Color.BLACK);
                tile.setForeground(Color.RED);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameFinished) return;

                        JButton tile = (JButton) e.getSource();

                        if (tile.getText().equals("")) {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();

                            if (!gameFinished) {
                                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s Turn");
                            }
                        }
                    }
                });
            }
        }

        // Control panel with Restart button
        restartButton.setFocusable(false);
        restartButton.setFont(new Font("Arial", Font.BOLD, 18));
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(restartButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
    }

    void checkWinner() {
        // Horizontal
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equals("")) continue;

            if (board[i][0].getText().equals(board[i][1].getText())
                    && board[i][1].getText().equals(board[i][2].getText())) {
                for (int j = 0; j < 3; j++) setWinner(board[i][j]);
                gameFinished = true;
                return;
            }
        }

        // Vertical
        for (int i = 0; i < 3; i++) {
            if (board[0][i].getText().equals("")) continue;

            if (board[0][i].getText().equals(board[1][i].getText())
                    && board[1][i].getText().equals(board[2][i].getText())) {
                for (int j = 0; j < 3; j++) setWinner(board[j][i]);
                gameFinished = true;
                return;
            }
        }

        // Diagonal
        if (!board[1][1].getText().equals("")
                && board[0][0].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][2].getText())) {
            for (int i = 0; i < 3; i++) setWinner(board[i][i]);
            gameFinished = true;
            return;
        }

        // Anti-diagonal
        if (!board[1][1].getText().equals("")
                && board[0][2].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][0].getText())) {
            for (int i = 0; i < 3; i++) setWinner(board[i][2 - i]);
            gameFinished = true;
            return;
        }

        // Tie
        if (turns == 9) {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    setTie(board[i][j]);

            gameFinished = true;
            textLabel.setText("It's a Tie.");
        }
    }

    void setWinner(JButton tile) {
        tile.setBackground(Color.WHITE);
        tile.setForeground(Color.GREEN);
        textLabel.setText(currentPlayer + " is the Winner!");
    }

    void setTie(JButton tile) {
        tile.setBackground(Color.LIGHT_GRAY);
        tile.setForeground(Color.YELLOW);
    }

    void resetGame() {
        currentPlayer = playerX;
        gameFinished = false;
        turns = 0;
        textLabel.setText("Tic Tac Toe");

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
                board[i][j].setBackground(Color.BLACK);
                board[i][j].setForeground(Color.RED);
            }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
