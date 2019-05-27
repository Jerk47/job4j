package tracker;

import java.util.*;

public class Tracker {
    private final List<Item> items = new ArrayList();
    private int position = 0;
    final Random random = new Random();

    public List<Item> getItems() {
        return items;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(this.position, item);
        position++;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean checkReplace = false;
        for (int i = 0; i <= position; i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.add(i, item);
                item.setId(id);
                checkReplace = true;
                break;
            } else {
                break;
            }
        }
        return checkReplace;
    }

    public boolean delete(String id) {
        boolean checkDelete = false;
        for (int j = 0; j < position; j++) {
            if (this.items.get(j).getId().equals(id)) {
                items.remove(this.items.get(j));
                position--;
                checkDelete = true;
                break;
            }
        }
        return checkDelete;
    }

    public List<Item> findAll() {
         items.removeAll(Collections.singleton(null));
         return items;
        }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (this.items.get(i) != null
                    && this.items.get(i).getName().equals(key)) {
                result.add(count++,this.items.get(i));
            }
        }
        List<Item> resultArr = new ArrayList<Item>(result);
        return resultArr;
    }

    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < position; i++) {
            if (this.items.get(i).getId().equals(id)) {
                item = this.items.get(i);
                break;
            }
        }
        return item;
    }

    private String generateId() {
        return String.valueOf(random.nextInt(100));
    }
}
