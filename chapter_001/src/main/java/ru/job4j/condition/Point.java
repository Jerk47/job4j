package ru.job4j.condition;

/**
 * @author Roman Tsenov
 * @version $Id$
 * since 0.1
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanseTo(Point that) {
        Point a = this;
        Point b = that;
        double result = Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanseTo(b);
        System.out.println("Расстояние равно: " + result);
    }
}
