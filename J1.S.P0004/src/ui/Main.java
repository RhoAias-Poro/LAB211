package ui;

import bo.QuickSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray(); // take length of the array from user input
        int[] arrayNeedSort = ArrayUtils.createRandomIntArray(arrayLength); // create random array based on the length
        QuickSort sort = new QuickSort(arrayNeedSort); // InsertionSort obj
        sort.displayResult(); // display the result after sort
    }
}
