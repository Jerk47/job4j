package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size();
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j : list) {
                array[i][cells] = j;
            }

        }
        return array;
    }

    public static void main(String[] args) {
        ConvertList2Array cl = new ConvertList2Array();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(cl.toArray(list, 2));
    }
}


