package HW7;

public class Cat {
    private String name;
    private int appetite;
    private boolean loaded = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            loaded = true;
            appetite = 0;
        }
    }
}

