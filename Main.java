package JavaTwoLessonFour;

import Chat.MyChat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Создать коллекцию типа List.
 * Наполнить ее значениями
 * и вывести значения в консолько при помощи ее метода forEach.
 * <p>
 * <p>
 * Создать утилитарный метод forItem.
 * Метод принимает два параметра: Коллекция Set<String> и консьюмер типа Consumer<String>.
 * Внутри метода проитерироваться по коллекции
 * и для каждого элемента выполнить метод консьюмера accept, который выводит значение элемента в консоль.
 * <p>
 * <p>
 * Создать утилитарный метод doubleUp.
 * Метод принимает два параметра: значение типа int и консьюмер типа Supplier<Integer>.
 * Внутри метода выполнить метод саплаера get, который возвращает множитель и затем переданное значение на него умножается.
 * Фукнция возращает результат произведения.
 * <p>
 * <p>
 * Создать метод findAllChars.
 * Метод принимает два параметра: String target и char toFind.
 * Первый параметр является входной строкой, а второй - символ, который необходимо найти в входящей строке.
 * Учесть что искомый символ может повторяется (напр.: 'ccch').
 * Необходимо найти все повторения и вернуть в виде конкатенированной строки обвернутый в Optional.
 * Если ни одного совпадения не найдено, тогда необходимо вернуть пустой Optional.
 * Пример выполнения: Optional<String> opt = findAllChars("ccch", 'c'); opt.get(); // вернет "ссс".
 * <p>
 * <p>
 * Создать окно для клиентской части чата:
 * большое текстовое поле для отображения переписки в центре окна.
 * Однострочное текстовое поле для ввода сообщений
 * и кнопка для отсылки сообщений на нижней панели.
 * Сообщение должно отсылаться либо по нажатию кнопки на форме,
 * либо по нажатию кнопки Enter.
 * При «отсылке» сообщение перекидывается из нижнего поля в центральное. (ОПЦИОНАЛЬНО)
 */

public class Main {
    public static String[] name = new String[]{"Andrey", "Lida", "Polina", "Nastia", "Leo", "Alex", "Vera", "Nikolay"};


    public static void main(String[] args) {


        System.out.println("\nКейс 1");
        List<String> nameLists = new ArrayList<>(Arrays.asList(name));
        nameLists.forEach(System.out::println);


        System.out.println("\nКейс 2");

        Set<String> nameSets = new HashSet<>(Arrays.asList(name));
        Consumer<String> consumer = System.out::println;
        forItem(nameSets, consumer);


        System.out.println("\nКейс 3");
        Supplier<Integer> supplier = () -> 2;
        System.out.println(doubleUp(10, supplier));


        System.out.println("\nКейс 4");
        Optional<String> opt = findAllChars("qwertyujnbvvvcccccrtyuik", 'c');
        opt.ifPresent(System.out::println);

        System.out.println("\nКейс 5 - Чатик");
        MyChat myChat = new MyChat();

    }


    public static void forItem(Set<String> name, Consumer<String> consumer) {
        name.forEach(consumer);
    }


    public static Optional<String> findAllChars(String word, char symbol) {
        String allChars = null;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol) {
                if (allChars == null) {
                    allChars = String.valueOf(word.charAt(i));
                } else {
                    allChars = allChars + word.charAt(i);
                }
            }
        }

        return Optional.ofNullable(allChars);
    }

    public static int doubleUp(int intNotDouble, Supplier<Integer> supplier) {
        return (intNotDouble * supplier.get());
    }
}
