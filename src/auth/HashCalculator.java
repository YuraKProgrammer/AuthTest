package auth;

public class HashCalculator implements IHashCalculator{
    @Override
    public String calculate(String s) {
        return String.valueOf(s.length());
    }
}
