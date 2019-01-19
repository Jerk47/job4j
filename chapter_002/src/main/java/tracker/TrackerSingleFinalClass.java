package tracker;

public class TrackerSingleFinalClass {
    /*
    fields of class tracker should be here
   */
    private TrackerSingleFinalClass() {
    }

    public static TrackerSingleFinalClass getInstance() {
        return Holder.INSTANCE;
    }

     /*
    methods of class tracker should be here
    */

    private static final class Holder {
        private static final TrackerSingleFinalClass INSTANCE = new tracker.TrackerSingleFinalClass();
    }
}
