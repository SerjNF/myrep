package ru.foreman.fleet;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс кораблей. реализована автоматическая установка координат, проверка попадания
 *
 * @author SergeyNF
 * @since 06.18
 */

public class Ship {
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
     */
    private Point[] initiateAndCompareLocation(ArrayList<Point> usePoint) {

        do {
            Route route = selectRoute();
            Point[] tempLocation = new Point[location.length];

            if (route == Route.HORIZONTALLY) {
                int y = random.nextInt(9) + 1;
                int x = random.nextInt(9 - location.length) + 1;
                tempLocation[0] = new Point(x, y);

                for (int i = 1; i < tempLocation.length; i++) {
                    tempLocation[i] = new Point(++x, y);
                }
                if (checkTempLocation(usePoint, tempLocation)) {
                    System.out.println("create");
                    return tempLocation;
                }
            } else {
                int y = random.nextInt(9 - location.length) + 1;
                int x = random.nextInt(9) + 1;
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
            for (Point tempPoint : tempLocation) {
                if (point.equalsPoint(tempPoint) || point.isNear(tempPoint)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Выбор направления
     *
     * @return элемент Route. Направление горизонтально или вертикально
     */
    private Route selectRoute() {
        int randomInt = random.nextInt(9);
        System.out.println("rotation");
        if (randomInt < 5) {
            return Route.HORIZONTALLY;
        } else {
            return Route.VERTICALLY;
        }
    }

    /**
     * Интерфейс создания координат
     *
     * @param usePoint массив использованных точек
     */
    public void createLocation(ArrayList<Point> usePoint) {
        location = initiateAndCompareLocation(usePoint);
    }

    /**
     * Проверка выстрела
     *
     * @param shootPoint координаты выстреля
     * @return попал - true
     */
    public boolean checkShoot(Point shootPoint) {
        for (Point p : location) {
            if (shootPoint.equalsPoint(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * геттер координат коробля
     *
     * @return координаты коробля. Массив длинной переданной в конструктор
     */
    public Point[] getLocation() {
        return location;
    }


/******************************************************************************************************************/
    /**
     * Тестовы метод для проверки Ship & Point
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
      /*  Point[] use = new Point[]{new Point(), new Point(5, 5)};
        Ship ship = new Ship(5);
        ship.createLocation(use);
        Ship ship4 = new Ship(4);
        ship4.createLocation(use);
        System.out.printf("execution time = %d ms", System.currentTimeMillis() - startTime);
*/
    }

}

