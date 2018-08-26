package ru.foreman.localGame;

import ru.foreman.UI.PlayingField;
import ru.foreman.supportAndInterfase.Controller;
import ru.foreman.supportAndInterfase.FleetNumber;

import javax.swing.*;
import java.awt.*;

public class LocalGame {
    private PlayingField playerOne;
    private PlayingField playerTwo;
    private JFrame frame;

    private LocalGame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.frame = new JFrame("Локальная игра");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new GridLayout(1, 3));

        Controller localGame = new LocalGameController(/*frame, */this);
        playerOne = new PlayingField(FleetNumber.ONE, localGame);
        playerTwo = new PlayingField(FleetNumber.TWO, localGame);

        this.frame.getContentPane().add(playerOne);
        //  frame.getContentPane().add(new JPanel());
        this.frame.getContentPane().add(playerTwo);
        // this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setSize(1000, 500);
        this.frame.setResizable(false);
        //  this.frame.pack();
    }

    void setLabelPlayer1() {
        playerOne.decrementCountShip();
        playerOne.setNorthLabel();
    }

    void setLabelPlayer2() {
        playerTwo.decrementCountShip();
        playerTwo.setNorthLabel();
    }

    void showMessage() {
        JOptionPane.showMessageDialog(frame, "не ты ходишь, передай мышку!!!");
    }









    /* ******************************************************************************************************************/

    /**
     * test method
     *
     * @param arg arg
     */
    public static void main(String[] arg) {
        SwingUtilities.invokeLater(() -> {
            LocalGame localGame = new LocalGame();
        });
    }

}



