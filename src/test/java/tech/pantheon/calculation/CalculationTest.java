package tech.pantheon.calculation;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class CalculationTest {

    @Test(timeout = 1)
    public void algo1() {
        BigInteger num1 = new BigInteger("11111111111111111111");
        BigInteger num2 = new BigInteger("12345678901234567890");
        BigInteger expectedResult = new BigInteger("137174210013717420998628257899862825790");
        assertEquals("Multiplication must be equal to 137174210013717420998628257899862825790", expectedResult, Calculation.algo1(num1,num2));
    }

    @Test(timeout = 1)
    public void algo2() {
        String num1 = "11111111111111111111";
        String num2 = "12345678901234567890";
        String expectedResult = "137174210013717420998628257899862825790";
        assertEquals("Multiplication must be equal to 137174210013717420998628257899862825790", expectedResult, Calculation.algo2(num1,num2));
    }

    @Test(timeout = 1)
    public void bothEquals() {
        String result1 = Calculation.algo1(new BigInteger("11111111111111111111"),new BigInteger("12345678901234567890")).toString();
        String result2 = Calculation.algo2("11111111111111111111","12345678901234567890");
        assertEquals("Both algo. results must be equal.", result1, result2);
    }
}