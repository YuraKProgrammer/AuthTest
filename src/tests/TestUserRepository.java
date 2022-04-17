package tests;

import auth.IUserRepository;
import auth.models.UserPasswordRecord;
import auth.models.UserRecord;

public class TestUserRepository implements IUserRepository {
    UserRecord[] userRecords = new UserRecord[]{
            new UserRecord("Иванов",1),
            new UserRecord("Петров",2),
            new UserRecord("Юра",3)
    };
    UserPasswordRecord[] userPasswords = new UserPasswordRecord[]{
            new UserPasswordRecord(1, "Ivanov"),
            new UserPasswordRecord(2, "Petrov"),
            new UserPasswordRecord(3, "Yura")
    };
    @Override
    public UserRecord findByLogin(String login) {
        for (var u: userRecords) {
            if (u.login.equalsIgnoreCase(login)){
                return u;
            }
        }
        return null;
    }

    @Override
    public UserRecord findById(int id) {
        for (var u: userRecords) {
            if (u.id==id){
                return u;
            }
        }
        return null;
    }

    @Override
    public UserPasswordRecord findPasswordById(int id) {
        for (var p: userPasswords){
            if (p.id==id){
                return p;
            }
        }
        return null;
    }
}
