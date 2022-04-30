package auth;

public interface IReadonlyAuthService {
    int getUserId(String token);
}
