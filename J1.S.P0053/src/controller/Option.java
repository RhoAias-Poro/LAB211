/*
 *   Option class have optionHandling() function
 *   that take user input then based on that to determine what to do
 * */

package controller;

import bo.BubbleSort;
import ui.Display;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Option {

    //handling user input
    public static void optionHandling() {
        boolean firstInput = true;
        int option = 0; // initial a variable to store user input
        int[] originalArray = {}; // create an array to store user input
        BubbleSort sort; // BubbleSort sort object
        do {
            Display.menu(); // display the ui
            if (firstInput == true) {
                option = IntegerUtils.firstOption(true);
                firstInput = false;
            } else option = IntegerUtils.firstOption(false);
            switch (option) {
                case 1:
                    //create an array based on the length of the array that user enter
                    originalArray = ArrayUtils.createIntArray(IntegerUtils.inputNumberOfArray());
                    break;
                case 2:
                    // sort in Ascending way
                    sort = new BubbleSort(originalArray, true);
                    sort.printResult();
                    break;
                case 3:
                    // sort in Descending way
                    sort = new BubbleSort(originalArray, false);
                    sort.printResult();
                    break;
                default:
                    break;
            }
        } while (option != 4); // option 4 is exit the program
    }
}
