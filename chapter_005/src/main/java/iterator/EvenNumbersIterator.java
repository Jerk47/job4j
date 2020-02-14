package iterator;

import java.util.Iterator;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;

    public EvenNumbersIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
