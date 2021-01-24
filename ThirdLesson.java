import java.util.Scanner;

public class ThirdLesson {
    public static int randomIntMaxSize = 9;
    public static int maxSizeAnswersPersonal = 3;
    public static int exitCount = 0;
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        getGameInFirstTask();
        getGameInSecondTask();
    }

    public static void getGameInSecondTask() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String qwest = words[randomInt(words.length - 1)];
        char a;
        char b;
        String c = "";
        String ab = "";
        String answerPerson = "";


        System.out.println(qwest); // DEBUG
        do {
            ab = "";
            System.out.print("Введите слово ");
            answerPerson = scanner.nextLine();
            for (int i = 0; i < 15 || ab.length() < 15; i++) {
                if (qwest.equals(answerPerson)) {
                    break;
                }
                if (i < answerPerson.length() && i < qwest.length()) {
                    a = qwest.charAt(i);
                    b = answerPerson.charAt(i);
                    if (a == b) {
                        c = String.valueOf(a);
                        ab = ab + c;
                    } else {
                        for (int y = i; y < 15; y++) {
                            ab = ab + "#";
                        }
                        System.out.println(ab);
                        break;
                    }
                } else {
                    for (int y = i; y < 15; y++) {
                        ab = ab + "#";
                    }
                    System.out.println(ab);
                    break;
                }
            }

        } while (!qwest.equals(answerPerson));
        System.out.println("Вы отгадали: " + qwest);
    }

    public static void getGameInFirstTask() {
        do {
            int getRandomInt = randomInt(randomIntMaxSize);
            System.out.println("Угадайте число от 0 до 9! Ваше число?");
            for (int i = 0; i <= maxSizeAnswersPersonal; i++) {
                int personalAnswer = 0;
                if (scanner.hasNextInt()) {
                    personalAnswer = scanner.nextInt();
                }
                if (i < (maxSizeAnswersPersonal - 1) || personalAnswer == getRandomInt) {

                    if (personalAnswer == getRandomInt) {
                        System.out.println("Вы угадали");
                        exitCode();
                        break;
                    } else {
                        System.out.println("Повторите попытку!");
                        if (personalAnswer < getRandomInt) {
                            System.out.println("Ваше число меньше загаданного!");
                        } else {
                            System.out.println("Ваше число больше загаданного!");
                        }
                    }
                } else {
                    System.out.println("Вы не отгадали!");
                    exitCode();
                    break;
                }
            }

        } while (exitCount == 1);
    }

    public static int randomInt(int randomInt) {
        return (int) Math.round(Math.random() * randomInt);
    }

    public static void exitCode() {
        System.out.println("Если Вы хотите продолжить играть введите 1, если выйти введите 0");
        int exitAnswer = 0;
        do {
            if (scanner.hasNextInt()) {
                exitAnswer = scanner.nextInt();
            }
            if (exitAnswer == 0) {
                exitCount = 0;
                System.out.println();
            } else if (exitAnswer == 1) {
                exitCount = 1;
                System.out.println("Продолжаем игру");
            } else {
                System.out.println("Вы ввели некорректное значение. 0 - Выход / 1 - Продолжить игру");
                exitCount = 2;
            }
        } while (exitCount == 2);
    }
}