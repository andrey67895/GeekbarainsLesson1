package JavaSecondLessonOne;

import static JavaSecondLessonOne.Course.doTreadmillTest;
import static JavaSecondLessonOne.Course.doWallTest;

public class Team {
    public static int maxPersonCount = 4;
    public String name;
    public Boolean[] complete = new Boolean[maxPersonCount];
    public int[] indexPerson = new int[maxPersonCount];
    public String[] classPerson = new String[maxPersonCount];
    public String[] personName = new String[maxPersonCount];
    public int[] maxJump = new int[maxPersonCount];
    public int[] maxRun = new int[maxPersonCount];

    public Team(String name, String[] classPerson, String[] personName) {
        this.name = name;
        for (int i = 0; i < maxPersonCount; i++) {
            switch (classPerson[i]) {
                case "Cat":
                    Cat cat = new Cat(personName[i]);
                    this.indexPerson[i] = i;
                    this.classPerson[i] = classPerson[i];
                    this.personName[i] = personName[i];
                    this.maxJump[i] = cat.maxJump;
                    this.maxRun[i] = cat.maxRun;
                    this.complete[i] = true;
                    break;
                case "Human":
                    Human human = new Human(personName[i]);
                    this.indexPerson[i] = i;
                    this.classPerson[i] = classPerson[i];
                    this.personName[i] = personName[i];
                    this.maxJump[i] = human.maxJump;
                    this.maxRun[i] = human.maxRun;
                    this.complete[i] = true;
                    break;
                case "Robot":
                    Robot robot = new Robot(personName[i]);
                    this.indexPerson[i] = i;
                    this.classPerson[i] = classPerson[i];
                    this.personName[i] = personName[i];
                    this.maxJump[i] = robot.maxJump;
                    this.maxRun[i] = robot.maxRun;
                    this.complete[i] = true;
                    break;
            }
        }
    }

    void getTeamDTO(int i) {

        if (complete[i]) {
            if (classPerson[i].equals("Cat")) {
                Cat.toRun(personName[i]);
            } else if (classPerson[i].equals("Human")) {
                Human.toRun(personName[i]);
            } else {
                Robot.toRun(personName[i]);
            }
            complete[i] = doTreadmillTest(maxRun[i]);
            Treadmill.getRun(personName[i], complete[i]);
        }
        if (complete[i]) {
            if (classPerson[i].equals("Cat")) {
                Cat.toJump(personName[i]);
            } else if (classPerson[i].equals("Human")) {
                Human.toJump(personName[i]);
            } else {
                Robot.toJump(personName[i]);
            }
            complete[i] = doWallTest(maxJump[i]);
            Wall.getJump(personName[i], complete[i]);
        }

    }

    void completePerson() {
        for (int i = 0; i < maxPersonCount; i++) {
            if (complete[i]) {
                System.out.println("Название команды: " + name
                        + "\nID игрока: " + indexPerson[i] +
                        "\nКласс игрока: " + classPerson[i] +
                        "\nИмя игрока: " + personName[i] +
                        "\nПолностью выполнил полосу препятствия!" +
                        "\n----------------------------------------\n"
                );
            }

        }
    }

    void allPerson() {
        for (int i = 0; i < maxPersonCount; i++) {
            System.out.println("Название команды: " + name
                    + "\nID игрока: " + indexPerson[i]
                    + "\nКласс игрока: " + classPerson[i] +
                    "\nИмя игрока: " + personName[i] +
                    "\nМаксимальный прыжок игрока: " + maxJump[i] +
                    "\nМаксимальная длина бега: " + maxRun[i] +
                    "\n----------------------------------------\n"
            );
        }
    }
}
