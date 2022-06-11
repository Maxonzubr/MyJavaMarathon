package day6;

public class Car {
    private String model;
    private String color;
    private int year;

    void setModel(String model) {
        this.model = model;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setYear(int year) {
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
        System.out.println("It is a car");
    }
    int yearDifference(int inputYear){
        return Math.abs(year-inputYear);
    }
}
