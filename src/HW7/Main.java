package HW7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 20),
                new Cat("Garold", 35),
                new Cat("Murzik", 40),
                new Cat("Cheshir", 15),
                new Cat("Snow", 10),
        };
        Plate plate = new Plate(100);
        plate.info();

        feedCat(cats, plate);  //кормим котов первый раз
        plate.addFood(50);  //добавляем еду в тарелку
        plate.info();
        feedCat(cats, plate);  //кормим котов еще
    }

    public static void feedCat(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eat(plate);
            if (cat.isLoaded()) {
                System.out.println(cat.getName() + " is loaded. Food remaining: " + plate.getFood());
            } else {
                System.out.println(cat.getName() + " is still hungry! Food remaining: " + plate.getFood());
            }
        }
        System.out.println();
    }

}
