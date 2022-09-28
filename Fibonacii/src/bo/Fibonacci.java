package bo;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

    private static ArrayList<BigInteger> array = new ArrayList<BigInteger>();

    private int length;

    public Fibonacci(int length)
    {
        this.length = length;
        array.add(BigInteger.ZERO);
        array.add(BigInteger.ONE);
    }

    private BigInteger fibo(int n)
    {
        BigInteger fibValue;
        if(n == 0) return BigInteger.ZERO;
        else if(n == 1) return BigInteger.ONE;
        else if(array.size() > n) return array.get(n);
        else{
           fibValue = fibo(n - 1).add(fibo(n - 2));
           array.add(fibValue);
           return fibValue;
        }
    }

    public ArrayList<BigInteger> getResult()
    {
        fibo(length - 1);
        return array;
    }
}
