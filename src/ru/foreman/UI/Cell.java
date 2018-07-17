package ru.foreman.UI;

import ru.foreman.fleet.Point;

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
    // размеры, пока не нужны.
    private Dimension dimension = this.getSize();

    public Cell() {
        super();
    }

    Cell(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }





//    Point getPointToCompare() {
//        return this.point;
//       // System.out.printf("Click %d / %d%n", point.getX(), point.getY());
//
//    }

    /* ***************************************************************************************************************/

    /**
     * test method
     *
     * @param args arg
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        Cell cell = new Cell();
        Cell cell1 = new Cell();


        panel.add(cell);
        panel.add(cell1);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}