package ui;

import bo.Fibonacci;
import utils.ArrayUtils;
import utils.IntegerUtils;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the length of fibonacci you want:");
        int length = IntegerUtils.inputNumberOfArray();
        Fibonacci obj = new Fibonacci();
        BigInteger[] result = obj.getNFiboNum(length);
        ArrayUtils.printArrayOfBigInteger(result);
    }
}
