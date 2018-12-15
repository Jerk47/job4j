package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    private Tracker tracker = new Tracker();
    private Item item;
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
        item = tracker.add(new Item("test name", "desc"));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerDoesNotHaveItem() {
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.delete(item.getId()), is(false));
    }

    @Test
    public void whenSearchItemByIdThenTrackerShowSameItemId() {

        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    @Test
    public void whenSearchItemByNameThenTrackerShowSameItem() {
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].toString(), is("test name"));
    }

    @Test
    public void whenAddTwoItemsThenShowTwoItems() {
        Item item2 = new Item("Name 2", "desc", 123L);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String result = new StringBuilder()
                .append("Меню.")
                .append(System.lineSeparator())
                .append("0. Создать новую заявку.")
                .append(System.lineSeparator())
                .append("1. Показать все заявки.")
                .append(System.lineSeparator())
                .append("2. Редактировать заявку.")
                .append(System.lineSeparator())
                .append("3. Удалить заявку")
                .append(System.lineSeparator())
                .append("4. Найти заявку по id")
                .append(System.lineSeparator())
                .append("5. Найти заявку по имени")
                .append(System.lineSeparator())
                .append("6. Выйти из программы")
                .append(System.lineSeparator())
                .append("test name")
                .append(System.lineSeparator())
                .append(item2.getName())
                .append(System.lineSeparator())
                .toString();
        assertThat(new String(out.toByteArray()), is(result));
    }
}
