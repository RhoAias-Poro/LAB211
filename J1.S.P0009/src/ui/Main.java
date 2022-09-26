package ui;

import bo.Fibonacci;
import utils.IntegerUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length you want: ");
        int length = sc.nextInt();
        Fibonacci obj = new Fibonacci(length);
        long[] array = obj.getFibo();
        System.out.println("The " + length + " sequence fibonacci:");
        IntegerUtils.print(array);
    }
}
