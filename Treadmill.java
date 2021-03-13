package JavaSecondLessonOne;

public class Treadmill {

    public final int lengthTreadmill;

    public Treadmill(int lengthTreadmill) {
        this.lengthTreadmill = lengthTreadmill;
    }


    public static void getRun(String name, Boolean completed) {
        if (completed) {
            System.out.println(name + " преодолел беговую дорожку.\n");
        } else {
            System.out.println(name + " не смог преодолеть беговую дорожку. И сошёл с полоcы препятсвия.\n");
        }
    }
}
