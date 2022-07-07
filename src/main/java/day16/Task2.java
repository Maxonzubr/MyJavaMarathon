package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        getFiles();
        File file2 = new File("file2.txt");
        printResult(file2);
    }

    public static void getFiles() {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Random random = new Random();
        try {
            PrintWriter printWriter = new PrintWriter(file1);
            for (int i = 0; i < 1000; i++) {
                printWriter.print(random.nextInt(100) + " ");
            }
            printWriter.close();
            Scanner scanner = new Scanner(file1);
            printWriter = new PrintWriter(file2);
            String[] lineNumbers = scanner.nextLine().split(" ");
            scanner.close();
            int sum = 0;
            for (int i = 0; i < lineNumbers.length; i += 20) {
                for (int j = 0; j < 20; j++) {
                    sum += Integer.parseInt(lineNumbers[i + j]);
                }
                printWriter.print((double) sum / 20 + " ");
                sum = 0;
            }
            printWriter.close();
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (SecurityException e) {
            System.out.println("New file.txt cannot be created or denies write access to the file");
        } catch (NoSuchElementException e) {
            System.out.println("Invalid file");
        }
    }

    public static void printResult(File file) {
        double sum = 0;
        try {
            Scanner scanner = new Scanner(file);
            String[] lineNumbers = scanner.nextLine().split(" ");
            for (String number : lineNumbers) {
                sum += Double.parseDouble(number);
            }
            scanner.close();
            System.out.println((int) sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NoSuchElementException e) {
            System.out.println("Invalid file");
        }
    }
}
