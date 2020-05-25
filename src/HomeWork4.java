import java.util.*;

public class HomeWork4 {
    public static int SIZE = 5;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    /*
     * Переделать проверку победы, чтобы она не была реализована просто набором условий, например,
     * с использованием циклов. Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5
     * и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
     * */
    public static boolean checkWin(char symb) {
        int counter;
        for (int i = 0; i < SIZE; i++) {
            counter = SIZE;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    counter--;
                }
            }
            if (counter == 0) {
                return true;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            counter = SIZE;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    counter--;
                }
            }
            if (counter == 0) {
                return true;
            }
        }

        counter = SIZE;
        for (int j = 0; j < SIZE; j++) {
            if (map[j][j] == symb) {
                counter--;
            }
        }
        if (counter == 0) {
            return true;
        }

        counter = SIZE;
        for (int j = 0; j < SIZE; j++) {
            if (map[SIZE - j - 1][j] == symb) {
                counter--;
            }
        }
        if (counter == 0) {
            return true;
        }

        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    /*
     * Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
     * */
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));

        outerloop:
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(j, i)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        x = j;
                        y = i;
                        break outerloop;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
