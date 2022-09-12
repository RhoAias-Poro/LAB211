package bo;

import utils.ArrayUtils;

public class SelectionSort {
    private int[] originalArray; //to store originalArray
    private int arrayLength; // store length of the array

    //constructor
    public SelectionSort(int[] originalArray, int arrayLength) {
        this.arrayLength = arrayLength;
        this.originalArray = originalArray;
    }

    //Implement Selection Sort
    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray); // create a clone of Original Array
        int index = 0; // to store the min value index
        for (int i = 0; i < arrayLength; i++) {
            int min = cloneArray[i]; // set it to the first element in the search
            for (int j = i+1; j < arrayLength; j++) {
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
        ArrayUtils.printIntArray(originalArray, arrayLength);
        System.out.print("Sorted array:");
        ArrayUtils.printIntArray(sort(), arrayLength);
    }
}
