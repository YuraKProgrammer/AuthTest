package auth;

import auth.IUserRepository;
import auth.models.AuthToken;

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
        if (passwordHash!=userRepository.findPasswordById(userRecord.id).passwordHash){
            throw new SecurityException("Некорректный пароль");
        }

        throw new SecurityException("Метод не реализован");
    }
}
