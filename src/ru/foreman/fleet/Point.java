package ru.foreman.fleet;

/**
 * Класс точки
 *
 * @author SergeyNF
 * @since 06.18
 */

public class Point {
    private int x;
    private int y;

    Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Сеттер
     * @param x координата Х
     * @param y координата У
     */
    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Геттер
     * @return Объект Point
     */
    public Point getPoint() {
        return this;
    }

    /**
     * Геттер Х
     * @return Х
     */
    public int getX() {
        return x;
    }

    /**
     * Геттер У
     * @return У
     */
    public int getY() {
        return y;
    }

    /**
     * Сравнение двух точек
     * @param p точка с которой сравнивать
     * @return если совпадают - true
     */
    public boolean equalsPoint(Point p) {
        if (x == p.getX() && y == p.getY()) {
            return true;
        }
        return false;
    }

    /**
     * Проверка точки на длизость (если на соседне клетке
     * @param p точка с которой сравнивать
     * @return если близко - true
     */
    public boolean isNear(Point p) {
        if (Math.abs(x - p.getX()) < 2 && Math.abs(y - p.getY()) < 2) {
            return true;
        }
        return false;
    }
}

