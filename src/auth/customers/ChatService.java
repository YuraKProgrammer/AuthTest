package auth.customers;

import auth.IReadonlyAuthService;

import java.util.ArrayList;

public class ChatService implements IChatService{
    private IMessageRepository messageRepository = new MessageRepository();
    private IReadonlyAuthService authService;

    public ChatService(IReadonlyAuthService authService){
        this.authService=authService;
    }

    public void sendMessage(String token, int recipientUserId, String text) {
        int senderUserId = authService.getUserId(token);
        messageRepository.addMessage(senderUserId,recipientUserId,text);
    }

    public ArrayList<Integer> getSendersUsersIds(String token) {
        int recipientUserId = authService.getUserId(token);
        return messageRepository.getSendersUsersIds(recipientUserId);
    }

    public ArrayList<Message> getMessagesByUser(String token, int senderUserId) {
        int recipientUserId = authService.getUserId(token);
        return messageRepository.getByUsersId(senderUserId,recipientUserId);
    }
}
