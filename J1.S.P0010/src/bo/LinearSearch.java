/*
 *  Linear Search class have 2 function is search() and displayResult()
 *  search() function is to search the index in the array
 *  displayResult() passing two argument to the ui.Display to print
 * */

package bo;

import utils.IntegerUtils;

public class LinearSearch {
    private Integer[] arr;
    private int arrayLength;
    private int searchValue;

    public LinearSearch(Integer[] originalArray, int arrayLength, int searchValue) // Contructor
    {
        arr = originalArray;
        this.arrayLength = arrayLength;
        this.searchValue = searchValue;
    }

    private int search() { // use linear search to found
        int result = 0; // store the index that searchValue equal to
        boolean numberFound = false; // check to see if the number have been found
        for (int i = 0; i < arrayLength; i++) // create a for loop from 0 to length - 1 to perform liner search
        {
            if (searchValue == arr[i]) { //if value need to search match the value at the index i
                result = i;
                numberFound = true;
                break;
            }
        }
        if (!numberFound) result = -1; // if the number not found then set the value of result to -1 ( meaning null)
        return result;
    }

    public void displayResult() // display the ui requirement
    {
        IntegerUtils.printFoundIndex(search(), searchValue);
    }
}
