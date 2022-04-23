package auth;
import auth.models.AuthToken;

public class Main {
    public static void main (String[] args){
        IHashCalculator hashCalculator = new HashCalculator();
        System.out.println(hashCalculator.calculate("yura"));
        IAuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator);
        authService.addUser("Юра","Yura");
        try {
            AuthToken token = authService.loginByPassword("Юра","Yura");
            System.out.println("Аутентификация прошла успешно");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
