package ru.foreman.localGame;

import ru.foreman.supportAndInterfase.Controller;
import ru.foreman.UI.Cell;
import ru.foreman.fleet.Fleet;


import javax.swing.*;


public class LocalGameController implements Controller {
    private static Fleet fleet_1;
    private static Fleet fleet_2;
    private static int activeFleet = 1;
    private JFrame frame;

    public LocalGameController(JFrame frame) {
        fleet_1 = new Fleet(1);
        fleet_2 = new Fleet(2);
        this.frame = frame;
    }

    private static boolean checkShoot(Cell cell, int currentFleet) {
        if (currentFleet == fleet_1.getFleetNumber()) {
            return fleet_1.checkAllShipsToHit(cell.getPoint());
        } else {
            return fleet_2.checkAllShipsToHit(cell.getPoint());
        }
    }


    public void compare(Cell cell) {
        int currentFleet = cell.getFleetNumber();
        if (currentFleet == activeFleet) {
            setTextCell(cell, checkShoot(cell, currentFleet));
        } else {
            JOptionPane.showMessageDialog(frame, "Ходит другой игрок");
        }
    }

    private static void setTextCell(Cell cell, boolean resShot) {
        if (resShot) {
            cell.setText("X");

        } else {
            cell.setText("0");
            changeFleet();
        }
    }

    private static void changeFleet() {
        activeFleet = activeFleet == 1 ? 2 : 1;
    }
}
