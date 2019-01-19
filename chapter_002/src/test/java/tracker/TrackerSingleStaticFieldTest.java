package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFieldTest {

    @Test
    public void whenCreateTwoInstanceReturnTheSameObject() {
        TrackerSingleStaticField singletone1 = TrackerSingleStaticField.getInstance();
        TrackerSingleStaticField singletone2 = TrackerSingleStaticField.getInstance();
        assertThat(singletone1, is(singletone2));
    }
}
