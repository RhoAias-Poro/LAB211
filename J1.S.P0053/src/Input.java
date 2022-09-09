import java.util.*;

public class Input {
    Scanner sc = new Scanner(System.in);
    public Integer[] inputElement()
    {
        int arrLength = 0;
        boolean isPositiveNumber = false;
        System.out.println("----- Input Element -----");
        System.out.println("Input Length Of Array");
        while(isPositiveNumber == false)
        {
          try{
            System.out.print("Enter Number: ");
            arrLength = Integer.parseInt(sc.nextLine());
            if(arrLength <= 0) throw new Exception();
            isPositiveNumber = true;
            }
            catch(Exception e)
            {
                System.out.println("Please input number and number is greater than zero");
            }    
        }
        
        Integer[] arr = new Integer[arrLength]; 
        for(int i = 0; i < arrLength; i++)
        {
            boolean isNumber = false; 
            while(isNumber == false)
            {
                System.out.print("Enter Number " + (i+1)+ ": ");
                try{
                arr[i] = Integer.parseInt(sc.nextLine());
                isNumber = true;
            }
                catch(Exception e)
                {
                 System.out.println("Please input a number");
                }
            }   
        }
        return arr;


    }
}
