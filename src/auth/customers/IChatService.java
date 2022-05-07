package auth.customers;

import java.util.ArrayList;

public interface IChatService {
    void sendMessage(String token, int recipientUserId, String text);
    ArrayList<Integer> getSendersUsersIds(String token);
    ArrayList<Message> getMessagesByUser(String token, int senderUserId);
}
