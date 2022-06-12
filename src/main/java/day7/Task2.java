package day7;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        Player player1 = new Player(random.nextInt(10) + 90);
        Player player2 = new Player(random.nextInt(10) + 90);
        Player player3 = new Player(random.nextInt(10) + 90);
        Player player4 = new Player(random.nextInt(10) + 90);
        Player player5 = new Player(random.nextInt(10) + 90);
        Player player6 = new Player(random.nextInt(10) + 90);
        Player.info();
        Player player7 = new Player(random.nextInt(10) + 90);
        Player player8 = new Player(random.nextInt(10) + 90);
        System.out.println(Player.getCountPlayers());
        for (int i = 0; i < Player.MAX_STAMINA; i++) {
            player1.run();
            System.out.println(player1.getStamina());
        }
        System.out.println(Player.getCountPlayers());
        Player.info();
    }
}