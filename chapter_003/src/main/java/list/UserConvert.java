package list;

import java.util.HashMap;
import java.util.List;

class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> resultMap = new HashMap<>();
        list.forEach(user -> resultMap.put(user.id, user));
        return resultMap;
    }
}