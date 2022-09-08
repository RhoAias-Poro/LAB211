// Display.java display the result when LinearSearch.java has done finding

package ui;

public class Display {
    public static void displayInteger(int result, int searchNumber) // passing index and number need to search
    {
        int EMPTY = -1; // if index == -1 then it is null
        if(result != EMPTY) System.out.println("Found " + searchNumber + " at index: " + result);
        else System.out.println("Can't found " + searchNumber + " in the array");
    }
}
