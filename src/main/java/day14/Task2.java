package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("Day14Task2.txt");
        System.out.println(parseFileToStringList(file));
    }

    public static List<String> parseFileToStringList(File file) {
        List<String> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lookForAge = line.split(" ");
                if (Integer.parseInt(lookForAge[1]) < 0) {
                    throw new NegativeAgeException();
                }
                people.add(line);
            }
            scanner.close();
            return people;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NegativeAgeException | NullPointerException e) {
            System.out.println("Invalid input file");
        }
        return null;
    }

    public static class NegativeAgeException extends Exception {
        public NegativeAgeException() {
            super("Invalid input file");
        }
    }
}
