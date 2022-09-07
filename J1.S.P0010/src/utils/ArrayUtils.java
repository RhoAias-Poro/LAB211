package utils;

import java.util.Random;

public class ArrayUtils {
    public static Integer[] createRandomArray(int range)
    {
        Integer[] randomArray = new Integer[range]; // create a array have length = range
        Random rd = new Random(); // create Random Object
        for(int i = 0; i < range; i++) // create a for loop from 0 to range - 1 to create random array
        {
            randomArray[i] = rd.nextInt(range); //tke a random number in number range and store it in array
        }
        return randomArray;
    }

    public static void printArray(Integer[] Array, int range)
    {
        System.out.print("The array: [");
        for(int i = 0; i < range; i++) // create a for loop from 0 to range - 1 to print the array
        {
            System.out.print(Array[i]); // print element in the array
            if(i < range - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static Integer[] cloneArray(Integer[] originalArray)
    {
        Integer[] ret = new Integer[originalArray.length];
        int index = 0;
        for(int i = 0; i < originalArray.length; i++)
        {
            ret[i] = originalArray[index++];
        }
        return ret;
    }
}
