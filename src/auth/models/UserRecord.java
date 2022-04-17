package auth.models;

public class UserRecord {
    public String login;
    public int id;
    public UserRecord(String login, int id){
        this.login=login;
        this.id=id;
    }
}
