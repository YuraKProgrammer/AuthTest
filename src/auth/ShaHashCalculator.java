package auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaHashCalculator implements IHashCalculator{
    @Override
    public String calculate(String s) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(s.getBytes());
            return new String(messageDigest.digest());
        }
        catch (NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
