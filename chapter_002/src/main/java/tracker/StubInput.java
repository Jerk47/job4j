package tracker;

public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;

    public StubInput(final String[] answers) {
        this.answers = answers;
    }


    @Override
    public String ask(String question) {
        return answers[position++];
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

