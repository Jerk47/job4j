package sorting;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        boolean checkEquality;
        checkEquality = true;
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength - 1; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                checkEquality = false;
                break;
            }
        }
        if (checkEquality) {
            result = minLength == left.length() ? -1 : 1;
            if (left.length() == right.length()) {
                result = 0;
            }
        }
        return result;
    }
}

