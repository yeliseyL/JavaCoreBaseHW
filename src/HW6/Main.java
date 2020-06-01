package HW6;

public class Main {
    public static void main(String[] args) {
        Dog dogArchi = new Dog("Archi", 500, 30);
        Dog dogBaron = new Dog("Baron", 100, 20);
        Dog dogTuzik = new Dog("Tuzik", 250, 60);
        Cat catMurzik = new Cat("Murzik", 150);
        Cat catGarold = new Cat("Garold", 80);

        dogArchi.run(200);
        dogBaron.swim(30);
        dogTuzik.run(240);
        catMurzik.swim(30);
        catGarold.run(90);
        System.out.println("Animal count: " + Animal.getAnimalCount());
        System.out.println("Dog count: " + Dog.getDogCount());
        System.out.println("Animal count: " + Cat.getCatCount());

    }
}
