package controller;

import bo.BubbleSort;
import ui.Display;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Option {
    public static void optionHandling() {
        int option;
        int[] originalArray = {};
        BubbleSort sort;
        do {
            Display.menu();
            option = IntegerUtils.getOption();
            switch (option) {
                case 1:
                    originalArray = ArrayUtils.createIntArray(IntegerUtils.inputNumberOfArray());
                    break;
                case 2:
                    sort = new BubbleSort(originalArray, true);
                    sort.printResult();
                    break;
                case 3:
                    sort = new BubbleSort(originalArray, false);
                    sort.printResult();
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }
}
