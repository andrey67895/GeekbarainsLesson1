package Lesson_seven;

public class Main {
    public static int maxCat = 5;

    public static void main(String[] args) {

        Cat[] arrCats = new Cat[maxCat];
        arrCats[0] = new Cat("Первый", 25);
        arrCats[1] = new Cat("Второй", 30);
        arrCats[2] = new Cat("Третий", 50);
        arrCats[3] = new Cat("Четвертый", 20);
        arrCats[4] = new Cat("Пятый", 50);

        Plate plate = new Plate(100);

        for (int i = 0; i < maxCat; i++) {
            arrCats[i].eat(plate);
            arrCats[i].info();
        }

        plate.info();
        plate.addFood(100);
        plate.info();
    }
}
