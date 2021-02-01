package Lesson_Six;

public class Dog extends Animal {
    private static final int dogCount = 3;
    private static final Integer maxRunningLength = 500;
    private static final Integer maxSwimLength = 10;
    private final String name;
    private final Integer swimmingLength;
    private final Integer runningLength;

    public Dog(String name, int runningLength, int swimmingLength) {
        this.name = name;
        this.runningLength = runningLength;
        this.swimmingLength = swimmingLength;
    }

    public static void main(String[] args) {
        Dog[] dog = new Dog[dogCount];
        dog[0] = new Dog("Брусок", 600, 9);
        dog[1] = new Dog("Шарик", 300, 20);
        dog[2] = new Dog("Гав", -200, -9);


        for (int i = 0; i < dogCount; i++) {
            dog[i].toRun(dog[i].name, dog[i].runningLength, maxRunningLength);
            dog[i].toSwim(dog[i].name, dog[i].swimmingLength, maxSwimLength);
        }

    }


}
