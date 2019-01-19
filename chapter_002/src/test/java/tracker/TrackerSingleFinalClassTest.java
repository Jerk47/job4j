package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleFinalClassTest {

    @Test
    public void whenCreateTwoInstanceReturnTheSameObject() {
        TrackerSingleFinalClass singletone1 = TrackerSingleFinalClass.getInstance();
        TrackerSingleFinalClass singletone2 = TrackerSingleFinalClass.getInstance();
        assertThat(singletone1, is(singletone2));
    }
}
