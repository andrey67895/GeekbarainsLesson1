package Lesson_seven;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = true;
    }

    void info() {
        System.out.println(name + " имеет аппетит " + appetite + ".\n" + name + " приступает к еде.");
        String isHungry;
        if (!satiety) {
            isHungry = " сыт/сыта";
        } else {
            isHungry = " остается голодным/голодной,т.к. в тарелке мало еды.";
        }
        System.out.println(name + isHungry);
    }

    public void eat(Plate plate) {
        if (satiety && plate.eatFood(appetite)) {
            satiety = false;
        }
        System.out.println("=====================================");
    }
}
