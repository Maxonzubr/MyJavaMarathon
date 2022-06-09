package day2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Vvedi kol-vo etajei: ");
        int etaj = scan1.nextInt();
        if (etaj >= 1 && etaj <= 4) {
            System.out.print("Maloetajnii dom");
        } else if (etaj > 4 && etaj <= 8) {
            System.out.print("Sredneetajnii dom");
        } else if (etaj > 8) {
            System.out.print("Mnogoetajnii dom");
        } else if (etaj < 1) {
            System.out.print("Oshibka vvoda");
        }
    }
}
