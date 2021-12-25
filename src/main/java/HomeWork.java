import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {

        invertInt();

        createAndFillArray100();

        multiplyBy2ifLessThan6();

        diagonalX(9);

        int[] array;
        array = createArrayWithInitialValues(7, 5);
        System.out.println("\nЗАДАНИЕ №5");
        System.out.println(Arrays.toString(array));

        findMinAndMaxElementArray();

        System.out.println("\nЗАДАНИЕ №7 **");

        array = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        boolean isBalancedArray = checkbalance(array);
        System.out.println("массив " + Arrays.toString(array) + (isBalancedArray ? " сбалансирован" : " несбалансирован"));

        array = new int[]{1, 1, 1, 2, 1};
        isBalancedArray = checkbalance(array);
        System.out.println("массив " + Arrays.toString(array) + (isBalancedArray ? " сбалансирован" : " несбалансирован"));

        array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int shift;
        System.out.println("\nЗАДАНИЕ №8 ***");
        System.out.println("пример 1:");
        shift = 3;
        System.out.println("циклический сдвиг массива на: " + shift);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        cyclicShiftArrayElements(array, shift);
        System.out.println("Итоговый массив: " + Arrays.toString(array));

        System.out.println("\nпример 2:");
        array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shift = -7;
        System.out.println("циклический сдвиг массива на: " + shift);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        cyclicShiftArrayElements(array, shift);
        System.out.println("Итоговый массив: " + Arrays.toString(array));

    }

    /**
     * ЗАДАНИЕ 8 **
     * циклический сдвиг элементов массива
     * i
     *
     * @param arr   обрабатываемый массив
     * @param shift на сколько позиций делать сдвиг (если < 0 сдвиг влево)
     */
    private static void cyclicShiftArrayElements(int[] arr, int shift) {
        int offset = shift % arr.length;
        if (shift < 0) {
            offset = -offset;
            reversePartArray(arr, 0, offset - 1);
            reversePartArray(arr, offset, arr.length - 1);
            reversePartArray(arr, 0, arr.length - 1);
        } else {
            reversePartArray(arr, 0, arr.length - 1 - offset);
            reversePartArray(arr, arr.length - offset, arr.length - 1);
            reversePartArray(arr, 0, arr.length - 1);
        }
    }

    /**
     * Реверс части элементов массива
     * (встпомогательный метод для cyclicShiftArrayElements)
     *
     * @param arr        - обрабатываемый массив
     * @param startIndex начальный индекс массива
     * @param endIndex   конечный индекс массива
     */
    private static void reversePartArray(int[] arr, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i <= j; i++, j--) {
            int a = arr[i];
            arr[i] = arr[j];
            arr[j] = a;
        }
    }

    /**
     * ЗАДАНИЕ 7 **
     *
     * @param arr не пустой одномерный целочисленный массив
     * @return true, если в массиве есть место, в котором сумма левой и правой части массива равны
     */
    private static boolean checkbalance(int[] arr) {
        int leftSum = arr[0];
        int rightSUm = 0;

        for (int i = 1; i < arr.length; i++) {
            rightSUm += arr[i];
        }

        if (leftSum == rightSUm) {
            return true;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            leftSum += arr[i];
            rightSUm -= arr[i];
            if (leftSum == rightSUm) {
                int[] leftArr = Arrays.copyOfRange(arr, 0, i + 1);
                int[] RightArr = Arrays.copyOfRange(arr, i + 1, arr.length);
                System.out.println("точка балансировки: " + (i + 1));
                System.out.println(Arrays.toString(leftArr) + "  |||  " + Arrays.toString(RightArr));
                return true;
            }
        }
        return false;
    }

    /**
     * ЗАДАНИЕ 6 *
     */
    private static void findMinAndMaxElementArray() {
        int[] arr = generateArrayWithRandomValue(10);
        int minValue, maxValue;
        minValue = maxValue = arr[1];

        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        System.out.println("\nЗАДАНИЕ №6 *");
        System.out.println("Заданный массив: " + Arrays.toString(arr));
        System.out.println("min value = " + minValue);
        System.out.println("max value = " + maxValue);
    }

    /**
     * генератор массива случайный чисел
     * (вспомогательный метод для "Задания 6")
     *
     * @param size размерность массива
     * @return массив
     */
    private static int[] generateArrayWithRandomValue(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    /**
     * ЗАДАНИЕ 5
     */
    private static int[] createArrayWithInitialValues(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    /**
     * ЗАДАНИЕ 4
     */
    private static void diagonalX(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i + 1 + j == size) {
                    array[i][j] = 1;
                }
            }
        }
        System.out.println("\nЗАДАНИЕ №4");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * ЗАДАНИЕ 3
     */
    private static void multiplyBy2ifLessThan6() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\nЗАДАНИЕ №3");
        System.out.println("Исходный массив: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println("Итоговый массив: " + Arrays.toString(array));
    }

    /**
     * ЗАДАНИЕ 2
     */
    private static void createAndFillArray100() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println("\nЗАДАНИЕ №2");
        System.out.println("Итоговый массив: " + Arrays.toString(array));
    }

    /**
     * ЗАДАНИЕ 1
     */
    private static void invertInt() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("\nЗАДАНИЕ №1");
        System.out.println("Исходный массив: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        System.out.println("Итоговый массив: " + Arrays.toString(array));
    }

}
