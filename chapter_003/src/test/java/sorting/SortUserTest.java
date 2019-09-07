package sorting;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenUseComparable() {
        List<SortUser.User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new SortUser.User("Marya", "45"),
                new SortUser.User("Ivan", "17"),
                new SortUser.User("Roman", "22")
        ));
        Set<SortUser.User> resultTreeSet = new TreeSet<>();
        SortUser sortUser = new SortUser();
        resultTreeSet = sortUser.sort(users);
        assertThat(resultTreeSet.toArray()[0].equals(users.get(1)), is(true));
        assertThat(resultTreeSet.toArray()[1].equals(users.get(2)), is(true));
        assertThat(resultTreeSet.toArray()[2].equals(users.get(0)), is(true));
    }

}