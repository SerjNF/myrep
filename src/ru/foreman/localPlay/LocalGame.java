package ru.foreman.localPlay;

import ru.foreman.UI.Cell;
import ru.foreman.UI.PlayingField;
import ru.foreman.fleet.Fleet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LocalGame extends JFrame {
   // private static PlayingField playerOne;
    PlayingField playerOne;
    PlayingField playerTwo;
    static Fleet plOne;
    Fleet plTwo;
    static Boolean res;


    LocalGame() {
        super("Локальная игра");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 2));

        playerOne = new PlayingField();
        playerTwo = new PlayingField();




        // playerOne.getCellList();

        this.getContentPane().add(playerOne);
        this.getContentPane().add(playerTwo);

        plOne = new Fleet();
        plTwo = new Fleet();

        setVisible(true);
        pack();
    }

    public static void compare(Cell cell) {
        boolean result;
        if (plOne.checkAllShipsForHit(cell.getPoint())) result = true;
        else result = false;


        System.out.printf("%d / %d%n", cell.getPoint().getX(), cell.getPoint().getY());


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
