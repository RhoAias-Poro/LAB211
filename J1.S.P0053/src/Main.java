import java.lang.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args)
    {
        Option optionGet = new Option();
        int option = optionGet.getOption();
        while(option == 2 || option == 3)
        {
            System.out.println("Please enter an input first");
            option = optionGet.getOption();
        }
        Integer[] arr = {};
        while(option!=4)
        {
            if(option == 1)
            {
                Input option1 = new Input();
                arr = option1.inputElement();
                option = optionGet.getOption();
            }
            
            else if(option == 2)
            {
                Ascending option2 = new Ascending(arr);
                option = optionGet.getOption();
            }
            
            else if(option == 3)
            {
                Descending option3 = new Descending(arr);
                option = optionGet.getOption();
            }
        }    
    }
}
