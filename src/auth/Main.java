package auth;

import auth.AuthService;
import auth.IAuthService;
import auth.models.AuthToken;

public class Main {
    public static void main (String[] args){
        IAuthService authService = new AuthService(new UserRepository());
        try {
            AuthToken token = authService.loginByPassword("Юра","123");
            System.out.println("Аутентификация прошла успешно");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
