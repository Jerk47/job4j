package ru.job4j.array;

public class BubbleSort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int index = array[i];
                    array[i] = array[j];
                    array[j] = index;
                }
            }
        }
        return array;
    }
}
