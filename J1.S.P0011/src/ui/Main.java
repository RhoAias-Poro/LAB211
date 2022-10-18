package ui;

import controller.BaseConverterController;
import utils.utils.Validations;

public class Main {
    public static void main(String[] args) throws Exception {
        BaseConverterController controller = new BaseConverterController();
        String menu = "Welcome to base converter\n" +
                "1. Binary\n" +
                "2. Decimal\n" +
                "3. Hexadecimal\n" +
                "4. Exit\n";
        while (true) {
            System.out.println(menu);
            int convertType = Validations.getInt("Please enter a option: ", "Please enter number format", "Enter option in above", 1, 4);
            if (convertType == 4) break;
            int originalType = Validations.getInt("Please enter original base type: ", "Please enter number only", "Enter option in above", 1, 4);
            if (originalType == 4) break;
            String numbString = Validations.getStringByRegex("Please enter value that you want to convert: ", "Please enter value that satisfy the base you choose", "[a-zA-Z0-9]+");
            try {
                System.out.println(controller.inputNumberAndBase(originalType, convertType, numbString));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
