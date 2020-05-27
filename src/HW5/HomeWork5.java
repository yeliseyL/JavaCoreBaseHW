package HW5;

public class HomeWork5 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Elliot Alderson", "Developer", "elliot@evilcorp.com", "555-111-11-11", 8000, 25),
                new Employee("Tyrell Wellick", "CEO", "tyrell@evilcorp.com", "555-222-22-22", 15000, 43),
                new Employee("Angela Moss", "Admin", "angela@evilcorp.com", "555-333-33-33", 7000, 31),
                new Employee("Grace Gummer", "Head of Security", "grace@evilcorp.com", "555-444-44-44", 10000, 41),
                new Employee("Gideon Goddard", "Lead Developer", "gideon@evilcorp.com", "555-555-55-55", 9000, 34),
        };

        for (Employee person : employees) {
            if (person.getAge() > 40) {
                person.info();
            }
        }
    }
}
