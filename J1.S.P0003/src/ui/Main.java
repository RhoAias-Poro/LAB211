package ui;

import bo.InsertionSort;
import bo.InsertionSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray();
        int[] arrayNeedSort = ArrayUtils.createRandomIntArray(arrayLength);
        InsertionSort sort = new InsertionSort(arrayNeedSort, arrayLength);
        sort.displayResult();
    }
}
