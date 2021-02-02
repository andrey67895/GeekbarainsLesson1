package Lesson_Six;

public class Dog extends Animal {
    public static final int dogCount = 3;
    public static final Integer maxRunningLengthDog = 500;
    public static final Integer maxSwimLengthDog = 10;
    public final String name;
    public final Integer swimmingLength;
    public final Integer runningLength;

    public Dog(String name, int runningLength, int swimmingLength) {
        this.name = name;
        this.runningLength = runningLength;
        this.swimmingLength = swimmingLength;
    }




}
