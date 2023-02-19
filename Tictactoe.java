import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Tictactoe extends JFrame implements ActionListener {
    private JButton cell, reset;
    private int i, j, x = 100, y = 100;
    private String player1, player2, curr_player, icon, msg = "", clickedBtnNum;
    private String cells[][] = { { "_", "_", "_" },
            { "_", "_", "_" },
            { "_", "_", "_" } };
    private JLabel display;
    private boolean over = false, draw = true;

    public Tictactoe() {
        setLayout(null);
        setSize(520, 550);

        player1 = getPlayerName("Enter player 1 name:");
        player2 = getPlayerName("Enter player 2 name:");

        if (player1.equals(""))
            player1 = "guest1";
        if (player2.equals(""))
            player2 = "guest2";

        curr_player = player1;
        int num = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                cell = new JButton();
                cell.addActionListener(this);
                cell.setBounds(x, y, 100, 100);
                cell.setActionCommand(String.valueOf(num));
                x += 100;
                num++;
                add(cell);
            }
            x = 100;
            y += 100;
        }
        display = new JLabel(msg);
        display.setBounds(180, 400, 200, 50);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setForeground(Color.red);

        reset = new JButton("Rstart");
        reset.addActionListener(this);
        reset.setBounds(200, 450, 80, 30);
        add(display);
        add(reset);

    }

    private String getPlayerName(String message) {
        String name = JOptionPane.showInputDialog(this, message);
        return name;
    }

    public void switchPlayer() {
        if (curr_player.equals(player1))
            curr_player = player2;
        else if (curr_player.equals(player2))
            curr_player = player1;
    }

    public void updateCellList(String num, String txt) {
        int index = Integer.parseInt(num);
        int row = index / 3;
        int col = index % 3;

        cells[row][col] = txt;
    }

    public void setIcon() {
        if (curr_player.equals(player1))
            icon = "X";
        else if (curr_player.equals(player2))
            icon = "O";
    }

    public void checkGameState() {
        // horizonntal check
        for (i = 0; i < 3; i++) {
            if (!cells[i][0].equals("_") && cells[i][0].equals(cells[i][1]) && cells[i][0].equals(cells[i][2]))
                over = true;
        }
        // vertical check
        for (i = 0; i < 3; i++) {
            if (!cells[0][i].equals("_") && cells[0][i].equals(cells[1][i]) && cells[0][i].equals(cells[2][i]))
                over = true;
        }
        // diagonal check
        for (i = 0; i < 3; i++) {
            if (!cells[0][0].equals("_") && cells[0][0].equals(cells[1][1]) && cells[0][0].equals(cells[2][2]))
                over = true;
            else if (!cells[0][2].equals("_") && cells[0][2].equals(cells[1][1]) && cells[0][2].equals(cells[2][0]))
                over = true;
        }

        if (over) {
            dispMsg("Player " + curr_player + " wins!");
            toggleButtons(false);
        } else {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (cells[i][j].equals("_")) {
                        draw = false;
                    }
                }
            }
            if (draw)
                dispMsg("Draw");
        }
    }

    public void resetState() {
        cells = new String[][] {
                { "_", "_", "_" },
                { "_", "_", "_" },
                { "_", "_", "_" }
        };
        dispMsg("");
        over = false;
        draw = true;
        curr_player = player1;
        toggleButtons(true);
    }

    public void toggleButtons(boolean state) {
        for (Component c : getContentPane().getComponents()) {
            if (c instanceof JButton && c != reset) {
                JButton b = (JButton) c;
                b.setText("");
                b.setEnabled(state);
            }
        }
    }

    public void dispMsg(String message) {
        display.setText(message);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();
        clickedBtnNum = e.getActionCommand();

        if (e.getSource() == reset) {
            resetState();
            return;
        }

        clickedBtn.setEnabled(false);
        setIcon();
        clickedBtn.setText(icon);
        updateCellList(clickedBtnNum, icon);
        checkGameState();
        switchPlayer();
    }

    public static void main(String args[]) {
        JFrame game = new Tictactoe();
        game.setVisible(true);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}