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

        @Override
        public String toString() {
            return out.toString();
        }


    };

    private static final String MENU = "Menu:"
            + System.lineSeparator() + "0 : Create new task"
            + System.lineSeparator() + "1 : Show all task"
            + System.lineSeparator() + "2 : Edit task"
            + System.lineSeparator() + "3 : Delete task"
            + System.lineSeparator() + "4 : Find task by id"
            + System.lineSeparator() + "5 : Find task by name"
            + System.lineSeparator() + "6 : Exit"
            + System.lineSeparator() + '\n'
            + System.lineSeparator() + "select:";

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws Exception {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker, output).init();
        this.item = tracker.findAll().get(0);
        String result = new StringBuilder()
                .append("0 : Create new task" + '\n')
                .append("1 : Show all task" + '\n')
                .append("2 : Edit task" + '\n')
                .append("3 : Delete task" + '\n')
                .append("4 : Find task by id" + '\n')
                .append("5 : Find task by name" + '\n')
                .append("6 : Exit" + '\n' + '\n')
                .append("------------ Adding a new task ------------" + '\n')
                .append("------------ New task was created with getId : " + this.tracker.getItems().get(0).getId() + '\n').toString();
        assertThat(this.output.toString(), is(result));
    }

    @Test
    public void showAllTasks() throws Exception {

        Input input = new StubInput(new String[]{"0", "test name", "desc","2", "1","y"});
        new StartUI(input, tracker, output).init();
        String result = new StringBuilder()
                .append("0 : Create new task" + '\n')
                .append("1 : Show all task" + '\n')
                .append("2 : Edit task" + '\n')
                .append("3 : Delete task" + '\n')
                .append("4 : Find task by id" + '\n')
                .append("5 : Find task by name" + '\n')
                .append("6 : Exit" + '\n' + '\n')
                .append("------------ Adding a new task ------------" + '\n')
                .append("------------ New task was created with getId : " + tracker.findAll().get(0).getId() + '\n')
                .append("0 : Create new task" + '\n')
                .append("1 : Show all task" + '\n')
                .append("2 : Edit task" + '\n')
                .append("3 : Delete task" + '\n')
                .append("4 : Find task by id" + '\n')
                .append("5 : Find task by name" + '\n')
                .append("6 : Exit" + '\n' + '\n')
                .append("test name" + '\n')
                .append("desc" + '\n')
                .toString();
        assertThat(this.output.toString(), is(result));
    }

//    @Test
//    public void whenDeleteItemThenTrackerDoesNotHaveItem() throws Exception {
//        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
//        new StartUI(input, tracker, output).init();
//        String result = new StringBuilder()
//                .append(MENU)
//                .append(System.lineSeparator())
//                .append("Заявка успешно удалена.")
//                .append(System.lineSeparator())
//                .toString();
//        assertThat(this.output.toString(), is(result));
//    }

//    @Test
//    public void whenSearchItemByIdThenTrackerShowSameItemId() throws Exception {
//
//        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
//        new StartUI(input, tracker, output).init();
//        String result = new StringBuilder()
//                .append(MENU)
//                .append(System.lineSeparator())
//                .append(item.getName())
//                .append(System.lineSeparator())
//                .toString();
//        assertThat(this.output.toString(), is(result));
//    }
//
//    @Test
//    public void whenSearchItemByNameThenTrackerShowSameItem() throws Exception {
//        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
//        new StartUI(input, tracker, output).init();
//        String result = new StringBuilder()
//                .append(MENU)
//                .append(System.lineSeparator())
//                .append("[test name]")
//                .append(System.lineSeparator())
//                .toString();
//        assertThat(this.output.toString(), is(result));
//    }
//
//    @Test
//    public void whenAddTwoItemsThenShowTwoItems() throws Exception {
//        Item item2 = new Item("Name 2", "desc", 123L);
//        tracker.add(item2);
//        Input input = new StubInput(new String[]{"1", "6"});
//        new StartUI(input, tracker, output).init();
//        String result = new StringBuilder()
//                .append(MENU)
//                .append(System.lineSeparator())
//                .append("test name")
//                .append(System.lineSeparator())
//                .append(item2.getName())
//                .append(System.lineSeparator())
//                .toString();
//        assertThat(this.output.toString(), is(result));
    }
