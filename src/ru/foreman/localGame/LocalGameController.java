package ru.foreman.localGame;

import ru.foreman.supportAndInterfase.Controller;
import ru.foreman.UI.Cell;
import ru.foreman.fleet.Fleet;
import ru.foreman.supportAndInterfase.FleetNumber;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class LocalGameController implements Controller {
    private FleetNumber activeFleet = FleetNumber.ONE;
    //   private JFrame frame;
    private LocalGame localGame;
    private HashMap<FleetNumber, Fleet> fleet = new HashMap<>();

    LocalGameController(/*JFrame frame, */LocalGame localGame) {
        fleet.put(FleetNumber.ONE, new Fleet(FleetNumber.ONE));
        fleet.put(FleetNumber.TWO, new Fleet(FleetNumber.TWO));
        //      this.frame = frame;
        this.localGame = localGame;
    }

    private boolean isCheckShoot(Cell cell, FleetNumber currentFleet) {
        return fleet.get(currentFleet).checkAllShipsToHit(cell.getPoint());
    }

    public void compare(ActionEvent e) {
        Cell cell = (Cell) e.getSource();

        FleetNumber currentFleet = cell.getFleetNumber();
        if (currentFleet == activeFleet) {
            boolean checkShoot = isCheckShoot(cell, currentFleet);
            setTextCell(cell, checkShoot, currentFleet);
        } else {
            localGame.showMessage();
        }
    }

    private void setTextCell(Cell cell, boolean resShot, FleetNumber currentFleet) {
        if (resShot) {
            cell.setResult("X");
            if (currentFleet == FleetNumber.ONE) {
                localGame.setLabelPlayer1();
            } else {
                localGame.setLabelPlayer2();
            }

        } else {
            cell.setResult("0");
            changeFleet();
        }
    }

    private void changeFleet() {
        activeFleet = activeFleet == FleetNumber.ONE ? FleetNumber.TWO : FleetNumber.ONE;
    }
}
