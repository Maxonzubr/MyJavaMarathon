package day7;

public class Task1 {
    public static void main(String[] args) {
        Airplane plane1 = new Airplane("Boeing", 2015, 85.6, 140);
        Airplane plane2 = new Airplane("Embraer", 2020, 62.5, 95);
        Airplane.compareAirplanes(plane1, plane2);
    }
}