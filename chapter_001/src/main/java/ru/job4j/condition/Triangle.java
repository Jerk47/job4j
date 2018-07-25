package ru.job4j.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон
     * <p>
     * Формула
     * <p>
     * (ab + ac + bc)/2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    public double area() {
        double rsl = -1; //Это значение говорит о том, что треугольника нет.
        double ab = this.a.distanseTo(this.b);
        double ac = this.a.distanseTo(this.c);
        double bc = this.b.distanseTo(this.c);
        double period = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(period * (period - ab) * (period - ac) * (period - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b
     * @param ac Длина от точки a c
     * @param bc Длина от точки b c
     * @return
     */

    public boolean exist(double ab, double ac, double bc) {
        if (((ab + ac) < bc) || ((ab + bc) < ac) || ((ac + bc) < ab)) {
            return false;
        }
        return true;
    }
}
