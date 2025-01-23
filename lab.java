import java.util.Arrays;
import java.util.Scanner;

public class lab{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод массива
        System.out.println("Введите количество элементов массива :");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Массив минимум 2 элемента");
            return;
        }

        int[] array = new int[n];
        System.out.println("Введите элементы массива, разделяя их пробелами, а не запятымиии");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Сумма элементов
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Сумма элементов: " + sum);

        // Среднее значение
        double average = (double) sum / n;
        System.out.println("Среднее значение: " + average);

        // Минимальный и максимальный элемент
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);


        // Сортировка массива
        Arrays.sort(array);

        // Второй минимальный и второй максимальный элемент
        System.out.println("Второй минимальный элемент: " + array[1]);
        System.out.println("Второй максимальный элемент: " + array[n - 2]);


    }
}

