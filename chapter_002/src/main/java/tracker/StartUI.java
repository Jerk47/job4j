package tracker;

import java.util.Arrays;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    private StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Пожалуйста, выберите пункт меню.");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                showAllItem();
            } else if (EDIT.equals(answer)) {
                editItem();
            } else if (DELETE.equals(answer)) {
                deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                findItemByName();
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
        System.out.println("------------ Новая заявка с getId : " + item.getId());
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
        }
        return finallyDelete;
    }

    private void findItemById() {
        String idItem = this.input.ask("Введите id заявки");
        System.out.println(this.tracker.findById(idItem).getName());
    }

    private void findItemByName() {
        String nameItem = this.input.ask("Введите имя для поиска заявки.");
        System.out.println(Arrays.toString(tracker.findByName(nameItem)));
    }


    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Создать новую заявку.");
        System.out.println("1. Показать все заявки.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по id");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выйти из программы");
    }

    private void resultDelete(String result) {
        System.out.println(result);
    }

    private void resultEdit(String result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
