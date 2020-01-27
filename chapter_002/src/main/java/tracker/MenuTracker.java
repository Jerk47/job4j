package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
    private final Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(ADD, "Create new task"));
        this.actions.add(new ShowItems(SHOW_ALL, "Show all task"));
        this.actions.add(new UpdateItem(EDIT, "Edit task"));
        this.actions.add(new DeleteItem(DELETE, "Delete task"));
        this.actions.add(new FindItemById(FIND_BY_ID, "Find task by id"));
        this.actions.add(new FindItemsByName(FIND_BY_NAME, "Find task by name"));
        this.actions.add(new ExitProgram(EXIT, "Exit"));
    }

    public void select(int key) throws Exception {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getActionsLentgh(); i++) {
            sb.append(this.actions.get(i).info() + '\n');
        }
        output.accept(sb.toString());
    }

    public class AddItem extends BaseAction {


        protected AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Adding a new task ------------");
            String name = input.ask("Please, enter the name of the task :");
            String desc = input.ask("Please, enter the description of the task :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ New task was created with getId : " + item.getId());
        }
    }

    public class ShowItems extends BaseAction {


        protected ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                output.accept(item.getName());
                output.accept(item.getDesc());
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
            String id = input.ask("Please, enter id of the task");
            String nameQuestion = input.ask("Please, enter the name of the new task");
            String taskDescription = input.ask("Please, enter the description ot the new task");
            finallyEdit = tracker.replace(id, new Item(nameQuestion, taskDescription));
            if (finallyEdit) {
                output.accept("Task was successfully updated");
            } else {
                output.accept("Task was't found");
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
            String idDelete = input.ask("Please, insert id of the task for deleting.");
            result = tracker.delete(idDelete);
            if (result) {
                output.accept("The task was success");
            }
        }
    }

    public class FindItemById extends BaseAction {


        protected FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String idItem = input.ask("Please enter id of the task");
            output.accept(tracker.findById(idItem).toString());
        }
    }

    public class FindItemsByName extends BaseAction {


        protected FindItemsByName(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            String nameItem = input.ask("Please, enter the name for searching task");
            output.accept(tracker.findByName(nameItem).toString());
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
        public void execute(Input input, Tracker tracker) throws Exception {
            new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
        }
    }
}
