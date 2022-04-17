package auth;
import auth.models.AuthToken;

public class Main {
    public static void main (String[] args){
        IHashCalculator hashCalculator = new HashCalculator();
        IAuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator);
        try {
            AuthToken token = authService.loginByPassword("Юра","4");
            System.out.println("Аутентификация прошла успешно");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
