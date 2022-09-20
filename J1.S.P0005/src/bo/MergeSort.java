package bo;

import utils.ArrayUtils;

public class MergeSort {
    private int[] originalArray; //store the original array
    private int[] cloneArray;

    //constructor
    public MergeSort(int[] originalArray) {
        this.originalArray = originalArray;
        cloneArray = originalArray;
    }
    //implement InsertionSort

    private void partitionAndMerge(int[] array, int left, int right, int middle) {
        int lengthArrayLeft = middle - left + 1;
        int lengthArrayRight = right - middle;
        int[] arrayLeft = new int[lengthArrayLeft];
        int[] arrayRight = new int[lengthArrayRight];
        for (int i = 0; i < lengthArrayLeft; i++) {
            arrayLeft[i] = array[left + i];
        }
        for (int i = 0; i < lengthArrayRight; i++) {
            arrayRight[i] = array[middle + 1 + i];
        }
        int i, j, k;
        i = 0;
        j = 0;
        k = left;
        while (i < lengthArrayLeft && j < lengthArrayRight) {
            if (arrayLeft[i] <= arrayRight[j]) {
                array[k] = arrayLeft[i];
                i++;
            } else {
                array[k] = arrayRight[j];
                j++;
            }
            k++;
        }
        while (i < lengthArrayLeft) {
            array[k] = arrayLeft[i];
            i++;
            k++;
        }
        while (j < lengthArrayRight) {
            array[k] = arrayRight[j];
            j++;
            k++;
        }
    }

    private void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (right + left) / 2;
            sort(array, left, middle);
            sort(array, middle + 1, right);
            partitionAndMerge(array, left, right, middle);
        }
    }

    //display the result
    public void displayResult() {
        System.out.print("Unsorted array:");
        ArrayUtils.printIntArray(originalArray, originalArray.length);
        System.out.print("Sorted array:");
        sort(cloneArray, 0, cloneArray.length - 1);
        ArrayUtils.printIntArray(cloneArray, cloneArray.length);
    }
}
