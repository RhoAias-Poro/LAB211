package bo;

import utils.ArrayUtils;

public class BubbleSort {
    private int[] originalArray; // initial to store the original array

    //constructor
    public BubbleSort(int[] originalArray) {
        this.originalArray = originalArray;
    }

    //implement BubbleSort algorithm
    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray); // make a clone of original array
        for (int i = 0; i < cloneArray.length; i++) {
            for (int j = 0; j < cloneArray.length - 1 - i; j++) {
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
        ArrayUtils.printIntArray(originalArray, originalArray.length);

        //display the sorted array
        System.out.print("Sorted array:");
        ArrayUtils.printIntArray(sort(), originalArray.length);
    }
}
