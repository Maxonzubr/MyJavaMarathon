package day4;

import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int moreThanEight = 0, equalsOne = 0, evenNum = 0, oddNum = 0, sumAllElements = 0;
        System.out.print("Input array length: ");
        int arrayLength = scan.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(11);
        }
        for (int element : array) {
            System.out.print(element + " ");            // По условию вывод в консоль циклом for each
            if (element > 8) moreThanEight += 1;
            if (element == 1) equalsOne += 1;
            if (element % 2 == 0) evenNum += 1;
            if (element % 2 != 0) oddNum += 1;
            sumAllElements += element;
        }
        System.out.printf("\nArray length: %d\nCount of numbers that more than eight: %d\nCount of numbers that equals one: %d\nCount of even numbers: %d\nCount of odd numbers: %d\nSum of all array elements: %d", arrayLength, moreThanEight, equalsOne, evenNum, oddNum, sumAllElements);
    }
}
