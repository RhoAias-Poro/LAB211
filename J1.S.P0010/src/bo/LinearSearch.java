package bo;/*
*  bo.LinearSearch program have two function to perform searching a element in a random array
*  Function inputNumber() take number of the array and each element number from the user
*  Function searchNumber() create a random array base on arguments of inputNumber() pass into,
*   display it and display the index of search number in array
* */

import java.util.Random;
import java.util.Scanner;
import utils.ArrayUtils;
import ui.Display;
public class LinearSearch {
    private Integer[] arr;
    private int length;
    private int searchValue;
    public LinearSearch(Integer[] originalArray, int length, int searchValue)
    {
        arr = originalArray;
        this.length = length;
        this.searchValue = searchValue;
    }
    private int sort() {
        ArrayUtils array = new ArrayUtils();
        Integer[] clone = array.cloneArray(arr);
        int result = 0; // store the index that searchValue equal to
        for (int i = 0; i < length; i++) // create a for loop from 0 to length -1 to perform liner search
        {
            if (searchValue == clone[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    public void displayResult()
    {
        int searchNumber = searchValue;
        Display.displayInteger(sort(), searchNumber);
    }
}
