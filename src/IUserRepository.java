import models.UserRecord;

public interface IUserRepository {
    UserRecord findByLogin(String login);
    UserRecord findById(int id);
}
