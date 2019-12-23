package tracker;

import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;


    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() throws Exception {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        int[] ranges = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            ranges[i] = i;
        }
        do {
            menu.show();
            menu.select(new ValidateInput(this.input).ask("select: ", ranges));
        }

        while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

public static void main(String[] args) throws Exception {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}