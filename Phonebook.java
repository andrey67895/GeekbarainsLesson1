package JavaTwoLessonThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    Map<String, List<String>> phonebook = new HashMap<>();
    List<String> phoneNumberLists = new ArrayList<>();

    public void add(String surname, String phone_number) {
        if (phonebook.containsKey(surname)) {
            phoneNumberLists = phonebook.get(surname);
            phoneNumberLists.add(phone_number);
            phonebook.put(surname, phoneNumberLists);
        } else {
            phoneNumberLists = new ArrayList<>();
            phoneNumberLists.add(phone_number);
            phonebook.put(surname, phoneNumberLists);
        }
    }

    public List<String> get(String surname) {
        return phonebook.get(surname);
    }

}
