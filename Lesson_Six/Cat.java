package Lesson_Six;

public class Cat extends Animal {
    public static final int maxCat = 3;
    public static final Integer maxRunningLengthCat = 200;
    public final String name;
    public final Integer runningLength;

    public Cat(String name, Integer runningLength) {
        this.name = name;
        this.runningLength = runningLength;
    }



    void toSwim(String name) {
        System.out.println(name + " не умеет плавать\n");
    }
}