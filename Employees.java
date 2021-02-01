public class Employees {

    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employees(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {
        Employees[] employees = new Employees[5];
        employees[0] = new Employees("Пелевина Лариса Прохор", "Следователь", "savva84@hotmail.com", "+7 (909) 800-45-83", 30000, 30);
        employees[1] = new Employees("Судленкова Светлана Лльвона", "Египтолог", "sevastyan5841@outlook.com", "+7 (988) 126-99-49", 40000, 42);
        employees[2] = new Employees("Фирсова Юлиана Давидович", "Воспитатель", "lidiya22101965@outlook.com", "+7 (926) 248-50-15", 50000, 35);
        employees[3] = new Employees("Михалицына Зоя Степановна", "Педиатр", "pavel.alimov@mail.ru", "+7 (970) 410-28-44", 60000, 50);
        employees[4] = new Employees("Корсаков Павел Игнатьевич", "Водитель", "anastasiya01081989@yandex.ru", "+7 (950) 301-31-81", 70000, 60);

        for (int i = 0; i < 5; i++) {
            if (employees[i].age > 40) {
                employees[i].printEmployees();
            }
        }
    }

    public void printEmployees() {
        System.out.println("ФИО: " + this.name + "\nДолжность:" + this.position + "\nEmail: " + this.email + "\nНомер телефона: " + this.phoneNumber + "\nЗарплата: " + this.salary + "\nВозраст: " + this.age + "\n");
    }
}
