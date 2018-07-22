package ru.foreman.fleet;

import ru.foreman.supportAndInterfase.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс кораблей. реализована автоматическая установка координат, проверка попадания
 *
 * @author SergeyNF
 * @since 06.18
 */

class Ship {
    enum Route {HORIZONTALLY, VERTICALLY}

    private static Random random = new Random();
    private Point[] location;

    Ship(int lengthShip) {
        this.location = new Point[lengthShip];
    }


    /**
     * Инициализация и проверка точек на совпадение и близость других точек
     *
     * @return массив точек локации
     * @param usePoint использованные точки
     */
    private Point[] initiateAndCompareLocation(ArrayList<Point> usePoint) {

        do {
            Route route = selectRoute();
            Point[] tempLocation = new Point[location.length];

            int OFFSET_LOCATION = 1;
            if (route == Route.HORIZONTALLY) {
                int y = random.nextInt(9) + OFFSET_LOCATION;
                int x = random.nextInt(9 - location.length) + OFFSET_LOCATION;
                tempLocation[0] = new Point(x, y);

                for (int i = 1; i < tempLocation.length; i++) {
                    tempLocation[i] = new Point(++x, y);
                }
                if (checkTempLocation(usePoint, tempLocation)) {
                    System.out.println("create");
                    return tempLocation;
                }
            } else {
                int y = random.nextInt(9 - location.length) + OFFSET_LOCATION;
                int x = random.nextInt(9) + OFFSET_LOCATION;
                tempLocation[0] = new Point(x, y);

                for (int i = 1; i < tempLocation.length; i++) {
                    tempLocation[i] = new Point(x, ++y);
                }
                if (checkTempLocation(usePoint, tempLocation)) {
                    System.out.println("create");
                    return tempLocation;
                }
            }
            System.out.println("not create");
        } while (true);
    }


    private boolean checkTempLocation(ArrayList<Point> usePoint, Point[] tempLocation) {

        for (Point point : usePoint) {
            if(point == null){
                break;
            }
            for (Point tempPoint : tempLocation) {
                if (point.equalsPoint(tempPoint) || point.isNear(tempPoint)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Route selectRoute() {
        int randomInt = random.nextInt(9);
        System.out.println("rotation");
        if (randomInt < 5) {
            return Route.HORIZONTALLY;
        } else {
            return Route.VERTICALLY;
        }
    }

    void createLocation(ArrayList<Point> usePoint) {
        location = initiateAndCompareLocation(usePoint);
    }

    Point[] getLocation() {
        return location;
    }
}

