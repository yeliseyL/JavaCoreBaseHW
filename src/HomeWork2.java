import java.util.*;

public class HomeWork2 {
    public static void main(String[] args) {
        int[] zeroToOneArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] fillArrayArr = new int[8];
        int[] multiplyLessThanSixArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] diagonalOnesArr = new int[9][9];
        int[] minMaxArr = {23, 32, 76, 5, 21, 66, 8};
        int[] hasEqualPartsArr = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] shiftElementsArr = {1, 2, 3, 4, 5, 6, 7, 8};
        int pos = 3;

        System.out.println(Arrays.toString(zeroToOne(zeroToOneArr)));
        System.out.println(Arrays.toString(fillArray(fillArrayArr)));
        System.out.println(Arrays.toString(multiplyLessThanSix(multiplyLessThanSixArr)));

        int[][] diagonalOnesResult = diagonalOnes(diagonalOnesArr);
        for (int i = 0; i < diagonalOnesResult.length; i++) {
            System.out.println(Arrays.toString(diagonalOnesResult[i]));
        }

        System.out.println(Arrays.toString(minMax(minMaxArr)));
        System.out.println(hasEqualParts(hasEqualPartsArr));
        System.out.println(Arrays.toString(shiftElements(shiftElementsArr, pos)));
    }

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */
    public static int[] zeroToOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        return arr;
    }

    /*
    2. Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */
    public static int[] fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        return arr;
    }

    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */
    public static int[] multiplyLessThanSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    */
    public static int[][] diagonalOnes(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int length = arr[i].length;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                    arr[i][length - i - 1] = 1;
                }
            }
        }
        return arr;
    }

    /*
    5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    */
    public static int[] minMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int[] minMax = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        minMax[0] = min;
        minMax[1] = max;
        return minMax;
    }

    /*
    6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    */
    public static boolean hasEqualParts(int[] arr) {
        int sumLeft = 0;
        int sumRight;
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            sumRight = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                check = true;
                break;
            }
        }
        return check;
    }

    /*
    7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя
    пользоваться вспомогательными массивами.
    */
    public static int[] shiftElements(int[] arr, int n) {
        for (int i = 0; i < Math.abs(n); i++) {
            int j;
            int temp;
            if (n > 0) {
                temp = arr[0];
                for (j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            } else {
                temp = arr[arr.length - 1];
                for (j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[j] = temp;
        }
        return arr;
    }
}
