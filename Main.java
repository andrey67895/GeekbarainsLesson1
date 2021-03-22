package JavaTwoLessonThree;

import static JavaTwoLessonThree.PartOne.*;




public class Main {


    public static void main(String[] args) {

        uniqAndCounting(new String[]{"Азалия", "Щекастый", "Договорить", "Дополнение", "Щекастый", "Азалия",
                "Микроб", "Щекастый", "Дополнение", "Апофеоз", "Щекастый", "Возвышенный", "Восемьдесят", "Щекастый",
                "Азалия", "Публицистичный", "Щекастый", "Дополнение", "Цивилизовать", "Щекастый" });
        printOnlyValue();
        printValueAndCount();

        Phonebook phonebook = new Phonebook();
        phonebook.add("Petrob", "7777777777");
        phonebook.add("Petrob", "7777777778");
        phonebook.add("Petrob", "7777777779");
        phonebook.add("ivanov", "7777777776");
        phonebook.add("IScscsanov", "7777777777");
        System.out.println(phonebook.get("Petrob"));
        System.out.println(phonebook.get("ivanov"));
        System.out.println(phonebook.get("IScscsanov"));

    } 
}
