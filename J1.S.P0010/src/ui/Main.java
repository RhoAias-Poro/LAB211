/*
 * Main.java print the result of the program
 * */

package ui;

import bo.LinearSearch;
import utils.ArrayUtils;
import utils.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        IntegerUtils input = new IntegerUtils();
        ArrayUtils array = new ArrayUtils();

        System.out.println("Enter number of array:");
        int numberOfArray = IntegerUtils.inputNumberOfArray(); // input number of array

        System.out.println("Enter search number:");
        int searchNumber = IntegerUtils.inputSearchNumber(); // input search number

        int[] originalArray = array.createRandomIntArray(numberOfArray); // create random array
        ArrayUtils.printIntArray(originalArray, numberOfArray); // print the array

        LinearSearch searchObject = new LinearSearch(originalArray, numberOfArray, searchNumber);
        searchObject.displayResult(); // display the result
    }
}
