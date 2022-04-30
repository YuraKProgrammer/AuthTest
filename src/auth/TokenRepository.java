package auth;

import auth.models.AuthToken;

import java.util.ArrayList;

public class TokenRepository implements ITokenRepository{
    ArrayList<AuthToken> authTokens = new ArrayList<>();
    @Override
    public void add(AuthToken authToken) {
        authTokens.add(authToken);
    }

    @Override
    public AuthToken getByToken(String token) {
        for (var aT: authTokens) {
            if (aT.getToken()==token)
                return aT;
        }
        return null;
    }

    @Override
    public AuthToken getByUserId(int userId) {
        for (var aT: authTokens) {
            if (aT.getUserId()==userId)
                return aT;
        }
        return null;
    }

    @Override
    public void remove(AuthToken authToken) {
        authTokens.remove(authToken);
    }
}
