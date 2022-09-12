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
    public int[] sort() {
        for (int i = 0; i < arrayNeedSort.length; i++) {
            for (int j = 0; j < arrayNeedSort.length - 1 - i; j++) {
                if (isAsc) {
                    if (arrayNeedSort[j] > arrayNeedSort[j + 1]) {
                        ArrayUtils.swapFromAnArray(arrayNeedSort, j, j + 1);
                    }
                } else {
                    if (arrayNeedSort[j] < arrayNeedSort[j + 1]) {
                        ArrayUtils.swapFromAnArray(arrayNeedSort, j, j + 1);
                    }
                }
            }
        }
        return arrayNeedSort;
    }
}
