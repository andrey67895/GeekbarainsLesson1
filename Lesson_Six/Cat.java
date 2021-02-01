package Lesson_Six;

public class Cat extends Animal {
    private static final int maxCat = 3;
    private static final Integer maxRunningLength = 200;
    private final String name;
    private final Integer runningLength;

    public Cat(String name, Integer runningLength) {
        this.name = name;
        this.runningLength = runningLength;
    }

    public static void main(String[] args) {
        Cat[] cat = new Cat[maxCat];
        cat[0] = new Cat("Котенок", 600);
        cat[1] = new Cat("Гуся", 300);
        cat[2] = new Cat("Воплощение Зла", -200);

        for (int i = 0; i < maxCat; i++) {
            cat[i].toRun(cat[i].name, cat[i].runningLength, maxRunningLength);
            cat[i].toSwim(cat[i].name);
        }
    }

    void toSwim(String name) {
        System.out.println(name + " не умеет плавать");
    }
}