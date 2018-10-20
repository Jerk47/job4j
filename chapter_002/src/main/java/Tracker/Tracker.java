package Tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    final Random random = new Random();

    public Item[] getItems() {
        return items;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position] = item;
        position++;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean checkReplace = false;
        for (int i = 0; i <= position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                checkReplace = true;
                break;
            }
        }
        return checkReplace;
    }

    public boolean delete(String id) {
        boolean checkDelete = false;
        for (int j = 0; j < position; j++) {
            if (this.items[j].getId().equals(id)) {
                System.arraycopy(items, j + 1, items, j, items.length - 1 - j);
                position--;
                checkDelete = true;
                break;
            }
        }
        return checkDelete;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null
                && this.items[i].getName().equals(key)) {
                    result[count++] = this.items[i];
                }
            }
        Item[] resultArr = Arrays.copyOf(result, count);
        return resultArr;
    }

    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                item = this.items[i];
                break;
            }
        }
        return item;
    }

    private String generateId() {
        return String.valueOf(random.nextInt(100));
    }
}
