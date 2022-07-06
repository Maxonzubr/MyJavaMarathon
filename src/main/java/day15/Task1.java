package day15;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "D:" + separator + "Java" + separator + "JavaMarathon2021" + separator + "JavaMarathon2021" + separator + "src" + separator + "main" + separator + "resources" + separator;
        File fileCSV = new File(path + "shoes.csv");
        missingShoes(fileCSV);
    }

    public static File missingShoes(File fileCSV) {
        File fileTXT = new File(fileCSV.getParentFile() + File.separator + "missing_shoes.txt");
        String[] line;
        try {
            PrintWriter printWriter = new PrintWriter(fileTXT);
            Scanner scanner = new Scanner(fileCSV);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().split(";");
                if (line.length != 3) {
                    throw new InvalidInputFileException("Invalid number of columns in csv file");
                }
                if (line[2].equals("0")) {
                    printWriter.println(line[0] + ", " + line[1] + ", " + line[2]);
                }
            }
            printWriter.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File.csv not found");
        } catch (InvalidInputFileException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("New file.txt cannot be created or denies write access to the file");
        }
        return fileTXT;
    }

    static class InvalidInputFileException extends Exception {
        public InvalidInputFileException(String description) {
            super(description);
        }
    }
}