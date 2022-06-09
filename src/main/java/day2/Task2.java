package day2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Vvedite dva chisla: ");
        int a = scan1.nextInt();
        int b = scan1.nextInt();
        if (a < b) {
            for (int i = a + 1; i < b; i++) {
                if (i % 5 == 0 && i % 10 > 0) {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.print("Oshibka vvoda");
        }
    }
}
