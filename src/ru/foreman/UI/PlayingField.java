package ru.foreman.UI;

import ru.foreman.supportAndInterfase.Controller;
import ru.foreman.supportAndInterfase.FleetNumber;

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
    private int countShipFleet = 22;
    private JLabel northLabel;
    private JLabel southLabel;

    public PlayingField(FleetNumber fleetNumber, Controller controller) {
        super();

        northLabel = new JLabel("Осталось подбить " + countShipFleet);
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

    public void decrementCountShip() {
        countShipFleet--;
    }

//    /**
//     * Test method
//     *
//     * @param arg arg
//     */
//    public static void main(String[] arg) {
//        JFrame frame = new JFrame();
//        PlayingField panel = new PlayingField(FleetNumber.ONE, new LocalGameController(frame, this));
//
//
//        frame.getContentPane().add(panel);
//        frame.setVisible(true);
//        frame.pack();
//
//
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    }

    public void setNorthLabel() {
        northLabel.setText("Осталось подбить " + countShipFleet);
    }


    /* *******************************************************************************************************************/

    public void setSouthLabelLabel(String text) {
        southLabel.setText(text);
    }


}
