package ru.foreman.UI;


import ru.foreman.fleet.Point;

import ru.foreman.localPlay.LocalGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * Поле для ячеек с Грид сеткой 11*11.
 *
 * @author SergeyNF
 * @since 06.18
 */
public class CellPanel extends JPanel {
    private ArrayList<Cell> cellList;
   // Control control = new Control();

    CellPanel() {
        cellList = new ArrayList<>();
        createFieldCells();
    }

    /**
     * Test method
     *
     * @param args arg
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        CellPanel panel = new CellPanel();

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createFieldCells() {
        this.setLayout(new GridLayout(11, 11));

        this.add(new Label());
        for (int i = 1; i < 11; ++i) {

            this.add(createLabel(i));
        }
        for (int j = 1; j < 11; ++j) {
            this.add(createLabel(j));

            for (int i = 1; i < 11; ++i) {
                Cell cell = new Cell(new Point(i, j));
            //    cell.addActionListener(new Control(cell));
                this.add(cell);
                cellList.add(cell);
            }
        }
    }

   /* public Cell  compare (Cell cell){
        return LocalGame.compare(cell);

    }*/



    private JLabel createLabel(int j) {
        String text = Integer.toString(j);
        JLabel label = new JLabel();
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText(text);
        return label;
    }


    ArrayList<Cell> getCellList() {
        return cellList;
    }

    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }
}
