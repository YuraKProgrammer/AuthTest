package auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class HashCalculator implements IHashCalculator{
    HashMap<Character, Integer> map = new HashMap<>();
    public HashCalculator(){
        map.put('a',1);
        map.put('b',2);
        map.put('c',3);
        map.put('d',4);
        map.put('e',5);
        map.put('f',6);
        map.put('g',7);
        map.put('h',8);
        map.put('i',9);
        map.put('j',10);
        map.put('k',11);
        map.put('l',12);
        map.put('m',13);
        map.put('n',14);
        map.put('o',15);
        map.put('p',16);
        map.put('q',17);
        map.put('r',18);
        map.put('s',19);
        map.put('t',20);
        map.put('u',21);
        map.put('v',22);
        map.put('w',23);
        map.put('x',24);
        map.put('y',25);
        map.put('z',26);
        map.put('0',27);
        map.put('1',28);
        map.put('2',29);
        map.put('3',30);
        map.put('4',31);
        map.put('5',32);
        map.put('6',33);
        map.put('7',34);
        map.put('8',35);
        map.put('9',36);
        map.put('а',37);
        map.put('б',38);
        map.put('в',39);
        map.put('г',40);
        map.put('д',41);
        map.put('е',42);
        map.put('ё',43);
        map.put('ж',44);
        map.put('з',45);
        map.put('и',46);
        map.put('й',47);
        map.put('к',48);
        map.put('л',49);
        map.put('м',50);
        map.put('н',51);
        map.put('о',52);
        map.put('п',53);
        map.put('р',54);
        map.put('с',55);
        map.put('т',56);
        map.put('у',57);
        map.put('ф',58);
        map.put('х',59);
        map.put('ц',60);
        map.put('ч',61);
        map.put('ш',62);
        map.put('щ',63);
        map.put('ъ',64);
        map.put('ы',65);
        map.put('ь',66);
        map.put('э',67);
        map.put('ю',68);
        map.put('я',69);
        map.put('+',70);
        map.put('-',71);
        map.put('=',72);
        map.put('_',73);
        map.put('*',74);
        map.put('&',75);
        map.put('#',76);
        map.put('№',77);
        map.put('%',78);
        map.put(':',79);
        map.put('^',80);
        map.put('?',81);
        map.put('!',82);
        map.put('~',83);
        map.put('"',84);
        map.put('>',85);
        map.put('<',86);
    }
    @Override
    public String calculate(String s) {
        var chars = s.toCharArray();
        var s1=""+s.length();
        for (var c: chars) {
            var charCode = charToInt(c);
            s1=s1+charCode;
        }
        return s1;
    }

    private static int charToInt(char c){
        return  c-'0';
    }
}
