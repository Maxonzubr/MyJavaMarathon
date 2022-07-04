package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("Day14Task1.txt");
        printSumDigits(file);
    }

    public static void printSumDigits(File file) {
        int sum = 0;
        try {
            Scanner scanner = new Scanner(file);
            String[] digitsString = scanner.nextLine().split(" ");
            if (digitsString.length != 10) {
                throw new countDigitsException();
            }
            for (String digit : digitsString) {
                sum += Integer.parseInt(digit);
            }
            scanner.close();
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (countDigitsException |
                 NoSuchElementException e) {       // NoSuchElementException обработка для scanner.nextLine() если null
            System.out.println("Invalid input file");
        }
    }

    static class countDigitsException extends Exception {
        public countDigitsException() {
            super("Invalid input file");
        }
    }
}
