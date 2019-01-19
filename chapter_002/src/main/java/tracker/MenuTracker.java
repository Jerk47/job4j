package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private static final int ADD = 0;
    private static final int SHOW_ALL = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FIND_BY_ID = 4;
    private static final int FIND_BY_NAME = 5;
    private static final int EXIT = 6;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(ADD, "Add the new item"));
        this.actions.add(new ShowItems(SHOW_ALL, "Show all items"));
        this.actions.add(new UpdateItem(EDIT, "Edit item."));
        this.actions.add(new DeleteItem(DELETE, "Delete item."));
        this.actions.add(new FindItemById(FIND_BY_ID, "Find item by id"));
        this.actions.add(new FindItemsByName(FIND_BY_NAME, "Find items by name."));
        this.actions.add(new ExitProgram(EXIT, "Exit program"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        String sb = this.actions.get(0).info()
                + System.lineSeparator()
                + this.actions.get(1).info()
                + System.lineSeparator()
                + this.actions.get(2).info()
                + System.lineSeparator()
                + this.actions.get(3).info()
                + System.lineSeparator()
                + this.actions.get(4).info()
                + System.lineSeparator()
                + this.actions.get(5).info()
                + System.lineSeparator()
                + this.actions.get(6).info();
        System.out.println(sb);
    }

    public class AddItem extends BaseAction {


        protected AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки ------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId());
        }
    }

    public class ShowItems extends BaseAction {


        protected ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(item.getName());
                System.out.println(item.getDesc());
            }
        }
    }

    public class UpdateItem extends BaseAction {

        protected UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            boolean finallyEdit;
            String id = input.ask("Введите id заявки");
            String nameQuestion = input.ask("Введите новое название заявки.");
            String taskDescription = input.ask("Введите описание заявки.");
            finallyEdit = tracker.replace(id, new Item(nameQuestion, taskDescription));
            if (finallyEdit) {
                System.out.println("Заявка успешно обновлена.");
            } else {
                System.out.println("Заявка не найдена.");
            }
        }
    }

    public class DeleteItem extends BaseAction {


        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public int key() {
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            boolean result;
            String idDelete = input.ask("Введите id заявки для удаления");
            result = tracker.delete(idDelete);
            if (result) {
                System.out.println("Заявка успешно удалена.");
            }
        }
    }

    public class FindItemById extends BaseAction {


        protected FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String idItem = input.ask("Введите id заявки");
            System.out.println(tracker.findById(idItem));
        }
    }

    public class FindItemsByName extends BaseAction {


        protected FindItemsByName(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            String nameItem = input.ask("Введите имя для поиска заявки.");
            System.out.println(Arrays.toString(tracker.findByName(nameItem)));
        }

    }

    public class ExitProgram extends BaseAction {

        protected ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}