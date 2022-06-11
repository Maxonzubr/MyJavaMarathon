package day6;


public class Task1 {
    public static void main(String[] args) {
        Motorbike bike1 = new Motorbike("Yamaha", "red", 2022);
        bike1.info();
        System.out.printf("Model: %s\nColor: %s\nYear: %d\nYear difference: %d\n\n", bike1.getModel(), bike1.getColor(), bike1.getYear(), bike1.yearDifference(2010));

        Car car1 = new Car();
        car1.setModel("Ford");
        car1.setColor("gray");
        car1.setYear(2015);
        car1.info();
        System.out.printf("Model: %s\nColor: %s\nYear: %d\nYear difference: %d", car1.getModel(), car1.getColor(), car1.getYear(), car1.yearDifference(2022));
    }
}
