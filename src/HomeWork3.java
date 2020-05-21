import java.util.*;

public class HomeWork3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите игру: 0 - Угадать число / 1 - Угадать слово");
        int choice = scanner.nextInt();
        if (choice == 0) {
            guessNumber();
        } else if (choice == 1) {
            guessWord();
        }
    }

    /*
     * 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать
     * это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
     * или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
     * 1 – да / 0 – нет» (1 – повторить, 0 – нет).
     * */
    public static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int bound = 10;
        int guess;
        int again;
        do {
            int movesNumber = 3;
            int answer = random.nextInt(10);
            System.out.printf("Угадайте число от 0 до %d. Попыток осталось: %d.\n", bound - 1, movesNumber);
            do {
                guess = scanner.nextInt();
                movesNumber--;
                if (guess < answer) {
                    System.out.printf("Неверный ответ, ваше число меньше загаданного. Попыток осталось: %d.\n", movesNumber);
                } else if (guess > answer) {
                    System.out.printf("Неверный ответ, ваше число больше загаданного. Попыток осталось: %d.\n", movesNumber);
                } else {
                    System.out.println("Поздравляем, вы выиграли!");
                    break;
                }
            } while (movesNumber > 0);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            again = scanner.nextInt();
        } while (again == 1);
    }

    /*
     * 2.Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
     * "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
     * "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
     * словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые
     * стоят на своих местах.
     * */
    public static void guessWord() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String answer = words[random.nextInt(words.length)];
        String guess;
        String grid = "###############";
        do {
            char[] letters = grid.toCharArray();
            System.out.println("Guess the word:");
            guess = scanner.nextLine();
            if (guess.equals(answer)) {
                System.out.println("Congratulations, you win!");
                break;
            } else {
                int length;
                if (answer.length() < guess.length()) {
                    length = answer.length();
                } else {
                    length = guess.length();
                }
                for (int i = 0; i < length; i++) {
                    if (guess.charAt(i) == answer.charAt(i)) {
                        letters[i] = answer.charAt(i);
                    }
                }
                System.out.println(String.valueOf(letters));
            }
        } while (true);
    }
}
