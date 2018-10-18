package Tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    Item item;
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

    public void replace(String id, Item item) {
        for (int i = 0; i <= position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                break;
            }
        }
    }

    public void delete(String id) {
        for (int j = 0; j <= position; j++) {
            if (this.items[j].getId().equals(id)) {
                System.arraycopy(items, j + 1, items, j, items.length - 1 - j);
                break;
            }
        }
    }

    public Item[] findAll() {
        int count = 0;
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i <= position; i++) {
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
        for (int i = 0; i <= position; i++) {
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
