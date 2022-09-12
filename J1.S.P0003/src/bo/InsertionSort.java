package bo;

import utils.ArrayUtils;

public class InsertionSort {
    private int[] originalArray; //store the original array

    //constructor
    public InsertionSort(int[] originalArray) {
        this.originalArray = originalArray;
    }

    //implement InsertionSort
    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray); // create a clone of original array
        for (int i = 1; i < cloneArray.length; i++) // i start with 1 two have two element in the first loop to compare
        {
            int key = cloneArray[i]; // set the last element of the loop as a key
            int j = i - 1;
            while (j >= 0 && cloneArray[j] > key) // if the element with the index j is > key
            {
                cloneArray[j + 1] = cloneArray[j]; // change the value of that element(key) = to the value of index j
                j--; // continue when end of the loop
            }
            cloneArray[j + 1] = key; // change the value of the element after the last element in the while loop to key
        }
        return cloneArray;
    }

    //display the result
    public void displayResult() {
        System.out.print("Unsorted array:");
        ArrayUtils.printIntArray(originalArray, originalArray.length);
        System.out.print("Sorted array:");
        ArrayUtils.printIntArray(sort(), originalArray.length);
    }
}
