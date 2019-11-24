package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenArrayFromSevenToOne() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {7, 6, 5, 4, 3, 2, 1};
        int[] expect = {1, 2, 3, 4, 5, 6, 7};
        int[] result = bubbleSort.sort(input);
        assertThat(input, is(result));
    }
}

