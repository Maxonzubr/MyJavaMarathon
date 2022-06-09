package day4;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int sum = 0, maxSum = 0, maxSumIdx = 0;
        int[][] array = new int[12][8];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(50);
                sum += array[i][j];
                //  System.out.print (array[i][j] + " ");     // Для проверки, вывод матрицы
            }
            // System.out.println("   Sum of all elements in line: " + sum + "    line index: " + i); // Для проверки, вывод суммы и индекса строки
            if (sum >= maxSum) {
                maxSum = sum;
                maxSumIdx = i;
            }
            sum = 0;
        }
        System.out.printf("Line with index %d has max sum - %d", maxSumIdx, maxSum);
    }
}
