/*
 * Display class have function menu() to print the UI that help user to decide the input to enter
 * */

package ui;

public class Display {
    private int[] array;
    private boolean isAsc;

    public Display(int[] array, boolean isAsc) {
        this.array = array;
        this.isAsc = isAsc;
    }

    //display the ui
    public static void menu() {
        System.out.println("========= Bubble Sort program =========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort bo.Ascending");
        System.out.println("3. Sort bo.Descending");
        System.out.println("4. Exit");
    }

    public void printArray() {
        if (isAsc) System.out.println("----- Ascending -----");
        else System.out.println("----- Descending -----");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
            if (isAsc && i < array.length - 1) System.out.print("->");
            if (!isAsc && i < array.length - 1) System.out.print("<-");
        }
        System.out.println();
    }
}
