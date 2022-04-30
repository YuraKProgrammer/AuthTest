package auth;

public class PasswordIterator {
    public static final int NumberOfSymbols = 75;
    int passwordLength = 1;
    char[] cc = new char[]{'0','0','0','0','0','0','0','0','0','0'};
    public String getNext(){
        cc[0]++;
        if (cc[0]-'0'== NumberOfSymbols) {
            if (passwordLength>1)
                cc[1]++;
            if (passwordLength==1)
                passwordLength++;
            cc[0]='0';
            if (cc[1]-'0'== NumberOfSymbols) {
                if (passwordLength>2)
                    cc[2]++;
                if (passwordLength==2)
                    passwordLength++;
                cc[1]='0';
                if (cc[2]-'0'== NumberOfSymbols) {
                    if (passwordLength>3)
                        cc[3]++;
                    if (passwordLength==3)
                        passwordLength++;
                    cc[2]='0';
                    if (cc[3]-'0'== NumberOfSymbols) {
                        if (passwordLength>4)
                            cc[4]++;
                        if (passwordLength==4)
                            passwordLength++;
                        cc[3]='0';
                        if (cc[4]-'0'== NumberOfSymbols) {
                            if (passwordLength>5)
                                cc[5]++;
                            if (passwordLength==5)
                                passwordLength++;
                            cc[4]='0';
                            if (cc[5]-'0'== NumberOfSymbols) {
                                if (passwordLength>6)
                                    cc[6]++;
                                if (passwordLength==6)
                                    passwordLength++;
                                cc[5]='0';
                                if (cc[6]-'0'== NumberOfSymbols) {
                                    if (passwordLength>7)
                                        cc[7]++;
                                    if (passwordLength==7)
                                        passwordLength++;
                                    cc[6]='0';
                                    if (cc[7]-'0'== NumberOfSymbols) {
                                        if (passwordLength>8)
                                            cc[8]++;
                                        if (passwordLength==8)
                                            passwordLength++;
                                        cc[7]='0';
                                        if (cc[8]-'0'== NumberOfSymbols) {
                                            if (passwordLength>9)
                                                cc[9]++;
                                            if (passwordLength==9)
                                                passwordLength++;
                                            cc[8]='0';
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        switch (passwordLength){
            case 1: return ""+cc[0];
            case 2: return ""+cc[0]+cc[1];
            case 3: return ""+cc[0]+cc[1]+cc[2];
            case 4: return ""+cc[0]+cc[1]+cc[2]+cc[3];
            case 5: return ""+cc[0]+cc[1]+cc[2]+cc[3]+cc[4];
            case 6: return ""+cc[0]+cc[1]+cc[2]+cc[3]+cc[4]+cc[5];
            case 7: return ""+cc[0]+cc[1]+cc[2]+cc[3]+cc[4]+cc[5]+cc[6];
            case 8: return ""+cc[0]+cc[1]+cc[2]+cc[3]+cc[4]+cc[5]+cc[6]+cc[7];
            case 9: return ""+cc[0]+cc[1]+cc[2]+cc[3]+cc[4]+cc[5]+cc[6]+cc[7]+cc[8];
            case 10: return ""+cc[0]+cc[1]+cc[2]+cc[3]+cc[4]+cc[5]+cc[6]+cc[7]+cc[8]+cc[9];
            default: return null;
        }
    }
}
