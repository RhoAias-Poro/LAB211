package ui;

public class Display {
    public static void displayInteger(int result, int searchNumber)
    {
        int EMPTY = 0;
        if(result != 0) System.out.println("Found " + searchNumber + " at index: " + result);
        else System.out.println("Can't found " + searchNumber + " in the array");
    }
}
