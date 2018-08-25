package Tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    final Random random = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        position++;
        return item;
    }

    public void replace(String id, Item item) {
        this.items[Integer.parseInt(id)] = item;
    }

    public Item[] delete(String id) {
        Item[] items2;
        items2 = Arrays.copyOf(items, items.length);
        System.arraycopy(items2, Integer.parseInt(id) + 1, items, Integer.parseInt(id) - 1, items.length);
        return items;
    }

    public Item[] findAll() {
        Item[] items2 = new Item[100];
        for (int i = 0; i < this.items.length; i++) {
            int count = 0;
            if (this.items[i] != null) {
                items2[count] = this.items[i];
                count++;
            }
        }
        return items2;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i<this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                result[count] = this.items[i];
                count++;
            }
        }
        return result;
    }

    public Item findById(String id) {
    Item[] result = new Item[100];
        for (int i = 0; i<this.items.length; i++) {
        if (this.items[i].getId().equals(id)) {
            result[0] = this.items[i];
        }
    }
        return result[0];
    }

    private String generateId() {
        return String.valueOf(random.nextInt(100));
    }
}
