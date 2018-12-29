package tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
<<<<<<< HEAD
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Пожалуйста, выберите пункт меню.");
            if (ADD.equals(answer)) {
                this.createItem();
                exit = true;
            } else if (SHOW_ALL.equals(answer)) {
                showAllItem();
                exit = true;
            } else if (EDIT.equals(answer)) {
                editItem();
                exit = true;
            } else if (DELETE.equals(answer)) {
                deleteItem();
                exit = true;
            } else if (FIND_BY_ID.equals(answer)) {
                findItemById();
                exit = true;
            } else if (FIND_BY_NAME.equals(answer)) {
                findItemByName();
                exit = true;
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки ------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с id: " + item.getId());
    }

    private void showAllItem() {
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
    }

    private void editItem() {
        boolean finallyEdit;
        String id = this.input.ask("Введите id заявки");
        String nameQuestion = this.input.ask("Введите новое название заявки.");
        String taskDescription = this.input.ask("Введите описание заявки.");
        finallyEdit = tracker.replace(id, new Item(nameQuestion, taskDescription));
        if (finallyEdit) {
            resultEdit("Заявка успешно обновлена.");
        } else {
            resultEdit("Заявка не найдена.");
        }
    }

    private boolean deleteItem() {
        boolean finallyDelete;
        String idDelete = this.input.ask("Введите id заявки для удаления");
        finallyDelete = tracker.delete(idDelete);
        if (finallyDelete) {
            resultDelete("Заявка успешно удалена.");
        } else {
            resultDelete("Не удалось найти заявку.");
=======
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
>>>>>>> d886216665079b0ec5487775c18678ce5411ea3e
        }
        do {
            menu.show();
            try {
                menu.select(input.ask("select: ", range));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
