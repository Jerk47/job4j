package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        for (int i = 0; i < (array.length / 2); i++) {
            int temp = array.length - i - 1;
            int index = array[i];
            array[i] = array[temp];
            array[temp] = index;

        }
        return array;
    }
}
