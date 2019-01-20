package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleFinalStaticFieldTest {

    @Test
    public void whenCreateTwoInstanceReturnTheSameObject() {
        TrackerSingleFinalStaticField singletone1 = TrackerSingleFinalStaticField.getInstance();
        TrackerSingleFinalStaticField singletone2 = TrackerSingleFinalStaticField.getInstance();
        assertThat(singletone1, is(singletone2));
    }
}
