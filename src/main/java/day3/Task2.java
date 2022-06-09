package day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        double a, div, b;
        while (true) {
            a = scan1.nextDouble();
            b = scan1.nextDouble();
            if (b == 0) break;
            div = a / b;
            System.out.println(div);
        }

    }
}
