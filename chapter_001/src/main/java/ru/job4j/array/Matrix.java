package ru.job4j.array;

public class Matrix {

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (j + 1) * (i + 1);
            }
        }
        return table;
    }
}



