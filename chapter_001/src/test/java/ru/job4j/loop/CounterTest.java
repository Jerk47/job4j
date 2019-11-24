package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CounterTest {

    @Test
    public void whenFirstNumberOneSecondNumberTenThenSum() {
        Counter cout = new Counter();
        int sum = cout.add(1, 10);
        assertThat(sum, is(30));
    }
}
