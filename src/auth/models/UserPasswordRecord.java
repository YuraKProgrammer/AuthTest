package auth.models;

public class UserPasswordRecord {
    public int id;
    public String passwordHash;
    public  UserPasswordRecord(int id, String passwordHash){
        this.id=id;
        this.passwordHash=passwordHash;
    }
}
