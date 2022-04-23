package tests;

import auth.HashCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashCalculatorTest {
    @Test
    public void calculate_test(){
        HashCalculator hashCalculator = new HashCalculator();
        var hash1=hashCalculator.calculate("Yura");
        var hash2=hashCalculator.calculate("Ivanov");
        var hash3 = hashCalculator.calculate("Yura");
        Assertions.assertNotEquals(hash1,hash2);
        Assertions.assertEquals(hash1,hash3);
    }
    @Test
    public void calculate_test2(){
        HashCalculator hashCalculator = new HashCalculator();
        var hash1=hashCalculator.calculate("Yura");
        var hash2=hashCalculator.calculate("yura");
        Assertions.assertNotEquals(hash1,hash2);
    }
}
