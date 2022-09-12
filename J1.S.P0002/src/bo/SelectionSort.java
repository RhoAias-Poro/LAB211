package bo;

import utils.ArrayUtils;

public class SelectionSort {
    private int[] originalArray; //to store originalArray

    //constructor
    public SelectionSort(int[] originalArray) {
        this.originalArray = originalArray;
    }

    //Implement Selection Sort
    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray); // create a clone of Original Array
        int index = 0; // to store the min value index
        for (int i = 0; i < cloneArray.length; i++) {
            int min = cloneArray[i]; // set it to the first element in the search
            for (int j = i+1; j < cloneArray.length; j++) {
                if (min > cloneArray[j]) // if any next element is < min
                {
                    min = cloneArray[j];
                    index = j;
                }
            }
            // after the loop, min is the smallest in the loop i
            // after that swap them with the first element of the loop
            if(min < cloneArray[i]) ArrayUtils.swapFromAnArray(cloneArray, index, i);
        }
        return cloneArray;
    }

    //print the result
    public void displayResult() {
        System.out.print("Unsorted array:");
        ArrayUtils.printIntArray(originalArray, originalArray.length);
        System.out.print("Sorted array:");
        ArrayUtils.printIntArray(sort(), originalArray.length);
    }
}
