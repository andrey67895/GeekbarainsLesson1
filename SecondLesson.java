import java.util.Arrays;

public class SecondLesson {

    public static int[] arrayFirst = new int[10];
    public static int[] arraySecond = new int[8];
    public static int[] arrayThird = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    public static int[][] arrayFour = new int[5][5];
    public static int[] arrayFive = new int[10];
    public static int[] arraySix = new int[10]; 


    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayGenerationFirst(arrayFirst))); // FirstTask
        System.out.println(Arrays.toString(arrayGenerationSecond(arraySecond))); // SecondTask
        System.out.println(Arrays.toString(arrayChangeThird(arrayThird))); // ThirdTask
        System.out.println(Arrays.deepToString(arrayChangeFour(arrayFour))); // FourTask
        System.out.println(arrayChangeFive(arrayFive)); // FiveTask
        System.out.println(arrayChangeSix(arraySix)); // SixTask
    }

    public static int[] arrayGenerationFirst(int[] arrayFirst) {
        for (int i = 0; i < arrayFirst.length; i++) {
            arrayFirst[i] = (int) Math.round(Math.random());
        }
        System.out.println(Arrays.toString(arrayFirst));
        return arrayFunction(arrayFirst);
    }

    public static int[] arrayFunction(int[] arrayFirst) {
        for (int i = 0; i < arrayFirst.length; i++) {
            if (arrayFirst[i] == 0) {
                arrayFirst[i] = 1;
            } else {
                arrayFirst[i] = 0;
            }
        }
        return arrayFirst;
    }

    public static int[] arrayGenerationSecond(int[] arraySecond) {
        for (int i = 1; i < arraySecond.length; i++) {
            arraySecond[i] = arraySecond[i - 1] + 3;
        }
        return arraySecond;
    }

    public static int[] arrayChangeThird(int[] arrayThird) {
        for (int i = 0; i < arrayThird.length; i++) {
            if (arrayThird[i] < 6) {
                arrayThird[i] = arrayThird[i] * 2;
            }
        }
        return arrayThird;
    }

    public static int[][] arrayChangeFour(int[][] arrayFour) {
        for (int i = 0; i < arrayFour.length; i++) {
            arrayFour[i][i] = 1;
        }
        return arrayFour;
    }

    public static String arrayChangeFive(int[] arrayFive) {
        for (int i = 0; i < arrayFive.length; i++) {
            arrayFive[i] = (int) Math.round(Math.random() * 100);
        }
        System.out.println(Arrays.toString(arrayFive));
        return arrayFunctionMaxAndMin(arrayFive);
    }

    public static String arrayFunctionMaxAndMin(int[] arrayFive) {
        int maxValue = arrayFive[0];
        int minValue = arrayFive[0];
        for (int i = 0; i < arrayFive.length; i++) {
            if (maxValue < arrayFive[i])
                maxValue = arrayFive[i];
        }
        for (int i = 0; i < arrayFive.length; i++) {
            if (minValue > arrayFive[i])
                minValue = arrayFive[i];
        }
        return "Максимум: " + maxValue + " Минимум: " + minValue;
    }

    public static boolean arrayChangeSix(int[] arraySix) {
        for (int i = 0; i < arraySix.length; i++) {
            arraySix[i] = (int) Math.round(Math.random() * 3);
        }
        System.out.println(Arrays.toString(arraySix));
        return arrayFunctionTrueOrFalse(arraySix);
    }

    public static boolean arrayFunctionTrueOrFalse(int[] arraySix) {
        int leftSum = arraySix[0];
        int rigthSum = arraySix[arraySix.length - 1];
        for (int i = 1, y = 2; (i + y) < arraySix.length + 1; ) {
            if (leftSum < rigthSum) {
                leftSum = leftSum + arraySix[i];
                i++;
            } else {
                rigthSum = rigthSum + arraySix[arraySix.length - y];
                y++;
            }
        }
        System.out.println(leftSum + " " + rigthSum);
        return leftSum == rigthSum;
    }
}