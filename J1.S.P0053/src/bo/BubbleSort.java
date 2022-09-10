/*
 *   BubbleSort class have to function
 *   the function sort() sort the array that user enter then return it in ascending or descending way
 *   the function printResult() print the array
 * */

package bo;

import utils.ArrayUtils;

public class BubbleSort {
    private int[] arrayNeedSort; // initial an array to store the array that user enter
    private boolean isAsc; // determine to sort Ascending or Descending

    //constructor
    public BubbleSort(int[] arrayNeedSort, boolean isAsc) {
        this.arrayNeedSort = arrayNeedSort;
        this.isAsc = isAsc;
    }

    // sorting function
    private int[] sort() {
        int arrNeedSortLength = arrayNeedSort.length; // length of the array

        // Ascending sort
        if (isAsc) {
            for (int i = 0; i < arrNeedSortLength; i++) {
                for (int j = 0; j < arrNeedSortLength - 1 - i; j++) {
                    if (arrayNeedSort[j] > arrayNeedSort[j + 1]) {
                        ArrayUtils.swapFromAnArray(arrayNeedSort, j, j + 1);
                    }
                }
            }
        }

        // Descending sort
        else {
            for (int i = 0; i < arrNeedSortLength; i++) {
                for (int j = 0; j < arrNeedSortLength - 1 - i; j++) {
                    if (arrayNeedSort[j] < arrayNeedSort[j + 1]) {
                        ArrayUtils.swapFromAnArray(arrayNeedSort, j, j + 1);
                    }
                }
            }
        }
        return arrayNeedSort;
    }

    // print the result
    public void printResult() {
        ArrayUtils.printInOrderArray(sort(), isAsc);
    }
}
