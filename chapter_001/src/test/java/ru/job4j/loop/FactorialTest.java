package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FactorialTest {

    @Test
    public void whenNumberFiveThenOneHundredTwenty() {
        Factorial fact = new Factorial();
        int sum = fact.calc(5);
        assertThat(sum,is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fact = new Factorial();
        int sum = fact.calc(0);
        assertThat(sum,is(1));
    }
}
