package day13;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("Max");
        User user2 = new User("Pasha");
        User user3 = new User("Vasya");

        user1.sendMessage(user2,"Hello!");
        user1.sendMessage(user2,"How are you going");
        user2.sendMessage(user1,"Hi!");
        user2.sendMessage(user1,"Not bad");
        user2.sendMessage(user1,"Are you?");
        user3.sendMessage(user1,"Hey Max are you in Tumen now?");
        user3.sendMessage(user1,"We should meet and discuss ours project");
        user3.sendMessage(user1,"I have something new about a transport");
        user1.sendMessage(user3,"I'll be at 10");
        user1.sendMessage(user3,"On the way");
        user1.sendMessage(user3,"I'll call back");
        user3.sendMessage(user1,"Ok");

        MessageDatabase.showDialog(user1,user3);
    }
}
