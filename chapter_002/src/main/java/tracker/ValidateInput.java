package tracker;


public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) throws Exception {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter validate data again.");
            }
        }
        while (invalid);
        return value;
    }

}

