package ui;

import bo.Fibonacci;
import utils.ArrayUtils;
import utils.IntegerUtils;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the length of fibonacci you want:");
        int length = IntegerUtils.inputNumberOfArray();
        Fibonacci obj = new Fibonacci(length);
        ArrayList<BigInteger> result = obj.getResult();
        ArrayUtils.printArrayList(result);
    }
}
