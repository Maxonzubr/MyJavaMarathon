package day7;

public class Airplane {
    private String manufacturer;
    private int year;
    private double length;
    private double weight;
    private int fuel;

    static void compareAirplanes(Airplane a, Airplane b) {

        if (a.length > b.length) {
            System.out.println("First airplane " + a.manufacturer + " is longer");
        } else {
            System.out.println("Second airplane " + b.manufacturer + " is longer");
        }
    }

    void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    void setYear(int year) {
        this.year = year;
    }

    void setLength(double length) {
        this.length = length;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }

    void setFuel(int fuel) {
        this.fuel = fuel;
    }

    int getFuel() {
        return fuel;
    }

    Airplane(String manufacturer, int year, double length, double weight) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.length = length;
        this.weight = weight;
    }

    void info() {
        System.out.println("Manufacturer: " + manufacturer + ", year made: " + year + ", length: " + length + ", weight: " + weight + ", fuel content: " + fuel);
    }

    void fillUp(int n) {
        fuel += n;
    }
}
