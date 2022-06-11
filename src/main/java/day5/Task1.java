package day5;

public class Task1 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setModel("Ford");
        car1.setColor("gray");
        car1.setYear(2015);
        System.out.printf("Model: %s\nColor: %s\nYear:  %d", car1.getModel(), car1.getColor(), car1.getYear());
    }
}