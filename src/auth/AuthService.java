package auth;

import auth.IUserRepository;
import auth.models.AuthToken;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class AuthService implements IAuthService {

    IUserRepository userRepository;

    IHashCalculator hashCalculator;

    ITokenFactory tokenFactory;

    ITokenRepository tokenRepository;

    public AuthService(IUserRepository userRepository, IHashCalculator hashCalculator, ITokenFactory tokenFactory, ITokenRepository tokenRepository){
        this.userRepository=userRepository;
        this.hashCalculator=hashCalculator;
        this.tokenFactory=tokenFactory;
        this.tokenRepository=tokenRepository;
    }

    @Override
    public AuthToken loginByPassword(String login, String password) throws SecurityException {
        //поиск пользователя в базе данных
        var userRecord = userRepository.findByLogin(login);
        if (userRecord==null){
            throw new SecurityException("Пользователь неизвестен");
        }

        //для усложнения подбора поролей
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){
        }

        //проверка пароля
        var passwordHash=hashCalculator.calculate(password);
        var pH = userRepository.findPasswordById(userRecord.id).passwordHash;
        if (!Objects.equals(passwordHash, pH)){
            throw new SecurityException("Некорректный пароль");
        }

        //выдача токена
        AuthToken authToken = tokenRepository.getByUserId(userRecord.id);
        if (authToken!=null) {
            if (authToken.getExpiredDate().compareTo(new Date()) < 0) {
                tokenRepository.remove(authToken);
                authToken = null;
            }
        }
        if (authToken==null) {
            authToken = tokenFactory.create();
            authToken.setUserId(userRecord.id);
            tokenRepository.add(authToken);
        }
        return authToken;
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
