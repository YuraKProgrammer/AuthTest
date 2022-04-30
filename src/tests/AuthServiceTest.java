package tests;

import auth.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {
    IHashCalculator hashCalculator = new HashCalculator();
    ITokenFactory tokenFactory = new TokenFactory();
    ITokenRepository tokenRepository = new TokenRepository();
    @Test
    public void loginByPassword_wrongLogin_test(){
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator,tokenFactory,tokenRepository);
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
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator,tokenFactory,tokenRepository);
        authService.addUser("Юра","Yura");
        try {
            authService.loginByPassword("Юра", "Ivanov");
            Assertions.fail();
        }
        catch (SecurityException e){
            Assertions.assertEquals(e.getMessage(),"Некорректный пароль");
        }
    }
    @Test
    public void addUser_test(){
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator,tokenFactory,tokenRepository);
        int userId = authService.addUser("Yura","yurayura");
        int user2Id = authService.addUser("Yura2","yura2yura2");
        Assertions.assertNotEquals(userId,user2Id);
        try {
            authService.addUser("Yura","ura");
            Assertions.fail();
        }
        catch (Exception e){
            Assertions.assertEquals(e.getMessage(),"Пользователь с таким логином уже существует");
        }
    }
}
