package day13;

import java.util.Date;

public class Message {
    private User sender;
    private User receiver;
    private String text;
    private Date messageDate;

    public Message(User sender, User receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.messageDate = new Date();
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    @Override
    public String toString() {
        return "FROM: " + sender + "\nTO: " + receiver + "\nON: " + messageDate + "\n" + text +"\n";
    }
}
