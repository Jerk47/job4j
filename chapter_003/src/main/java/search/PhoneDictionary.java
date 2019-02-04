package search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person personList : persons) {
            if (personList.getName().contains(key) || (personList.getSurname().contains(key) || personList.getPhone()
                    .contains(key) || personList.getAddress().contains(key))) {
                result.add(personList);
            }
        }
        return result;
    }
}
