package day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> carManufacturer = new ArrayList<>(Arrays.asList("BMW", "Audi", "Toyota", "Ford", "Mazda"));
        System.out.println(carManufacturer);
        carManufacturer.add(2, "LADA");
        carManufacturer.remove(0);
        System.out.println(carManufacturer);
    }
}
