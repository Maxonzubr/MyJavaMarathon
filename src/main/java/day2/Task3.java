package day2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Vvedite chisla a i b: ");
        int a = scan1.nextInt();
        int b = scan1.nextInt();
        int i = a + 1;
        if (a < b) {
            while (i < b) {
                if (i % 5 == 0 && i % 10 != 0) {
                    System.out.print(i + " ");
                }
                i++;
            }
        } else {
            System.out.print("Oshibka vvoda");
        }
    }
}
