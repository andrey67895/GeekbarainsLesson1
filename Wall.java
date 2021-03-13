package JavaSecondLessonOne;

public class Wall {
    public final int heightWall;

    public Wall(int heightWall) {
        this.heightWall = heightWall;
    }

    public static void getJump(String name, Boolean completed) {
        if (completed) {
            System.out.println(name + " преодолел стену.\n");
        } else {
            System.out.println(name + " не смог преодолеть стену. И сошел с полосы препятсвия.\n");
        }
    }
}
