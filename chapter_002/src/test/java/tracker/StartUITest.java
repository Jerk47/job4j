package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    private Tracker tracker = new Tracker();
    private Item item;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
        item = tracker.add(new Item("test name", "desc"));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(out));
    }

    private static final String MENU = "Меню."
            + System.lineSeparator() + "0. Создать новую заявку."
            + System.lineSeparator() + "1. Показать все заявки."
            + System.lineSeparator() + "2. Редактировать заявку."
            + System.lineSeparator() + "3. Удалить заявку"
            + System.lineSeparator() + "4. Найти заявку по id"
            + System.lineSeparator() + "5. Найти заявку по имени"
            + System.lineSeparator() + "6. Выйти из программы";

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws Exception {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws Exception {
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker, output).init();
        String result = new StringBuilder()
                .append(MENU)
                .append("Создать новую заявку.")
                .append(System.lineSeparator())
                .append("Показать все заявки.")
                .append(System.lineSeparator())
                .append("Редактировать заявку.")
                .append(System.lineSeparator())
                .append("Удалить заявку")
                .append(System.lineSeparator())
                .append("Найти заявку по id")
                .append(System.lineSeparator())
                .append("Найти заявку по имени")
                .append(System.lineSeparator())
                .append("Выйти из программы")
                .append(System.lineSeparator())
                .append("Заявка успешно обновлена.")
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(result));
    }

    @Test
    public void whenDeleteItemThenTrackerDoesNotHaveItem() throws Exception {
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        String result = new StringBuilder()
                .append(MENU)
                .append(System.lineSeparator())
                .append("Заявка успешно удалена.")
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(result));
    }

    @Test
    public void whenSearchItemByIdThenTrackerShowSameItemId() throws Exception {

        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker, output).init();
        String result = new StringBuilder()
                .append(MENU)
                .append(System.lineSeparator())
                .append(item.getName())
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(result));
    }

    @Test
    public void whenSearchItemByNameThenTrackerShowSameItem() throws Exception {
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker, output).init();
        String result = new StringBuilder()
                .append(MENU)
                .append(System.lineSeparator())
                .append("[test name]")
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(result));
    }

    @Test
    public void whenAddTwoItemsThenShowTwoItems() throws Exception {
        Item item2 = new Item("Name 2", "desc", 123L);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker, output).init();
        String result = new StringBuilder()
                .append(MENU)
                .append(System.lineSeparator())
                .append("test name")
                .append(System.lineSeparator())
                .append(item2.getName())
                .append(System.lineSeparator())
                .toString();
        assertThat(this.output.toString(), is(result));
    }
}