package auth;

import auth.models.AuthToken;

public interface IAuthService {
    AuthToken loginByPassword(String login, String password) throws SecurityException;

    /**
     *
     * @param login
     * @param password
     * @return id нового пользователя
     */
    int addUser(String login, String password) throws SecurityException;
    void logout(String token);
    int getUserId(String token);
}
