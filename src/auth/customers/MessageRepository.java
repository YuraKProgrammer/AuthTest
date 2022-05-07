package auth.customers;

import java.util.ArrayList;

public class MessageRepository implements IMessageRepository{
    private ArrayList<Message> messages = new ArrayList<>();
    public ArrayList<Message> getByText(String text){
        ArrayList<Message> mes = new ArrayList<>();
        for (var m:messages) {
            if (m.getText()==text)
                mes.add(m);
        }
        return mes;
    }
    public ArrayList<Message> getBySenderUserId(int senderUserId){
        ArrayList<Message> mes = new ArrayList<>();
        for (var m:messages) {
            if (m.getSenderUserId()==senderUserId)
                mes.add(m);
        }
        return mes;
    }
    public ArrayList<Message> getByRecipientUserId(int recipientUserId){
        ArrayList<Message> mes = new ArrayList<>();
        for (var m:messages) {
            if (m.getRecipientUserId()==recipientUserId)
                mes.add(m);
        }
        return mes;
    }
    public ArrayList<Message> getByUsersId(int senderUserId,int recipientUserId){
        ArrayList<Message> mes = new ArrayList<>();
        for (var m:messages) {
            if (m.getRecipientUserId()==recipientUserId && m.getSenderUserId()==senderUserId)
                mes.add(m);
        }
        return mes;
    }
    public ArrayList<Message> getMessages(){
        return messages;
    }
    public void addMessage(int senderUserId,int recipientUserId, String text){
        messages.add(new Message(senderUserId, recipientUserId, text));
    }

    public ArrayList<Integer> getSendersUsersIds(int recipientUserId) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (var m:messages) {
            if (m.getRecipientUserId()==recipientUserId && !ids.contains(m.getSenderUserId()))
                ids.add(m.getSenderUserId());
        }
        return ids;
    }
}
