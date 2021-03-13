package JavaSecondLessonOne;

import static JavaSecondLessonOne.HelpMethod.random;
import static JavaSecondLessonOne.Team.maxPersonCount;

public class Course {
    public static int lengthTreadmill;
    public static int heightWall;


    public Course() {
        Treadmill treadmill = new Treadmill(random(500));
        lengthTreadmill = treadmill.lengthTreadmill;
        Wall wall = new Wall(random(10));
        heightWall = wall.heightWall;

    }

    public static Boolean doTreadmillTest(int maxRun) {
        return maxRun >= lengthTreadmill;
    }

    public static Boolean doWallTest(int maxJump) {
        return maxJump >= heightWall;
    }

    void doCourse() {
        for (int i = 0; i < maxPersonCount; i++) {

            Main.team.getTeamDTO(i);
        }
    }
}
