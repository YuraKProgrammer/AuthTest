package auth;

import auth.models.AuthToken;

public interface ITokenRepository {
    void add(AuthToken authToken);
    AuthToken getByToken(String token);
    AuthToken getByUserId(int userId);
    void remove(AuthToken authToken);
}
