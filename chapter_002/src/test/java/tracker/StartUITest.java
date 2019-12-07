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
   private final PrintStream stdout = System.out;
   private final ByteArrayOutputStream out = new ByteArrayOutputStream();
   private final Consumer<String> output = new Consumer<String>() {
       @Override
       public void accept(String s) {
            stdout.println(s);
       }
   };
   private static final String MENU = "Меню."
           + System.lineSeparator() + "0. Создать новую заявку."
           + System.lineSeparator() + "1. Показать все заявки."
           + System.lineSeparator() + "2. Редактировать заявку."
           + System.lineSeparator() + "3. Удалить заявку"
           + System.lineSeparator() + "4. Найти заявку по id"
           + System.lineSeparator() + "5. Найти заявку по имени"
           + System.lineSeparator() + "6. Выйти из программы";

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
       new StartUI(input, tracker, output).init();
      assertThat(tracker.findAll().get(0).getName(), is("test name"));
   }

   @Test
   public void whenUpdateThenTrackerHasUpdatedValue() {
       Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
       new StartUI(input, tracker, output).init();
       String result = new StringBuilder()
               .append(MENU)
               .append(System.lineSeparator())
               .append("Заявка успешно обновлена.")
               .append(System.lineSeparator())
               .toString();
       assertThat(new String(out.toByteArray()), is(result));
   }

   @Test
   public void whenDeleteItemThenTrackerDoesNotHaveItem() {
       Input input = new StubInput(new String[]{"3", item.getId(), "6"});
       new StartUI(input, tracker, output).init();
       String result = new StringBuilder()
               .append(MENU)
               .append(System.lineSeparator())
               .append("Заявка успешно удалена.")
               .append(System.lineSeparator())
               .toString();
       assertThat(new String(out.toByteArray()), is(result));
   }

   @Test
   public void whenSearchItemByIdThenTrackerShowSameItemId() {

       Input input = new StubInput(new String[]{"4", item.getId(), "6"});
       new StartUI(input, tracker, output).init();
       String result = new StringBuilder()
               .append(MENU)
               .append(System.lineSeparator())
               .append(item.getName())
               .append(System.lineSeparator())
               .toString();
       assertThat(new String(out.toByteArray()), is(result));
   }

   @Test
   public void whenSearchItemByNameThenTrackerShowSameItem() {
       Input input = new StubInput(new String[]{"5", item.getName(), "6"});
       new StartUI(input, tracker, output).init();
       String result = new StringBuilder()
               .append(MENU)
               .append(System.lineSeparator())
               .append("[test name]")
               .append(System.lineSeparator())
               .toString();
       assertThat(new String(out.toByteArray()), is(result));
   }

   @Test
   public void whenAddTwoItemsThenShowTwoItems() {
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
       assertThat(new String(out.toByteArray()), is(result));
   }
}