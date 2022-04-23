package auth.models;

public class UserPasswordRecord {
    public int userId;
    public String passwordHash;
    public  UserPasswordRecord(int userId, String passwordHash){
        this.userId =userId;
        this.passwordHash=passwordHash;
    }
}
