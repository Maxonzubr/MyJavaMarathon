package day3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        double a, b, div;
        for (int i = 0; i < 5; i++) {
            a = scan1.nextDouble();
            b = scan1.nextDouble();
            if (b == 0) {
                System.out.println("Delenie na 0");
                continue;
            }
            div = a / b;
            System.out.println(div);
        }
    }
}
