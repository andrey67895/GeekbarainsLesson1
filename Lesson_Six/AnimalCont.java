package Lesson_Six;

import static Lesson_Six.Cat.*;
import static Lesson_Six.Dog.*;


public class AnimalCont {


    public static void main(String[] args) {
        Cat[] cat = new Cat[maxCat];
        cat[0] = new Cat("Котенок", 600);
        cat[1] = new Cat("Гуся", 300);
        cat[2] = new Cat("Воплощение Зла", -200);

        for (int i = 0; i < maxCat; i++) {
            cat[i].toRun(cat[i].name, cat[i].runningLength, maxRunningLengthCat);
            cat[i].toSwim(cat[i].name);
        }

        Dog[] dog = new Dog[dogCount];
        dog[0] = new Dog("Брусок", 600, 9);
        dog[1] = new Dog("Шарик", 300, 20);
        dog[2] = new Dog("Гав", -200, -9);


        for (int i = 0; i < dogCount; i++) {
            dog[i].toRun(dog[i].name, dog[i].runningLength, maxRunningLengthDog);
            dog[i].toSwim(dog[i].name, dog[i].swimmingLength, maxSwimLengthDog);
        }
    }
}
