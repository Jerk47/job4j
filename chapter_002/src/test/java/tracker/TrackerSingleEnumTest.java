package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleEnumTest {

    @Test
    public void whenCreateTwoInstanceReturnTheSameObject() {
        TrackerSingleEnum singletone1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum singletone2 = TrackerSingleEnum.INSTANCE;
        assertThat(singletone1, is(singletone2));
    }
}
