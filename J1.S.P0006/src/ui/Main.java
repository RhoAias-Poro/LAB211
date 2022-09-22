package ui;

import bo.BinarySearch;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        int arrayLength = IntegerUtils.inputNumberOfArray();
        System.out.println("Enter search value:");
        int searchValue = IntegerUtils.inputSearchNumber();
        int[] array = ArrayUtils.createRandomIntArray(arrayLength);
        ArrayUtils.sortAsc(array);
        ArrayUtils.printIntArray(array, arrayLength);
        BinarySearch obj = new BinarySearch(array);
        int result = obj.getSearchNumber(searchValue);
        if(result == -1) System.out.println("Not Found");
        else System.out.println("Found " + searchValue + "at index: " + result);
    }
}
