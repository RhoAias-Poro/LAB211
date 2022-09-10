package bo;

import utils.ArrayUtils;

public class BubbleSort {
    private int[] arrayNeedSort;
    private boolean isAsc;

    public BubbleSort(int[] arrayNeedSort, boolean isAsc) {
        this.arrayNeedSort = arrayNeedSort;
        this.isAsc = isAsc;
    }

    private int[] sort() {
        int arrNeedSortLength = arrayNeedSort.length;
        int swap;
        if (isAsc) {
            for (int i = 0; i < arrNeedSortLength; i++) {
                for (int j = 0; j < arrNeedSortLength - 1 - i; j++) {
                    if (arrayNeedSort[j] > arrayNeedSort[j + 1]) {
                        ArrayUtils.swap(arrayNeedSort, j, j + 1);
                    }
                }
            }
        } else {
            for (int i = 0; i < arrNeedSortLength; i++) {
                for (int j = 0; j < arrNeedSortLength - 1 - i; j++) {
                    if (arrayNeedSort[j] < arrayNeedSort[j + 1]) {
                        ArrayUtils.swap(arrayNeedSort, j, j + 1);
                    }
                }
            }
        }
        return arrayNeedSort;
    }

    public void printResult() {
        ArrayUtils.printInOrderArray(sort(), isAsc);
    }
}
