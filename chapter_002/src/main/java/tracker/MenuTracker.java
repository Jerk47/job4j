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
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    public class AddItem implements UserAction {

        public AddItem(int i, String add_program) {
        }

        @Override
        public int key() {
            return ADD;
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

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), " Add the new item. ");
        }
    }

    public class ShowItems implements UserAction {

        private ShowItems(int i, String show_all_items) {
        }

        @Override
        public int key() {
            return SHOW_ALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(item.getName());
                System.out.println(item.getDesc());
            }
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), " Show all items. ");
        }
    }

    public class UpdateItem implements UserAction {

        private UpdateItem(int i, String edit_item) {
        }

        @Override
        public int key() {
            return EDIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            boolean finallyEdit;
            String id = input.ask("Введите id заявки");
            String nameQuestion = input.ask("Введите новое название заявки.");
            String taskDescription =  input.ask("Введите описание заявки.");
            finallyEdit = tracker.replace(id, new Item(nameQuestion, taskDescription));
            if (finallyEdit) {
                System.out.println("Заявка успешно обновлена.");
            } else {
                System.out.println("Заявка не найдена.");
            }
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), " Edit item. ");
        }
    }

    public class DeleteItem implements UserAction {

        private DeleteItem(int i, String delete_item) {
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

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), " Delete item. ");
        }
    }

    public class FindItemById implements UserAction {

        private FindItemById(int i, String find_item_by_id) {
        }

        @Override
        public int key() {
            return FIND_BY_ID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String idItem = input.ask("Введите id заявки");
            System.out.println(tracker.findById(idItem));
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), " Find item by Id. ");
        }
    }

    public class FindItemsByName implements UserAction {

        private FindItemsByName(int i, String find_items_by_name) {
        }

        @Override
        public int key() {
            return FIND_BY_NAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String nameItem = input.ask("Введите имя для поиска заявки.");
            System.out.println(Arrays.toString(tracker.findByName(nameItem)));
        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), " Find items by name. ");
        }
    }

    public class ExitProgram implements UserAction {

        private ExitProgram(int i, String exit_program) {
        }

        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s.%s", this.key(), " Exit Program. ");
        }

    }
}
