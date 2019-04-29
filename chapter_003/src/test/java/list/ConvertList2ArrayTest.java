package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whneAddTwoArrays() {
        ConvertList2Array cl = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        List<Integer> finalList = new ArrayList<>();
        List<Integer> compareList = new ArrayList<>();
        compareList.add(1);
        compareList.add(2);
        compareList.add(3);
        compareList.add(4);
        compareList.add(5);
        compareList.add(6);
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        finalList = cl.convert(list);
        assertThat(finalList, is(compareList));

    }
}
