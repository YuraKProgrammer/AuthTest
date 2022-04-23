package tests;

import auth.AuthService;
import auth.HashCalculator;
import auth.IHashCalculator;
import auth.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {
    IHashCalculator hashCalculator = new HashCalculator();
    @Test
    public void loginByPassword_wrongLogin_test(){
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator);
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
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator);
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
        AuthService authService = new AuthService(new UserRepository(hashCalculator),hashCalculator);
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
