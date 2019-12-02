package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHasLength5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLength3Then1() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{7, 3, 4};
        int value = 3;
        int result = find.indexOf(input, value);
        int expect = 1;
        assertThat(result, is(expect));
    }
}
