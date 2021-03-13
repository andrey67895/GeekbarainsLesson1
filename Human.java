package JavaSecondLessonOne;

public class Human {
    public final String name;
    public int maxJump;
    public int maxRun;

    public Human(String name) {
        this.name = name;
        this.maxJump = 5;
        this.maxRun = 500;
    }

    public static void toJump(String name) {
        System.out.println(name + " готовится перепрыгнуть стену.\n");
    }

    public static void toRun(String name) {
        System.out.println(name + " начинает бежать.\n");
    }
}
