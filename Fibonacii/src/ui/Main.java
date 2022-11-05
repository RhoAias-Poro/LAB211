package ui;

import bo.Fibonacci;
import utils.ArrayUtils;
import utils.Validations;

import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int length = Validations.getInt("Please enter the length of fibonacci you want: ", "Please enter number only", "Please enter a number start from 1", 1, Integer.MAX_VALUE);
        Fibonacci obj = new Fibonacci();
        try {
            List<BigInteger> result = obj.getNFiboNum(length);
            ArrayUtils.printArrayOfBigInteger(result);
        } catch (Exception e) {
            Validations.throwError(e.getMessage());
        }
//        Fibonacci obj1 = new Fibonacci();
//        BigInteger[] result1 = obj1.getNFiboNum(length);
//        ArrayUtils.printArrayOfBigInteger(result1);
    }
}
