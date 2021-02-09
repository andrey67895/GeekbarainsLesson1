package Lesson_seven;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean eatFood(int n) {
        int maxFood = food - n;
        if (maxFood < 0) {
            return false;
        }

        food = food - n;
        return true;
    }

    public void info() {
        System.out.println("В миске: " + food + " еды.");
    }

    public void addFood(int food) {
        System.out.println("=====================================\nДобавляем еду: " + food + "\n=====================================");
        this.food = this.food + food;
    }
}
