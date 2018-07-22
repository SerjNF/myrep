package ru.foreman.localGame;

import ru.foreman.UI.PlayingField;
import ru.foreman.supportAndInterfase.Controller;

import javax.swing.*;
import java.awt.*;

public class LocalGame  {

    private LocalGame() {

        JFrame frame = new JFrame("Локальная игра");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));

        Controller controller = new LocalGameController(frame);
        PlayingField playerOne = new PlayingField(1, controller);
        PlayingField playerTwo = new PlayingField(2, controller);

        frame.getContentPane().add(playerOne);
        frame.getContentPane().add(playerTwo);

        frame.setVisible(true);
        frame.pack();
    }







    /* ******************************************************************************************************************/

    /**
     * test method
     *
     * @param arg arg
     */
    public static void main(String[] arg) {
        LocalGame localGame = new LocalGame();

    }


}
