package JavaSecondLessonOne;

public class Robot {
    public final String name;
    public int maxJump;
    public int maxRun;

    public Robot(String name) {
        this.name = name;
        this.maxJump = 10;
        this.maxRun = 1000;
    }

    public static void toJump(String name) {
        System.out.println(name + " готовится перепрыгнуть стену.\n");
    }

    public static void toRun(String name) {
        System.out.println(name + " начинает бежать.\n");
    }
}
