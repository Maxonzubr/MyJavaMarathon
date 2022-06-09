package day4;

// import java.util.Arrays;    // Для проверки, вывод массива
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int sum, maxSum = 0, idx = 0;
        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(10000);
        for (int i = 1; i < array.length - 1; i++) {
            sum = array[i - 1] + array[i] + array[i + 1];
            if (sum > maxSum) {
                maxSum = sum;
                idx = i - 1;
            }
        }
        System.out.printf("%d\n%d\n", maxSum, idx);
        // System.out.println(Arrays.toString(array));     // Для проверки, вывод массива
    }
}
