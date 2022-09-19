package bo;

import utils.ArrayUtils;

public class QuickSort {
    private int[] originalArray; //store the original array
    private int[] cloneArray;

    //constructor
    public QuickSort(int[] originalArray) {
        this.originalArray = originalArray;
        cloneArray = originalArray;
    }
    //implement InsertionSort

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                j++;
                ArrayUtils.swapFromAnArray(array, i, j);
            }
        }
        ArrayUtils.swapFromAnArray(array, j + 1, high);
        return j + 1;
    }

    private void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
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
