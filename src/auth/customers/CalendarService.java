package auth.customers;

import auth.IReadonlyAuthService;

public class CalendarService {
    private IReadonlyAuthService authService;

    public CalendarService(IReadonlyAuthService authService){
        this.authService=authService;
    }

    public String[] getEvents(String token){
        int id = authService.getUserId(token);
        switch (id){
            case 1: return new String[]{"а","б","в","г"};
            case 2: return new String[]{"123","456","789"};
        }
        return new String[]{};
    }
}
