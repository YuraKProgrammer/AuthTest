package auth;

import auth.models.AuthToken;

public interface IAuthService {
    AuthToken loginByPassword(String login, String password) throws SecurityException;
}