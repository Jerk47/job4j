package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int indexRow = 0;
    private int indexColumn = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    public boolean hasNext() {
        if (indexRow >= values.length) {
            return false;
        }
        if (indexColumn >= values[indexRow].length && indexRow == values.length - 1) {
            return false;
        }
        return true;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (indexColumn >= values[indexRow].length) {
            indexColumn = 0;
            indexRow++;
        }
        return values[indexRow][indexColumn++];
    }
}
