package Tracker;

import org.junit.Test;

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
        assertThat(tracker.findAll()[1], is(item2));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        String ar = tracker.findById(previous.getId()).getName();
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
        Item[] expectedArr = {item1, item2, item3};
        Item[] itemArr = tracker.findAll();
        assertThat(itemArr, is(expectedArr));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Dsc", 123L);
        Item item2 = new Item("test1", "test2Dsc", 124L);
        Item item3 = new Item("test1", "test3Dsc", 125L);
        Item item4 = new Item("test2", "test4Dsc", 126L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] expectedArr = tracker.findByName("test1");

        Item[] resultArr = {item1, item2, item3};
        assertThat(resultArr, is(expectedArr));
    }
}
