package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane plane1 = new Airplane("Airbus", 2018, 150.6, 160.7);
        plane1.setYear(2017);
        plane1.setLength(161.2);
        plane1.fillUp(1200);
        plane1.fillUp(500);
        plane1.info();
    }
}
