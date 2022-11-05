package bo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private static ArrayList<BigInteger> array = new ArrayList<>();

    public Fibonacci() {
        if (!array.contains(BigInteger.ONE)) {
            array.add(BigInteger.ONE);
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

    public List<BigInteger> getNFiboNum(int num) throws Exception {
        if (num <= 0) {
            throw new Exception("Please Enter Positive Integer");
        }
        getFibByIndex(num);
        return array.subList(0, num);
    }
}
