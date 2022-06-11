package day5;


public class Task2 {
    public static void main(String[] args) {
        Motorbike bike1 = new Motorbike("Honda", "white", 2022);
        System.out.printf("Model: %s\nColor: %s\nYear:  %d", bike1.getModel(), bike1.getColor(), bike1.getYear());
    }
}