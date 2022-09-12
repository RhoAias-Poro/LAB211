package controlle;

import bo.BubbleSort;
import ui.Display;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class OptionControl {
    public static void optionHandling() {
        int option;
        int[] originalArray ={};
        BubbleSort obj;
        Display printObj;
        do {
            Display.menu();
            option = IntegerUtils.getOption();
            switch (option) {
                case 1:
                    //create an array based on the length of the array that user enter
                    originalArray = ArrayUtils.createIntArray(IntegerUtils.inputNumberOfArray());
                    break;
                case 2:
                    // sort in Ascending way
                    obj = new BubbleSort(originalArray, true);
                    printObj = new Display(obj.sort(), true);
                    printObj.printArray();
                    break;
                case 3:
                    // sort in Descending way
                    obj = new BubbleSort(originalArray, false);
                    printObj = new Display(obj.sort(), false);
                    printObj.printArray();
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }
}
