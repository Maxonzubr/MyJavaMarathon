package day5;

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
    String getColor() { return color; }
    int getYear() { return year; }
}

