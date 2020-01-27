package tracker;

public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker) throws Exception;

    String info();
}
