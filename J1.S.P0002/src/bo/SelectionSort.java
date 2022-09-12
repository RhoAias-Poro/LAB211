package bo;

import utils.ArrayUtils;

public class SelectionSort {
    private int[] originalArray;
    private int arrayLength;

    public SelectionSort(int[] originalArray, int arrayLength) {
        this.arrayLength = arrayLength;
        this.originalArray = originalArray;
    }

    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray);
        int index = 0;
        for (int i = 0; i < arrayLength; i++) {
            int min = cloneArray[i];
            for (int j = i+1; j < arrayLength; j++) {
                if (min > cloneArray[j])
                {
                    min = cloneArray[j];
                    index = j;
                }
            }
            if(min < cloneArray[i]) ArrayUtils.swapFromAnArray(cloneArray, index, i);
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
