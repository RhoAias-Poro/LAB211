package bo;

import utils.ArrayUtils;

public class BubbleSort {
    private int[] arrayNeedSort;
    private boolean isAsc;

    //constructor
    public BubbleSort(int[] arrayNeedSort, boolean isAsc) {
        this.arrayNeedSort = arrayNeedSort;
        this.isAsc = isAsc;
    }

    // sorting function
    private int[] sort() {
        int arrNeedSortLength = arrayNeedSort.length;

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
