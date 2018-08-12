package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int firstIndex = data.length - 1;
        int secondIndex = data.length - 1;

        for (int i = 0; i < data.length - 1; i++) {
            int j = i;
            if (data[0][0] != data[i + 1][j + 1]) {
                result = false;
                break;
            }
            for (int k = data.length; k > 0; k--) {
                if (data[firstIndex][secondIndex] != data[firstIndex - 1][secondIndex - 1]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}









