package auth.customers;

import java.util.ArrayList;

public interface IMessageRepository {
    ArrayList<Message> getByText(String text);
    ArrayList<Message> getBySenderUserId(int senderUserId);
    ArrayList<Message> getByRecipientUserId(int recipientUserId);
    ArrayList<Message> getMessages();
    ArrayList<Message> getByUsersId(int senderUserId,int recipientUserId);
    void addMessage(int senderUserId,int recipientUserId, String text);
    ArrayList<Integer> getSendersUsersIds(int recipientUserId);
}
