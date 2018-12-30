package tracker;

public class StartUI {
    private final Input input;
    private final Tracker tracker;


    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] ranges = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            ranges[i] = i;
        }
        do {
            menu.show();
            try {
                menu.select(input.ask("select: ", ranges));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
