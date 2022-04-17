package auth.models;

public class UserPasswordRecord {
    public int id;
    public String password;
    public  UserPasswordRecord(int id, String password){
        this.id=id;
        this.password=password;
    }
}
