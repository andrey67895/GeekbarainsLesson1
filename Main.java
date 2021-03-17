package JavaTwoLessonTwo;


public class Main {
    private static final int maxArrayLength = 4;
    private static final String[][] arr = {{"1", "1", "1", "4"}, {"1", "1", "5", "4"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};


    public static void main(String[] args) {

        System.out.println(sumArray(arr));
    }

    private static void checkingTheLength() {
        if (arr.length != maxArrayLength) {
            throw new MySizeArrayException("Общая длина массива данных больше или меньше " + maxArrayLength + ". Общая длина массива = " + arr.length);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != maxArrayLength) {
                    throw new MySizeArrayException("Длина одной из ячеек массива данных больше или меньше " + maxArrayLength + ". Длина массива ячейки [" + i +"] = " + arr[i].length);
                }
            }
        }
    }

    private static int sumArray(String[][] array) {
        checkingTheLength();
        int sumArrays = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumArrays = sumArrays + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Неверный формат данных в ячейке [" + i + "][" + j + "]", ex);
                }
            }
        }
        return sumArrays;
    }
}