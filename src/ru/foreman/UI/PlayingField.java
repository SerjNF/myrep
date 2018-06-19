package ru.foreman.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * поле одного игрока
 *
 * @author SergeyNF
 * @since 06.18
 */
public class PlayingField extends JPanel {
    public  ArrayList<Cell> cellList;
    private JLabel northLabel;
    private JLabel southLabel;
    CellPanel cellPanel;

    public PlayingField() {
        super();

        northLabel = new JLabel("north");
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);

        southLabel = new JLabel("south");
        southLabel.setHorizontalAlignment(SwingConstants.CENTER);
        southLabel.setHorizontalAlignment(SwingConstants.CENTER);

        cellPanel = new CellPanel();
        cellList = new ArrayList<>();
        cellList = cellPanel.getCellList();

        this.setLayout(new BorderLayout());
        this.add(northLabel, BorderLayout.NORTH);
        this.add(southLabel, BorderLayout.SOUTH);
        this.add(cellPanel);
    }

    public void setNortLabel(String text) {
        northLabel.setText(text);
    }

    public void setSouthLabelLabel(String text) {
        southLabel.setText(text);
    }

    public ArrayList<Cell> getCellList(){
        return cellList;
 }

 public void lockCellPanel(){
        cellPanel.setVisible(true);
 }

    /* *******************************************************************************************************************/

    /**
     * Test method
     *
     * @param arg arg
     */
    public static void main(String[] arg) {
        JFrame frame = new JFrame();
        PlayingField panel = new PlayingField();

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
