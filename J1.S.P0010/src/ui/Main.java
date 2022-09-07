package ui;
import bo.LinearSearch;
import utils.*;
import bo.LinearSearch;
public class Main {
    public static void main(String[] args)
    {
        InputUtils input = new InputUtils();
        ArrayUtils array = new ArrayUtils();

        System.out.println("Enter number of array:");
        int numberOfArray =  InputUtils.inputNumberOfArray();

        System.out.println("Enter search number:");
        int searchNumber = InputUtils.inputSearchNumber();

        Integer[] originalArray = array.createRandomArray(numberOfArray);
        ArrayUtils.printArray(originalArray, numberOfArray);

        LinearSearch sortObject = new LinearSearch(originalArray, numberOfArray, searchNumber);
        sortObject.displayResult();
    }
}
