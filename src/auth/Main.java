package auth;
import auth.customers.CalendarService;
import auth.customers.ChatService;
import auth.customers.Message;
import auth.models.AuthToken;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        IHashCalculator hashCalculator = new HashCalculator();
        System.out.println(hashCalculator.calculate("yura"));
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator, new TokenFactory(), new TokenRepository());
        authService.addUser("Юра","adm1");
        authService.addUser("ПетяВасяМаша","adm2");
        ChatService chatService = new ChatService(authService);

        AuthToken token = authService.loginByPassword("ПетяВасяМаша","adm2");
        chatService.sendMessage(token.getToken(),1, "Привет");
        chatService.sendMessage(token.getToken(),1, "Пока");
        chatService.sendMessage(token.getToken(),1, "123");
        AuthToken token2 = authService.loginByPassword("Юра","adm1");
        ArrayList<Message> messages = chatService.getMessagesByUser(token2.getToken(),2);
        for (var m: messages) {
            System.out.println(m.getText());
        }
        System.out.println(chatService.getSendersUsersIds(token2.getToken()));

       // try {
       //     var password = Main.m1(authService,"Юра");
       //     if (password!=null) {
       //         AuthToken token = authService.loginByPassword("Юра", password);
       //         System.out.println("Аутентификация прошла успешно");
       //     }
       // }
       // catch (Exception e){
       //     System.out.println(e.getMessage());
       // }
    }
    private static String m1(IAuthService authService, String login){
        PasswordIterator passwordIterator = new PasswordIterator();
        var password = passwordIterator.getNext();
        while (password!=null){
            try {
                System.out.println(password);
                authService.loginByPassword("Юра", password);
                System.out.println("Пароль найден: "+password);
                return password;
            }
            catch (SecurityException e){
                password=passwordIterator.getNext();
            }
        }
        return null;
    }
}
