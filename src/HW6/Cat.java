package HW6;

public class Cat extends Animal {
    private static int catCount;
    private final int RUN_LIMIT;

    public Cat(String name, int runLimit) {
        super(name);
        this.RUN_LIMIT = runLimit;
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int length) {
        if (length <= RUN_LIMIT) {
            super.run(length);
        } else {
            System.out.printf("%s can't run this long!", name);
            System.out.println();
        }
    }

    @Override
    public void swim(int length) {
        System.out.printf("%s can't swim!", name);
        System.out.println();
    }
}
