package tracker;

public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private static Item item;
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker, Item item) {
        this.input = input;
        this.tracker = tracker;
        this.item = item;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Пожалуйста, выберите пункт меню.");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                for (Item item : this.tracker.findAll()) {
                    System.out.println(item.getName());
                }
            } else if (EDIT.equals(answer)) {
                String id = this.input.ask("Введите id заявки");
                tracker.replace(id, new Item("Ремонт", "Покраска стен"));
            } else if (DELETE.equals(answer)) {
                tracker.delete(item.getId());
            } else if (FIND_BY_ID.equals(answer)) {
                String id = this.input.ask("Введите id заявки");
                System.out.println(this.tracker.findById(id).getName());
            } else if (FIND_BY_NAME.equals(answer)) {
                this.tracker.findByName(item.getName());
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

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker(), item).init();
    }
}
