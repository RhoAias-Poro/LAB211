/*
* Main.java print the result of the program
* */

package ui;
import bo.LinearSearch;
import utils.*;

public class Main {
    public static void main(String[] args)
    {
        IntegerUtils input = new IntegerUtils();
        ArrayUtils array = new ArrayUtils();

        System.out.println("Enter number of array:");
        int numberOfArray =  IntegerUtils.inputNumberOfArray(); // input number of array

        System.out.println("Enter search number:");
        int searchNumber = IntegerUtils.inputSearchNumber(); // input search number

        Integer[] originalArray = array.createRandomArray(numberOfArray); // create random array
        ArrayUtils.printArray(originalArray, numberOfArray); // print the array

        LinearSearch sortObject = new LinearSearch(originalArray, numberOfArray, searchNumber);
        sortObject.displayResult(); // display the result
    }
}
