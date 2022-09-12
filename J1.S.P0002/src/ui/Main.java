package ui;

import bo.SelectionSort;
import bo.SelectionSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray();
        int[] arrayNeedSort = ArrayUtils.createRandomIntArray(arrayLength);
        SelectionSort sort = new SelectionSort(arrayNeedSort, arrayLength);
        sort.displayResult();
    }
}
