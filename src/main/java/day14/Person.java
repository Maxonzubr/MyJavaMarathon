package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Person> parseFileToObjList(File file) {
        List<Person> personList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lookForAgeName = line.split(" ");
                if (Integer.parseInt(lookForAgeName[1]) < 0) {
                    throw new NegativeAgeException();
                }
                personList.add(new Person(lookForAgeName[0], Integer.parseInt(lookForAgeName[1])));
            }
            scanner.close();
            return personList;
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