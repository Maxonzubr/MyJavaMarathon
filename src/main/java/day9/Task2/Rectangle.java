package day9.Task2;

public class Rectangle extends Figure {
    private double side1, side2;

    public Rectangle(String color, double side1, double side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }
    @Override
    public double area() {
        return side1 * side2;
    }
    @Override
    public double perimeter() {
        return 2 * (side1 + side2);
    }
}