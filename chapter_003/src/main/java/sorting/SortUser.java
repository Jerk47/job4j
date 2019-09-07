package sorting;

import java.util.*;

public class SortUser {
    static class User implements Comparable<User> {
        private final String age;
        private final String name;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(User o) {
            return this.age.compareTo(o.age);
        }

        @Override
        public String toString() {
            return age;
        }
    }

    public Set<User> sort(List<User> users) {
        Set<User> sorted_users = new TreeSet<>();
        sorted_users.addAll(users);
        return sorted_users;
    }
}
