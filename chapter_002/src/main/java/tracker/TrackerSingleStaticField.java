package tracker;

public class TrackerSingleStaticField {
    private static TrackerSingleStaticField instance;

    /*
     fields of class tracker should be here
    */
    private TrackerSingleStaticField() {
    }

    public static TrackerSingleStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStaticField();
        }
        return instance;
    }

    /*
    methods of class tracker should be here
    */
}
