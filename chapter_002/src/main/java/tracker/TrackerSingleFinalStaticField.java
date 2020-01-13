package tracker;

public class TrackerSingleFinalStaticField {
    private static final TrackerSingleFinalStaticField INSTANCE = new TrackerSingleFinalStaticField();

    private TrackerSingleFinalStaticField() {
    }

    public static TrackerSingleFinalStaticField getInstance() {
        return INSTANCE;
    }

}
