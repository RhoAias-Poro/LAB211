package bo;

import ui.Display;

public class BubbleSort {
    private static Integer[] sort(Integer[] arrNeedSort, boolean isAsc) {
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

    public static void printResult(Integer[] arrayNeedSort, boolean isAsc)
    {
        Display.displayResult(sort(arrayNeedSort, isAsc));
    }
}
