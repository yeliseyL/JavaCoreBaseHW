package HW5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int wage;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int wage, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wage = wage;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.println("Name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Wage: " + wage);
        System.out.println("Age: " + age);
        System.out.println();
    }
}
