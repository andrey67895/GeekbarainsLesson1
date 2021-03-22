package JavaTwoLessonThree;

import java.util.*;

public class PartOne {


    public static int index = 0;
    public static String[] value = new String[100];
    public static int[] countValue = new int[100];
    public static String[] words = new String[]{"Азалия", "Щекастый", "Договорить", "Дополнение", "Щекастый", "Азалия",
            "Микроб", "Щекастый", "Дополнение", "Апофеоз", "Щекастый", "Возвышенный", "Восемьдесят", "Щекастый",
            "Азалия", "Публицистичный", "Щекастый", "Дополнение", "Цивилизовать", "Щекастый" };

    public static void uniqAndCounting(String[] words) {
        Set<String> digitsSet = new HashSet<>(Arrays.asList(words));
        List<String> digitList = new ArrayList<>(Arrays.asList(words));
        Iterator<String> iterator = digitsSet.iterator();
        while (iterator.hasNext()) {
            String val = iterator.next();
            int count = Collections.frequency(digitList, val);
            saveArray(val, count);
        }
    }


    public static void saveArray(String val, int count) {
        value[index] = val;
        countValue[index] = count;
        index++;
    }

    public static void printOnlyValue() {
        for (int i = 0; i < (index); i++) {
            System.out.println(value[i]);
        }
    }

    public static void printValueAndCount() {
        for (int i = 0; i < (index); i++) {
            System.out.println("В массиве данных слово " + value[i] + " встречается " + countValue[i] + " раз.");
        }
    }
}
