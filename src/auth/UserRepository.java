package auth;

import auth.models.UserPasswordRecord;
import auth.models.UserRecord;

import java.util.ArrayList;

public class UserRepository implements IUserRepository {
    ArrayList<UserRecord> userRecords = new ArrayList<>();
           // new UserRecord("Иванов",1),
           // new UserRecord("Петров",2),
           // new UserRecord("Юра",3)
    ArrayList<UserPasswordRecord> userPasswords = new ArrayList<>();

    public UserRepository(IHashCalculator hashCalculator){
   //     userPasswords = new UserPasswordRecord[]{
   //             new UserPasswordRecord(1, hashCalculator.calculate("Ivanov")),
   //             new UserPasswordRecord(2, hashCalculator.calculate("Petrov")),
    //            new UserPasswordRecord(3, hashCalculator.calculate("Yura"))
   //     };
    }

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
            if (p.userId ==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public UserRecord add(String login) {
        UserRecord userRecord = new UserRecord(login,userRecords.size()+1);
        userRecords.add(userRecord);
        return userRecord;
    }

    @Override
    public void setPassword(int userId, String passwordHash) {
        UserPasswordRecord userPassword = null;
        for(var i:userPasswords){
            if (i.userId ==userId){
                userPassword=i;
                break;
            }
        }
        if (userPassword==null){
            userPassword=new UserPasswordRecord(userId,passwordHash);
            userPasswords.add(userPassword);
        }
        userPassword.passwordHash=passwordHash;
    }
}
