package day5;

public class Task1 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setModel("Ford");
        car1.setColor("gray");
        car1.setYear(2015);
        System.out.printf("Model: %s\nColor: %s\nYear: %d", car1.getModel(), car1.getColor(), car1.getYear());
    }
}

class Car {
    private String model;
    private String color;
    private int year;

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
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
