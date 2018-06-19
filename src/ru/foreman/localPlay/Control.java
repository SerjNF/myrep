package ru.foreman.localPlay;

import ru.foreman.UI.Cell;
import ru.foreman.UI.CellPanel;
import ru.foreman.fleet.Point;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
    private Cell cell;
    public Control(Cell cell){
        this.cell = cell;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        CellPanel.
        cell.setText("X");
        System.out.printf("%d / %d%n", cell.getPoint().getX(), cell.getPoint().getY());
    }


}

