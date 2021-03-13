package JavaSecondLessonOne;

public class Main {
    public static Team team;

    public static void main(String[] args) {
            Course course = new Course();
            team = new Team("Победители", new String[]{"Cat", "Cat", "Robot", "Human"}, new String[]{"Васька", "Муся", "Кибердруг", "Антон"});
            team.name = "Победители";
            team.allPerson();
            course.doCourse();
            team.completePerson();
       }
}
