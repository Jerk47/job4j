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
            return name + " " + age;
        }

    }

    public Set<User> sort(List<User> users) {
        Set<User> sorted_users = new TreeSet<>();
        sorted_users.addAll(users);
        return sorted_users;
    }

    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.name.length(), user2.name.length());
            }
        });
        return users;
    }

    public List<User> sortByAllField(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int name = user1.name.compareTo(user2.name);
                if (name == 0) {
                    return Integer.compare(user1.age.length(), user2.age.length());
                }
               return name;
            }
        });
        return users;
    }
}

