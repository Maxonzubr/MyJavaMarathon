package day5;


public class Task2 {
    public static void main(String[] args) {
        Motorbike bike1 = new Motorbike("Honda", "white", 2022);
        System.out.printf("Model: %s\nColor: %s\nYear: %d", bike1.getModel(), bike1.getColor(), bike1.getYear());
    }
}

class Motorbike {
    private String model;
    private String color;
    private int year;

    public Motorbike(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }
}