package ui;

import bo.MergeSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray(); // take length of the array from user input
        int[] arrayNeedSort = ArrayUtils.createRandomIntArray(arrayLength); // create random array based on the length
        MergeSort sort = new MergeSort(arrayNeedSort); // InsertionSort obj
        sort.displayResult(); // display the result after sort
    }
}
