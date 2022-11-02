package bo;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

    private static ArrayList<BigInteger> array = new ArrayList<BigInteger>();

    public Fibonacci() {
        if (!array.contains(BigInteger.ZERO)) {
            array.add(BigInteger.ZERO);
        }
        if (!array.contains(BigInteger.ONE)) {
            array.add(BigInteger.ONE);
        }
    }

    private BigInteger getFibByIndex(int n) {
        BigInteger fibValue;
        if (array.size() > n) {
            return array.get(n);
        }
        fibValue = getFibByIndex(n - 1).add(getFibByIndex(n - 2));
        array.add(fibValue);
        return fibValue;
    }

    public BigInteger[] getNFiboNum(int num) throws Exception {
        if (num <= 0) {
            throw new Exception("Please Enter Positive Integer");
        }
        BigInteger[] arrayFib = new BigInteger[num];
        for (int i = 0; i < num; i++) {
            arrayFib[i] = getFibByIndex(i);
        }
        return arrayFib;
    }
}
