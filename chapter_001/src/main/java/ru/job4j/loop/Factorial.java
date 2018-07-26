package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            count *= i;
            if (n == 0) {
                count = 1;
            }
        }
        return count;
    }
}
