package tracker;


public class StubInput implements Input {
    private final String[] answers;
    private int position = -1;

    public StubInput(final String[] answers) {
        this.answers = answers;
    }


    @Override
    public String ask(String question) {
        if (position < this.answers.length - 1) {
            position++;
        }
        return answers[position];
    }

    @Override
    public int ask(String question, int[] range)  {
        int key = Integer.parseInt(ask(question));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
            }
        }
        if (!exists) {
            throw new MenuOutException("out of menu range");
        }
        return key;
    }
}
