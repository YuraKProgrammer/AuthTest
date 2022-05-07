package auth.customers;

public class Message {
    public String getText() {
        return text;
    }

    public int getSenderUserId() {
        return senderUserId;
    }

    public int getRecipientUserId() {
        return recipientUserId;
    }

    private String text;
    private int senderUserId;
    private int recipientUserId;
    public Message(int senderUserId, int recipientUserId, String text){
        this.senderUserId=senderUserId;
        this.recipientUserId=recipientUserId;
        this.text=text;
    }
}
