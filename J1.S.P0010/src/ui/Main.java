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
        ArrayUtils randArray = new ArrayUtils();

        System.out.println("Enter number of array:");
        int numberOfArray = IntegerUtils.inputNumberOfArray(); // input number of array

        System.out.println("Enter search number:");
        int searchNumber = IntegerUtils.inputSearchNumber(); // input search number

        int[] array = randArray.createRandomIntArray(numberOfArray); // create random array
        ArrayUtils.printIntArray(array, numberOfArray); // print the array

        LinearSearch obj = new LinearSearch(array);
        int result = obj.getSorted(searchNumber);
        if(result == -1) System.out.println("Not Found");
        else System.out.println("Found " + searchNumber + " at index: " + result);
    }
}
