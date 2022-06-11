package day6;

public class Motorbike {
    private String model;
    private String color;
    private int year;

    Motorbike(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    String getModel() {
        return model;
    }

    String getColor() {
        return color;
    }

    int getYear() {
        return year;
    }

    void info() {
        System.out.println("It is a motorbike");
    }

    int yearDifference(int inputYear) {
        return Math.abs(year - inputYear);
    }
}

