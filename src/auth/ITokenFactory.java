package auth;

import auth.models.AuthToken;

public interface ITokenFactory {
    AuthToken create();
}
