package ru.foreman.UI;


import ru.foreman.supportAndInterfase.Point;

import ru.foreman.supportAndInterfase.Controller;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Поле для ячеек с Грид сеткой 11*11.
 *
 * @author SergeyNF
 * @since 06.18
 */
public class CellPanel extends JPanel {
    private ArrayList<Cell> cellList;
    Controller controller;


    CellPanel(int fleetNumber, Controller controller) {
        cellList = new ArrayList<>();
        createFieldCells(fleetNumber);
        this.controller = controller;
    }

    private void createFieldCells(int fleetNumber) {
        this.setLayout(new GridLayout(11, 11));

        this.add(new Label());
        for (int i = 1; i < 11; ++i) {

            this.add(createLabel(i));
        }
        for (int j = 1; j < 11; ++j) {
            this.add(createLabel(j));

            for (int i = 1; i < 11; ++i) {
                Cell cell = new Cell(new Point(i, j), fleetNumber);
                cell.addActionListener(e -> compare(cell));
                this.add(cell);
                cellList.add(cell);
            }
        }
    }

    private void compare(Cell cell){
        controller.compare(cell);

    }



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
