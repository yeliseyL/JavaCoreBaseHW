public class HomeWork1 {
    public static void main(String[] args) {
        //Создать переменные всех пройденных типов данных, и инициализировать их значения.
        int a = 5;
        int b = 10;
        double c = -15.5;
        float d = 8.6f;
        int year = 2005;
        String name = "Вася";
        char letter = 'X';
        boolean yesNo = true;

        //Вызов методов.
        System.out.println(expression(a, b, c, d));
        System.out.println(compareNumbers(a, b));
        numberSign((int) c);
        System.out.println(isNegative((int) d));
        helloName(name);
        isLeapYear(year);
    }

    /*
    Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     где a, b, c, d – входные параметры этого метода.
    */
    public static double expression(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    /*
    Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    если да – вернуть true, в противном случае – false;
    */
    public static boolean compareNumbers(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    /*
    Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом.
    */
    public static void numberSign(int number) {
        if (number < 0) {
            System.out.println("Отрицательное число");
        } else {
            System.out.println("Положительное число");
        }
    }

    /*
    Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
    если число отрицательное.
    */
    public static boolean isNegative(int number) {
        return number < 0;
    }

    /*
    Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    */
    public static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /*
    Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
    public static void isLeapYear(int year) {
        if (year % 4 == 0) {
            System.out.println(year + " - високосный год.");
        } else if (year % 400 == 0 && year % 100 != 0) {
            System.out.println(year + " - високосный год.");
        } else {
            System.out.println(year + " - не високосный год.");
        }
    }
}
