package auth;

import auth.models.UserPasswordRecord;
import auth.models.UserRecord;

public interface IUserRepository {
    UserRecord findByLogin(String login);
    UserRecord findById(int id);
    UserPasswordRecord findPasswordById(int id);
}
