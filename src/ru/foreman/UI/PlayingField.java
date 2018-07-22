package ru.foreman.UI;

import ru.foreman.supportAndInterfase.Controller;
import ru.foreman.localGame.LocalGameController;

import javax.swing.*;
import java.awt.*;
//import java.util.ArrayList;

/**
 * поле одного игрока
 *
 * @author SergeyNF
 * @since 06.18
 */
public class PlayingField extends JPanel {
    private JLabel northLabel;
    private JLabel southLabel;

    public PlayingField(int fleetNumber, Controller controller) {
        super();

        northLabel = new JLabel("north");
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);

        southLabel = new JLabel("south");
        southLabel.setHorizontalAlignment(SwingConstants.CENTER);
        southLabel.setHorizontalAlignment(SwingConstants.CENTER);

        CellPanel cellPanel = new CellPanel(fleetNumber, controller);
//        ArrayList<Cell> cellList = new ArrayList<>();
//        cellList = cellPanel.getCellList();

        this.setLayout(new BorderLayout());
        this.add(northLabel, BorderLayout.NORTH);
        this.add(southLabel, BorderLayout.SOUTH);
        this.add(cellPanel);
    }

    public void setNorthLabel(String text) {
        northLabel.setText(text);
    }

    public void setSouthLabelLabel(String text) {
        southLabel.setText(text);
    }


    /* *******************************************************************************************************************/

    /**
     * Test method
     *
     * @param arg arg
     */
    public static void main(String[] arg) {
        JFrame frame = new JFrame();
        PlayingField panel = new PlayingField(1, new LocalGameController(frame));


        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
