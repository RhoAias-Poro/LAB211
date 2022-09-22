package utils;

import java.util.Random;
import java.util.Scanner;

public class ArrayUtils {

    //create a random array
    public static int[] createRandomIntArray(int range) {
        int[] randomArray = new int[range]; // create a array have length = range
        Random rd = new Random(); // create Random Object
        for (int i = 0; i < range; i++) // create a for loop from 0 to range - 1 to create random array
        {
            randomArray[i] = rd.nextInt(range); //tke a random number in number range and store it in array
        }
        return randomArray;
    }

    //print the array
    public static void printIntArray(int[] Array, int range) {
        System.out.print(" [");
        for (int i = 0; i < range; i++) // create a for loop from 0 to range - 1 to print the array
        {
            System.out.print(Array[i]); // print element in the array
            if (i < range - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // make a clone of original array type int
    public static int[] cloneIntArray(int[] originalArray) {
        int[] ret = new int[originalArray.length]; // create an array
        int index = 0; // used to traverse all the original array
        for (int i = 0; i < originalArray.length; i++) {
            ret[i] = originalArray[index++]; // assign all the value of original array to the new array
        }
        return ret;
    }

    // create an int array based on the length of the user enter
    public static int[] createIntArray(int arrLength) {
        Scanner sc = new Scanner(System.in); // scan object
        int[] arr = new int[arrLength]; // array
        for (int i = 0; i < arrLength; i++) { // to enter user input
            boolean isNumber = false; // to check if user enter a number or not
            while (isNumber == false) {
                System.out.print("Enter Number " + (i + 1) + ": ");
                try {
                    arr[i] = Integer.parseInt(sc.nextLine()); // if not then catch that exception then reset the loop
                    isNumber = true; // break the loop
                } catch (Exception e) {
                    System.out.println("Please input a number");
                }
            }
        }
        return arr;
    }

    // swaping two integer from an array
    public static void swapFromAnArray(int array[], int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void sortAsc(int array[])
    {
        int length = array.length;
        for(int i = 1; i < length; i++){
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key)
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}
