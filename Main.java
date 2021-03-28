package JavaTwoLessonFive;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 1. Необходимо написать два метода, которые делают следующее:
 * <p>
 * 1) Создают одномерный длинный массив, например:
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 * <p>
 * Пример деления одного массива на два:
 * System.arraycopy(arr, 0, a1, 0, h);
 * System.arraycopy(arr, h, a2, 0, h);
 * Пример обратной склейки:
 * System.arraycopy(a1, 0, arr, 0, h);
 * System.arraycopy(a2, 0, arr, h, h);
 * <p>
 * Примечание:
 * System.arraycopy() – копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */


public class Main {
    public static final int size = 10000000;
    public static final int h = size / 2;
    public static float[] arr1 = new float[size];

    public static void main(String[] args) throws InterruptedException {
        firstMethod(arr1);
        secondMethod(arr1);


    }

    public static void putOnes(float[] arr) {
        Arrays.fill(arr, 1);
    }

    public static void putNewValues(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void firstMethod(float[] arr) {
        putOnes(arr);
        long a = System.currentTimeMillis();
        putNewValues(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void secondMethod(float[] arr) throws InterruptedException {
        putOnes(arr);
        AtomicBoolean firstThread = new AtomicBoolean(true);
        AtomicBoolean secondThread = new AtomicBoolean(true);
        long a = System.currentTimeMillis();
        new Thread(() -> {
            float[] a1 = new float[h];
            System.arraycopy(arr, 0, a1, 0, h);
            putNewValues(a1);
            System.arraycopy(a1, 0, arr, 0, h);
            firstThread.set(false);

        }).start();
        new Thread(() -> {
            float[] a2 = new float[h];
            System.arraycopy(arr, h, a2, 0, h);
            putNewValues(a2);
            System.arraycopy(a2, 0, arr, h, h);
            secondThread.set(false);
        }).start();
        do {
            Thread.sleep(1);
        } while (firstThread.get() || secondThread.get());
        System.out.println(System.currentTimeMillis() - a);
    }
}