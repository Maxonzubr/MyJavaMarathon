package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Neil Alishev
 */
public class Task2 {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "D:" + separator + "Java" + separator + "JavaMarathon2021" + separator + "JavaMarathon2021" +
                separator + "src" + separator + "main" + separator + "resources" + separator + "taxi_cars.txt";
        File file = new File(path);
        findTaxi(file);

    }


    public static void findTaxi(File file) {
        Map<Integer, Point> taxiMap = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {                            // Читаем из файла taxi_cars.txt
            while (scanner.hasNextLine()) {
                taxiMap.put(scanner.nextInt(), new Point(scanner.nextInt(), scanner.nextInt()));
            }
        } catch (FileNotFoundException e) {                                    // Здесь ловим ошибки файла
            System.out.println("File taxi_cars.txt not found");
            return;
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Invalid input taxi_cars.txt file");
            return;
        }

        int x1, x2, y1, y2;                                         // Получаем координаты от пользователя
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter first point coordinate x1 y1");
            int rawx1 = scanner.nextInt();
            int rawy1 = scanner.nextInt();
            System.out.println("Enter second point coordinate x2 y2");
            int rawx2 = scanner.nextInt();
            int rawy2 = scanner.nextInt();
            if (rawx1 == rawx2 || rawy1 == rawy2) {     // Проверка введенных координат на возможность построения квадрата
                throw new IllegalArgumentException();
            }
            if (rawx1 > rawx2) {    //  Для удобства работы
                x1 = rawx2;
                x2 = rawx1;
            } else {
                x1 = rawx1;
                x2 = rawx2;
            }
            if (rawy1 > rawy2) {
                y1 = rawy2;
                y2 = rawy1;
            } else {
                y1 = rawy1;
                y2 = rawy2;
            }
        } catch (InputMismatchException | IllegalArgumentException e) { // Здесь ловим ошибки координат
            System.out.println("Invalid coordinates");
            return;
        }

        Set<Point> possibleTaxiPositionsInSquare = new HashSet<>(); // HashSet всех возможных позиций такси в заданном квадрате
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                possibleTaxiPositionsInSquare.add(new Point(i, j));
            }
        }
        Set<Point> taxiPositions = new HashSet<>(taxiMap.values()); // HashSet всех позиций такси
        taxiPositions.retainAll(possibleTaxiPositionsInSquare);     // HashSet позиций такси в заданном квадрате
        int taxiCountInSquare = 0;
        for (Point taxi : taxiPositions) {                          // Поиск и вывод id такси в заданном квадрате
            for (Map.Entry<Integer, Point> entry : taxiMap.entrySet()) {
                if (taxi.equals(entry.getValue())) {
                    System.out.print(entry.getKey() + " ");
                    taxiCountInSquare++;
                }
            }
        }
        System.out.println("\nTotal number of cars in square ("+ x1 + "," + y1 + ");(" + x2 + "," + y2 + "): " + taxiCountInSquare);
    }
}



