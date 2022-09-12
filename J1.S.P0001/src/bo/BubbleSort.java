package bo;

import utils.ArrayUtils;

public class BubbleSort {
    private int[] originalArray;
    private int arrayLength;

    public BubbleSort(int[] originalArray, int arrayLength) {
        this.arrayLength = arrayLength;
        this.originalArray = originalArray;
    }

    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray);
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (cloneArray[j] > cloneArray[j + 1]) ArrayUtils.swapFromAnArray(cloneArray, j, j + 1);
            }
        }
        return cloneArray;
    }

    public void displayResult() {
        System.out.print("Unsorted array:");
        ArrayUtils.printIntArray(originalArray, arrayLength);
        System.out.print("Sorted array:");
        ArrayUtils.printIntArray(sort(), arrayLength);
    }
}
