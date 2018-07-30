package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = {4, 1, 6, 2};
        int[] expect = {2, 6, 1, 4};
        int[] input = turn.back(array);
        assertThat(input, is(expect));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4, 5};
        int[] expect = {5, 4, 3, 2, 1};
        int[] input = turn.back(array);
        assertThat(input, is(expect));
    }
}
