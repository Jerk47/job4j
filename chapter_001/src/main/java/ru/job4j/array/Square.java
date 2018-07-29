package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            if (i + 1 <= bound) {
                rst[i] = (int) Math.pow(i + 1, 2);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        Square sqr = new Square();
        System.out.println(sqr.calculate(5)[4]);
    }
}