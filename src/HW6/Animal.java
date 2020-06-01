package HW6;

public class Animal {
    protected String name;
    private static int animalCount;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int length) {
        System.out.printf("%s has run %d m.", name, length);
        System.out.println();
    }

    public void swim(int length) {
        System.out.printf("%s has swum %d m.", name, length);
        System.out.println();
    }
}
