package tests;

import auth.AuthService;
import auth.HashCalculator;
import auth.IHashCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {
    IHashCalculator hashCalculator = new HashCalculator();
    @Test
    public void loginByPassword_wrongLogin_test(){
        AuthService authService = new AuthService(new TestUserRepository(hashCalculator),hashCalculator);
        try {
            authService.loginByPassword("fsffd", "123");
            Assertions.fail();
        }
        catch (SecurityException e){
            Assertions.assertEquals(e.getMessage(),"Пользователь неизвестен");
        }
    }
    @Test
    public void loginByPassword_wrongPassword_test(){
        AuthService authService = new AuthService(new TestUserRepository(hashCalculator),hashCalculator);
        try {
            authService.loginByPassword("Юра", "Ivanov");
            Assertions.fail();
        }
        catch (SecurityException e){
            Assertions.assertEquals(e.getMessage(),"Некорректный пароль");
        }
    }
}
