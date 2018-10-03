package Tracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    Item item;
    final Random random = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position] = item;
        position++;
        return item;
    }

    public void replace(String id, Item item) {
        for (int i = 0; i <= this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                break;
            }
        }
    }

    public Item[] delete(String id) {
        Item[] items2;
        items2 = Arrays.copyOf(items, items.length);
        System.arraycopy(items2, Integer.parseInt(id) + 1, items, Integer.parseInt(id) - 1, items.length);
        return items;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] items2 = new Item[100];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                items2[count] = this.items[i];
                count++;
            }
        }
        Item[] items3 = Arrays.copyOf(items2, count);

        return items3;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getName().equals(key)) {
                    result[count] = this.items[i];
                }
                count++;
            }
        }
        Item[] resultArr = Arrays.copyOf(result, count - 1);
        return resultArr;
    }

    public Item findById(String id) {

        for (int i = 0; i < this.items.length; i++) {
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
