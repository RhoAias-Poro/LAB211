package bo;

import utils.ArrayUtils;

public class InsertionSort {
    private int[] originalArray;
    private int arrayLength;

    public InsertionSort(int[] originalArray, int arrayLength) {
        this.arrayLength = arrayLength;
        this.originalArray = originalArray;
    }

    private int[] sort() {
        int[] cloneArray = ArrayUtils.cloneIntArray(originalArray);
        int index = 0;
        for(int i = 1; i < arrayLength; i++)
        {
            int key = cloneArray[i];
            int j = i - 1;
            while(j >= 0 && cloneArray[j] > key)
            {
                cloneArray[j+1] = cloneArray[j];
                j--;
            }
            cloneArray[j+1] = key;
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
