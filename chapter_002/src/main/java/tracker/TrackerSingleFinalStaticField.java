package tracker;

public class TrackerSingleFinalStaticField {
    private static final TrackerSingleFinalStaticField INSTANCE = new TrackerSingleFinalStaticField();

    /*
     fields of class tracker should be here
    */
    private TrackerSingleFinalStaticField() {
    }

    public static TrackerSingleFinalStaticField getInstance() {
        return INSTANCE;
    }

     /*
    methods of class tracker should be here
    */

}
