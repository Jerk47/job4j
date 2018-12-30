package tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) throws Exception {
        int key = Integer.parseInt(this.ask(question));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException("out of menu range");
        }

    }
}
