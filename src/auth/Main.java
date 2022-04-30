package auth;
import auth.customers.CalendarService;
import auth.models.AuthToken;

public class Main {
    public static void main (String[] args){
        IHashCalculator hashCalculator = new HashCalculator();
        System.out.println(hashCalculator.calculate("yura"));
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator, new TokenFactory(), new TokenRepository());
        authService.addUser("Юра","adm1");
        authService.addUser("ПетяВасяМаша","adm2");
        CalendarService calendarService = new CalendarService(authService);

        AuthToken token = authService.loginByPassword("ПетяВасяМаша","adm2");
        String[] events = calendarService.getEvents(token.getToken());
        System.out.println(events[0]);
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
