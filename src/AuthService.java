import models.AuthToken;

public class AuthService implements  IAuthService{

    IUserRepository userRepository;

    public AuthService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public AuthToken loginByPassword(String login, String password) throws SecurityException {
        var userRecord = userRepository.findByLogin(login);
        if (userRecord==null){
            throw new SecurityException("Пользователь неизвестен");
        }
        throw new SecurityException("Метод не реализован");
    }
}
