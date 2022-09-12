package ui;

import bo.BubbleSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray(); // get length of the array from user input
        int[] arrayNeedSort = ArrayUtils.createRandomIntArray(arrayLength); // create random that have limit in the length
        BubbleSort sort = new BubbleSort(arrayNeedSort); //BubbleSort obj
        sort.displayResult(); // display the result
    }
}
