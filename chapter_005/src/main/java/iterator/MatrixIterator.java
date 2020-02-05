package iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int index = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return values.length > index;
    }

    public Object next() {
        return  values[index++];
    }
}
