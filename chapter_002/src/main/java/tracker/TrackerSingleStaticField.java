package tracker;

public class TrackerSingleStaticField {
    private static TrackerSingleStaticField instance;

    private TrackerSingleStaticField() {
    }

    public static TrackerSingleStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStaticField();
        }
        return instance;
    }
}
