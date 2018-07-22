package ru.foreman.fleet;

import ru.foreman.supportAndInterfase.Point;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Поле боя. Создает и поготавливает корабли
 *
 * @author SergeyNF
 * @since 06.18
 */
public class Fleet {
    // хранение занятых точек, для проверки при создании нового корабля
    private ArrayList<Point> useLocation = new ArrayList<>();

    private int fleetNumber;

    public Fleet(int fleetNumber) {
        initiateShips();
        this.fleetNumber = fleetNumber;

    }

    /**
     * Метод инициализации кораблей (1-5палуб, 1-4палубы, 2-3палубы, 2-2палубы, 2-1палуба)
     */
    private void initiateShips() {
        // пятьпалубный
        Ship ship5 = new Ship(5);
        ship5.createLocation(useLocation);

        addPointToUseLocation(ship5);

        // четырех палубный
        Ship ship4 = new Ship(4);
        ship4.createLocation(useLocation);

        addPointToUseLocation(ship4);

        //  первый трех палубный
        Ship ship3_1 = new Ship(3);
        ship3_1.createLocation(useLocation);

        addPointToUseLocation(ship3_1);

        //  второй трех палубный
        Ship ship3_2 = new Ship(3);
        ship3_2.createLocation(useLocation);

        addPointToUseLocation(ship3_2);

        //  первый двух палубный
        Ship ship2_1 = new Ship(2);
        ship2_1.createLocation(useLocation);

        addPointToUseLocation(ship2_1);

        //  второй двух палубный
        Ship ship2_2 = new Ship(2);
        ship2_2.createLocation(useLocation);

        addPointToUseLocation(ship2_2);

        //  первый одно палубный
        Ship ship1_1 = new Ship(1);
        ship1_1.createLocation(useLocation);

        addPointToUseLocation(ship1_1);

        //  второй одно палубный
        Ship ship1_2 = new Ship(1);
        ship1_2.createLocation(useLocation);

        addPointToUseLocation(ship1_2);
    }

    /**
     * Заполение useLocation
     *
     * @param ship созданный корабль
     */
    private void addPointToUseLocation(Ship ship) {
        Point[] arrayPoint = ship.getLocation();
        Collections.addAll(useLocation, arrayPoint);
    }

    /**
     * Проверка всех кораблей на попадание выстреля. Проверяется по массиву использованных координат
     *
     * @param p координата для проверки
     * @return при попадании - true
     */
    public boolean checkAllShipsToHit(Point p) {
        for (Point anUseLocation : useLocation) {
            if (p.equalsPoint(anUseLocation)) {
                return true;
            }
        }
        return false;
    }

    /* ****************************************************************************************************************/

    /**
     * Testing method
     *
     * @param args arg
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Fleet fleet = new Fleet(1);
        System.out.printf("execution time = %d ms", System.currentTimeMillis() - startTime);
    }

    public int getFleetNumber() {
        return fleetNumber;
    }
}
