package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
//    @Test
//    public void whenUseComparable() {
//        List<SortUser.User> users = new ArrayList<>();
//        users.addAll(Arrays.asList(
//                new SortUser.User("Marya", "45"),
//                new SortUser.User("Ivan", "17"),
//                new SortUser.User("Roman", "22")
//        ));
//        Set<SortUser.User> resultTreeSet = new TreeSet<>();
//        SortUser sortUser = new SortUser();
//        resultTreeSet = sortUser.sort(users);
//        assertThat(resultTreeSet.toArray()[0].equals(users.get(1)), is(true));
//        assertThat(resultTreeSet.toArray()[1].equals(users.get(2)), is(true));
//        assertThat(resultTreeSet.toArray()[2].equals(users.get(0)), is(true));
//    }
//
//    @Test
//    public void sortByLengthOfName() {
//        List<SortUser.User> users = new ArrayList<>();
//        users.add(new SortUser.User("Sergey", "25"));
//        users.add(new SortUser.User("Ivan", "30"));
//        users.add(new SortUser.User("Sergey", "20"));
//        users.add(new SortUser.User("Ivan", "25"));
//        List<SortUser.User> resultList = new ArrayList<>();
//        resultList.add(new SortUser.User("Ivan", "30"));
//        resultList.add(new SortUser.User("Ivan", "25"));
//        resultList.add(new SortUser.User("Sergey", "25"));
//        resultList.add(new SortUser.User("Sergey", "20"));
//        SortUser sortUser = new SortUser();
//        sortUser.sortNameLength(users);
//        Assert.assertThat((users.get(0).compareTo(resultList.get(0))), is(0));
//        Assert.assertThat((users.get(1).compareTo(resultList.get(1))), is(0));
//        Assert.assertThat((users.get(2).compareTo(resultList.get(2))), is(0));
//        Assert.assertThat((users.get(3).compareTo(resultList.get(3))), is(0));
//    }
//
//    @Test
//    public void sortByAllField() {
//        List<SortUser.User> users = new ArrayList<>();
//        users.add(new SortUser.User("Sergey", "25"));
//        users.add(new SortUser.User("Ivan", "30"));
//        users.add(new SortUser.User("Sergey", "20"));
//        users.add(new SortUser.User("Ivan", "25"));
//        List<SortUser.User> resultList = new ArrayList<>();
//        resultList.add(new SortUser.User("Ivan", "25"));
//        resultList.add(new SortUser.User("Ivan", "30"));
//        resultList.add(new SortUser.User("Sergey", "20"));
//        resultList.add(new SortUser.User("Sergey", "25"));
//        SortUser sortUser = new SortUser();
//        sortUser.sortByAllField(users);
//        Assert.assertThat((users.get(0).compareTo(resultList.get(0))), is(0));
//        Assert.assertThat((users.get(1).compareTo(resultList.get(1))), is(0));
//        Assert.assertThat((users.get(2).compareTo(resultList.get(2))), is(0));
//        Assert.assertThat((users.get(3).compareTo(resultList.get(3))), is(0));
//    }

}