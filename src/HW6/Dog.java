package HW6;

public class Dog extends Animal {
    private static int dogCount;
    private final int RUN_LIMIT;
    private final int SWIM_LIMIT;

    public Dog(String name, int runLimit, int swimLimit) {
        super(name);
        this.RUN_LIMIT = runLimit;
        this.SWIM_LIMIT = swimLimit;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
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
        if (length <= SWIM_LIMIT) {
            super.swim(length);
        } else {
            System.out.printf("%s can't swim this long!", name);
            System.out.println();
        }
    }
}
