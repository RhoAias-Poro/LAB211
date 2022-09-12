package ui;

import bo.BubbleSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray();
        int[] arrayNeedSort = ArrayUtils.createRandomIntArray(arrayLength);
        BubbleSort sort = new BubbleSort(arrayNeedSort, arrayLength);
        sort.displayResult();
    }
}
