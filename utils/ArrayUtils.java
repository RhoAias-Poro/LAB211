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
        System.out.print("The array: [");
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

    public static int[] createIntArray(int arrLength) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            boolean isNumber = false;
            while (isNumber == false) {
                System.out.print("Enter Number " + (i + 1) + ": ");
                try {
                    arr[i] = Integer.parseInt(sc.nextLine());
                    isNumber = true;
                } catch (Exception e) {
                    System.out.println("Please input a number");
                }
            }
        }
        return arr;
    }

    public static void swap(int array[], int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void printInOrderArray(int[] array, boolean isAsc) {
        int arrayLength = array.length;
        if (isAsc) {
            System.out.println("----- Ascending -----");
            for (int i = 0; i < arrayLength; i++) {
                System.out.print("[" + array[i] + "]");
                if (i < arrayLength - 1) System.out.print("->");
            }
        } else {
            System.out.println("----- Descending -----");
            for (int i = 0; i < arrayLength; i++) {
                System.out.print("[" + array[i] + "]");
                if (i < arrayLength-1) System.out.print("<-");
            }
        }
        System.out.println();
    }
}
