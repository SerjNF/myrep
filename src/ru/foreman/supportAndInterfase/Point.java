package ru.foreman.supportAndInterfase;

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

    public boolean equalsPoint(Point p) {
        return x == p.x && y == p.y;
    }

    /**
     * Проверка точки на близость (если на соседне клетке)
     *
     * @param p точка с которой сравнивать
     * @return если близко - true
     */
    public boolean isNear(Point p) {
        return Math.abs(x - p.x) < 2 && Math.abs(y - p.y) < 2;
    }
}

