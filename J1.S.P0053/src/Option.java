
import java.util.*;
import ui.Menu;
public class Option {
    public int getOption()
    {
        Menu function = new Menu();
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(isValid == false)
        {
           try{
               function.menu();
               option = Integer.parseInt(sc.nextLine());
               if(option < 1 || option > 4) throw new Exception();
               isValid = true;
            }
            catch(Exception e)
            {
                System.out.println("Please enter an valid option");
            } 
        }
        return option;
    }
}
