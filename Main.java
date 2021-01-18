public class Main {

    public static void main(String[] args) {
        byte aByte = 5;
        short aShort = 10;
        int anInt = 100;
        long aLong = 100L;

        float newFloat = 1.0F;
        double aDouble = 1.0;

        char aChar = 'd';

        boolean aBoolean = true;

        String string = "Hello, world";


        System.out.println(methodResultFloat(1.0F, 2.0F, 3.0F, 4.0F));
        System.out.println(trueOrFalse(4, 4));
        possitiveNumbers(3);
        System.out.println(truePossitiveNumbers(-10));
        helloName("Андрей");
        yearMethod(2020);
    }

    public static float methodResultFloat(float aFloat, float bFloat, float cFloat, float dFloat) {
        return aFloat * (bFloat + (cFloat / dFloat));

    }

    public static boolean trueOrFalse(int a, int b) {
        int d = a + b;
        return d > 10 && d < 20;
    }

    public static void possitiveNumbers(int possitive) {
        if (possitive < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean truePossitiveNumbers(int possitive) {
        return possitive < 0;
    }

    public static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }


    public static void yearMethod(int yearNew) {
        if ((yearNew % 4) == 0) {
            if ((yearNew % 100) == 0) {
                System.out.println(yearNew + " - этот год не является високосным");
            } else if ((yearNew % 400) == 0) {
                System.out.println(yearNew + " - этот год является високосным");
            } else {
                System.out.println(yearNew + " - этот год является високосным");
            }

        }
        else {
            System.out.println(yearNew + " - этот год является не високосным");
        }
    }
}
