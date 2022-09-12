/*
 *   Main class help exceute the code and print the array
 * */
package ui;

import bo.BubbleSort;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {

    public static void main(String[] args) {
        int option = 0;
        int[] originalArray = {};
        int[] sortedArray = {};
        BubbleSort obj;
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
                    sortedArray = obj.sort();
                    System.out.println("----- Ascending -----");
                    for (int i = 0; i < sortedArray.length; i++) {
                        System.out.print("[" + sortedArray[i] + "]");
                        if (i < sortedArray.length - 1) System.out.print("->");
                    }
                    System.out.println();
                    break;
                case 3:
                    // sort in Descending way
                    obj = new BubbleSort(originalArray, false);
                    sortedArray = obj.sort();
                    System.out.println("----- Descending -----");
                    for (int i = 0; i < sortedArray.length; i++) {
                        System.out.print("[" + sortedArray[i] + "]");
                        if (i < sortedArray.length - 1) System.out.print("<-");
                    }
                    System.out.println();
                    break;
                default:
                    break;
            }
        }while(option != 4);
    }
}
