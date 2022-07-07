package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("Day14Task1.txt");
        printResult(file);
    }

    public static void printResult(File file) {
        int sum = 0;
        int countNumbers = 0;
        double average;
        try {
            Scanner scanner = new Scanner(file);
            String[] numbers = scanner.nextLine().split(" ");
            for (String number : numbers) {
                sum += Integer.parseInt(number);
                countNumbers++;
            }
            scanner.close();
            average = (double) sum / countNumbers;
            System.out.printf(average + " --> %.3f", average);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NoSuchElementException e) {
            System.out.println("Invalid file");
        } catch (SecurityException e) {
            System.out.println("New file.txt cannot be created or denies write access to the file");
        }
    }
}

