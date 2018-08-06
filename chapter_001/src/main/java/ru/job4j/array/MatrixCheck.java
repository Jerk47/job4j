package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int j = 0;
        int k = 0;
        int h = data.length - 1;

        for (int i = 0; i < data.length - 1; i++) {
            j++;
            k++;
            h--;
            if (data[0][0] != data[j][k]) {
                result = false;
                break;
            }
            if (data[0][data.length - 1] != data[j][h]) {
                result = false;
                break;
            }
        }
        return result;
    }
}









