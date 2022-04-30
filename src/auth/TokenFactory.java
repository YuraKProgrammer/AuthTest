package auth;

import auth.models.AuthToken;

import java.util.Date;
import java.util.UUID;

public class TokenFactory implements ITokenFactory{
    @Override
    public AuthToken create() {
        AuthToken authToken = new AuthToken();
        UUID uuid=UUID.randomUUID();
        authToken.setToken(uuid.toString());
        Date date = new Date();
        var newTime = date.getTime()+1000*60*30;
        authToken.setExpiredDate(new Date(newTime));
        return authToken;
    }
}
