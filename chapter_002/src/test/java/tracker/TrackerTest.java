package tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 124L);
        tracker.add(item);
        tracker.add(item2);
        assertThat(tracker.findAll().get(1), is(item2));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void showAllTasksWithoutNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Dsc", 123L);
        Item item2 = new Item("test2", "test2Dsc", 124L);
        Item item3 = new Item("test2", "test2Dsc", 125L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expectedArr = new ArrayList();
        expectedArr.add(item1);
        expectedArr.add(item2);
        expectedArr.add(item3);
        List<Item> itemArr = tracker.findAll();
        assertThat(itemArr, is(expectedArr));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Dsc", 123L);
        Item item2 = new Item("test1", "test2Dsc", 124L);
        Item item3 = new Item("test1", "test3Dsc", 125L);
        Item item4 = new Item("test4", "test4Dsc", 126L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> expectedArr = tracker.findByName("test1");
        List<Item> resultArr = new ArrayList<>();
        resultArr.add(item1);
        resultArr.add(item2);
        resultArr.add(item3);
        assertThat(resultArr, is(expectedArr));
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Dsc", 123L);
        Item item2 = new Item("test2", "test2Dsc", 124L);
        tracker.add(item1);
        tracker.add(item2);
        item1.setId("3");
        item2.setId("4");
        Item itemExpected = tracker.findById("3");
        Item itemExpected2 = tracker.findById("4");
        assertThat(item1, is(itemExpected));
        assertThat(item2, is(itemExpected2));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Dsc", 123L);
        Item item2 = new Item("test2", "test2Dsc", 124L);
        Item item3 = new Item("test3", "test3Dsc", 125L);
        Item item4 = new Item("test4", "test4Dsc", 126L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        item1.setId("0");
        item2.setId("1");
        item3.setId("2");
        item4.setId("3");
        tracker.delete("2");
        assertThat(tracker.getItems().get(2).getId(), is("3"));
    }
}
