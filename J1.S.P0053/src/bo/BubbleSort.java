package bo;

import ui.Display;
import utils.ArrayUtils;

public class BubbleSort {
    private int[] arrNeedSort;
    private boolean isAsc;
    public BubbleSort(int[] arrayNeedSort, boolean isAsc)
    {
        this.arrNeedSort = arrayNeedSort;
        this.isAsc = isAsc;
    }
    private int[] sort() {
        int arrNeedSortLength = arrNeedSort.length;
        int swap;
        if (isAsc) {
            System.out.println("----- bo.Ascending -----");
            for (int i = 0; i < arrNeedSortLength; i++) {
                for (int j = 0; j < arrNeedSortLength - 1 - i; j++) {
                    if (arrNeedSort[j] > arrNeedSort[j + 1]) {
                        swap = arrNeedSort[j];
                        arrNeedSort[j] = arrNeedSort[j + 1];
                        arrNeedSort[j + 1] = swap;
                    }

                }
            }
        }

        else
        {
            for (int i = 0; i < arrNeedSortLength; i++) {
                for (int j = 0; j < arrNeedSortLength - 1 - i; j++) {
                    if (arrNeedSort[j] < arrNeedSort[j + 1]) {
                        swap = arrNeedSort[j];
                        arrNeedSort[j] = arrNeedSort[j + 1];
                        arrNeedSort[j + 1] = swap;
                    }
                }
            }
        }
        return arrNeedSort;
    }

    public void printResult()
    {
        ArrayUtils.printInOrderArray(sort(), isAsc);
    }
}
