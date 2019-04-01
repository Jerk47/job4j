package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = 0;
        int[][] array = new int[rows][cells];
        for (int i: list) {
            while (i < rows) {
                i++;
            }

        }

            

        return array;
    }
}


