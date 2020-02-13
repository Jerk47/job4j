package iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int index = 0;
    private int secondIndex = 0;
    private int count = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return count < getNumbersElements(values);
    }

    public Object next() {
        if (secondIndex >= values[index].length) {
            index++;
            secondIndex = 0;
        }
        count++;
        return values[index][secondIndex++];
    }

    private int getNumbersElements(int[][] array) {
        int result = 0;
        for (int[] i : array) {
            result += i.length;
        }
        return result;
    }
}
