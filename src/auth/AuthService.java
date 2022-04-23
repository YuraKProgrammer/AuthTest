package auth;

import auth.IUserRepository;
import auth.models.AuthToken;

import java.util.Objects;

public class AuthService implements IAuthService {

    IUserRepository userRepository;

    IHashCalculator hashCalculator;

    public AuthService(IUserRepository userRepository, IHashCalculator hashCalculator){
        this.userRepository=userRepository;
        this.hashCalculator=hashCalculator;
    }

    @Override
    public AuthToken loginByPassword(String login, String password) throws SecurityException {
        var userRecord = userRepository.findByLogin(login);
        if (userRecord==null){
            throw new SecurityException("Пользователь неизвестен");
        }

        var passwordHash=hashCalculator.calculate(password);
        var pH = userRepository.findPasswordById(userRecord.id).passwordHash;
        if (!Objects.equals(passwordHash, pH)){
            throw new SecurityException("Некорректный пароль");
        }
        return new AuthToken();
    }

    @Override
    public int addUser(String login, String password) throws SecurityException{
        if (userRepository.findByLogin(login)!=null){
            throw new SecurityException("Пользователь с таким логином уже существует");
        }
        int userId = userRepository.add(login).id;
        userRepository.setPassword(userId,hashCalculator.calculate(password));
        return userId;
    }
}
