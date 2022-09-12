package ui;

import bo.SelectionSort;
import bo.SelectionSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray(); // take length of the array from user input
        int[] arrayNeedSort = ArrayUtils.createRandomIntArray(arrayLength); //create random array based on the length of the array
        SelectionSort sort = new SelectionSort(arrayNeedSort);// SelectionSort obj
        sort.displayResult();// display the result after sort
    }
}
