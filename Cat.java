package JavaSecondLessonOne;

public class Cat {


    public final String name;
    public int maxJump;
    public int maxRun;


    public Cat(String name) {
        this.name = name;
        this.maxJump = 3;
        this.maxRun = 200;
    }

    public static void toJump(String name) {
        System.out.println(name + " готовится перепрыгнуть стену.\n");
    }

    public static void toRun(String name) {
        System.out.println(name + " начинает бежать.\n");
    }
}
