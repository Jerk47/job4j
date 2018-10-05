package Tracker;

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
        int i = Integer.parseInt(id);
        if (i >= 0 && i < items.length) {
            Item[] itemResult = new Item[items.length - 1];
            System.arraycopy(items, 0, itemResult, 0, i);
            System.arraycopy(items, i + 1, itemResult, i, items.length - i - 1);
            return itemResult;
        }
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
