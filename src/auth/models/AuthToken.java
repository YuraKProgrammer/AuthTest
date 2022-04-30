package auth.models;

import java.util.Date;

public class AuthToken {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    private String token;

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    private Date expiredDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;
}
