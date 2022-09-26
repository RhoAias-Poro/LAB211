package bo;

public class Fibonacci {
    private static long array[];

    public Fibonacci(int length) {
        array = new long[length];
    }

    private long fibonacci(long n) {
        long fibValue = 0;
        if (n == 0)
        {
            array[0] = 0;
            return 0;
        }
        else if (n == 1)
        {
            array[1] = 1;
            return 1;
        }
        else if (array[(int) n] != 0) return array[(int) n];
        else {
            fibValue = fibonacci(n - 1) + fibonacci(n - 2);
            array[(int) n] = fibValue;
            return fibValue;
        }
    }

    public long[] getFibo() {
        fibonacci(array.length - 1);
        return array;
    }
}
