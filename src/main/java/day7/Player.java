package day7;

import java.sql.SQLOutput;

public class Player {
    private int stamina;
    static final int MAX_STAMINA = 100;
    static final int MIN_STAMINA = 0;
    private static int countPlayers;
    private boolean inTheField = true;
    private static String grammatika2;
    private static String grammatika;

    int getStamina() {
        return stamina;
    }

    static int getCountPlayers() {
        return countPlayers;
    }

    Player(int stamina) {
        this.stamina = stamina;
        countPlayers++;
        if (countPlayers > 6) {
            countPlayers = 6;
            inTheField = false;
        }
    }

    void run() {
        if (stamina > MIN_STAMINA) stamina--;
        else if (stamina == MIN_STAMINA && inTheField == true) {
            countPlayers--;
            inTheField = false;
            System.out.println("Ya ystal, ya poshel domoi");
        }
    }

    static void info() {
        switch (countPlayers) {
            case 5:
                grammatika2 = "o";
                grammatika = "oe";
                break;
            case 4:
            case 3:
            case 2:
                grammatika2 = "a";
                grammatika = "ih";
                break;
            case 1:
                grammatika2 = "";
                grammatika = "ih";
                break;
        }
        if (countPlayers < 6)
            System.out.println("Komandi ne polnie. Na pole eshe est' " + (6 - countPlayers) + " svobodn" + grammatika + " mest" + grammatika2);
        else System.out.println("Na pole net svobodnih mest");
    }
}