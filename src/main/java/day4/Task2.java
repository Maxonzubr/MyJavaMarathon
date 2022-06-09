package day4;

// import java.util.Arrays;     // Для вывода массива и проверки работоспособности
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int maxElement = 0, minElement = 10000, zeroEndElements = 0, sumZeroEndElements = 0;
        Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(10000);
        for (int element : array) {
            if (element > maxElement) maxElement = element;
            if (element < minElement) minElement = element;
            if (element % 10 == 0) {
                zeroEndElements += 1;
                sumZeroEndElements += element;
            }
        }
        System.out.printf("Max array element: %d\nMin array element: %d\nCount of array elements that ends in zero: %d\nSum of array elements that ends in zero: %d\n\n", maxElement, minElement, zeroEndElements, sumZeroEndElements);
        // System.out.print(Arrays.toString(array));    // Для вывода массива и проверки работоспособности
    }
}
