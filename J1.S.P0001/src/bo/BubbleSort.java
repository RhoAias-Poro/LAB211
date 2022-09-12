package bo;

import utils.ArrayUtils;

public class BubbleSort {
    private int[] originalArray; // initial to store the original array
    private int arrayLength; // store the length of the array

    //constructor
    public BubbleSort(int[] originalArray, int arrayLength) {
        this.arrayLength = arrayLength;
        this.originalArray = originalArray;
    }

    //implement BubbleSort algorithm
    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray); // make a clone of original array
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                // compare two element next to each other
                // if the first element > the second element -> swap them
                if (cloneArray[j] > cloneArray[j + 1]) ArrayUtils.swapFromAnArray(cloneArray, j, j + 1);
            }
        }
        return cloneArray;
    }

    public void displayResult() {
        // display the original array
        System.out.print("Unsorted array:");
        ArrayUtils.printIntArray(originalArray, arrayLength);

        //display the sorted array
        System.out.print("Sorted array:");
        ArrayUtils.printIntArray(sort(), arrayLength);
    }
}
