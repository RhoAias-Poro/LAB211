/*
*  LinearSearch program have two function to perform searching a element in a random array
*  Function inputNumber() take number of the array and each element number from the user
*  Function searchNumber() create a random array base on arguments of inputNumber() pass into,
*   display it and display the index of search number in array
* */

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

   public static void inputNumber()
   {
       int numberOfArray = 0; // create a variable for number of the array
       int searchValue = 0; // create a variable for the number need to search
       Scanner sc = new Scanner(System.in); // Create scan object that take user input
       boolean isPositiveNumber = false; // create to loop for try-catch number of the array
       boolean isNumber = false; // create to loop for try-catch number need to search
       while(isPositiveNumber == false)
       {
           try{
               System.out.println("Enter number of array:");
               numberOfArray = Integer.parseInt(sc.nextLine());
               if(numberOfArray <= 0) throw new Exception(); // if the number of the array <= 0 then throw an Exception
               isPositiveNumber = true; // if run complete all the above then make isPositiveNumber true to break the loop
           }

           catch (Exception e)
           {
               System.out.println("Please Enter Positive Integer");// display this when user enter invalid value
           }
       }
       while(isNumber == false)
       {
           try{
               System.out.println("Enter search value:");
               searchValue = Integer.parseInt(sc.nextLine());
               isNumber = true; // if run complete all the above then make isPositiveNumber true to break the loop
           }

           catch(Exception e)
           {
               System.out.println("Please Enter An Integer"); // display this when user enter invalid value
           }
       }

       //pass the userInput to searchNumber()
       searchNumber(numberOfArray, searchValue);
   }

   public static void searchNumber(int numberOfArray, int searchValue)
   {
       Integer[] randomArray = new Integer[numberOfArray]; // create a array have length = numberOfArray
       Random rd = new Random(); // create Random Object
       for(int i = 0; i < numberOfArray; i++) // create a for loop from 0 to numberOfArray - 1 to create random array
       {
           randomArray[i] = rd.nextInt(numberOfArray); //take a random number in number range and store it in array
       }
       System.out.print("The array: [");
       for(int i = 0; i < numberOfArray; i++) // create a for loop from 0 to numberOfArray - 1 to print the array
       {
           System.out.print(randomArray[i]); // print element in the array
           if(i < numberOfArray - 1) System.out.print(", ");
       }
       System.out.println("]");
       int result = 0; // store the index that searchValue equal to
       for(int i = 0; i < numberOfArray; i++) // create a for loop from 0 to numberOfArray -1 to perform liner search
       {
           if(searchValue == randomArray[i])
           {
               result = i;
               break;
           }
       }
       if(result == 0) System.out.println("Not found " + searchValue + " in the array");
       else System.out.println("Found " + searchValue + "at index: " + result);
   }

   public static void main(String[] args)
   {
        inputNumber();
   }
}
