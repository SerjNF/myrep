package ru.foreman.UI;

import ru.foreman.supportAndInterfase.FleetNumber;
import ru.foreman.supportAndInterfase.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Ячейка на основе JButton. Хранит свое местоположение в сетке
 *
 * @author SergeyNF
 * @since 06.18
 */
public class Cell extends JButton {
    private Point point;
    private FleetNumber fleetNumber;
    private JButton button;
    // размеры, пока не нужны.
    private Dimension dimension = this.getSize();

    Cell(Point point, FleetNumber fleetNumber) {
        super();
        super.setSize(new Dimension(100, 100));
        this.point = point;
        this.fleetNumber = fleetNumber;
    }

    @Override
    public long getMultiClickThreshhold() {
        return super.getMultiClickThreshhold();
    }

    public Point getPoint() {
        return point;
    }

    public FleetNumber getFleetNumber() {
        return fleetNumber;
    }

    public void setResult(String msg){
        this.setText(msg);
    }
}