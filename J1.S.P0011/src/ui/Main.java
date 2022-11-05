package ui;

import controller.BaseConverterController;
import utils.utils.Validations;

public class Main {
    public static void main(String[] args) throws Exception {
        BaseConverterController controller = new BaseConverterController();
        String menu = """
                Welcome to base converter
                1. Binary
                2. Decimal
                3. Hexadecimal
                4. Exit
                """;
        while (true) {
            System.out.println(menu);
            int convertType = Validations.getInt("Please enter a option: ", "Please enter number format", "Enter option in above", 1, 4);
            if (convertType == 4) break;
            int originalType = Validations.getInt("Please enter original base type: ", "Please enter number only", "Enter option in above", 1, 4);
            if (originalType == 4) break;
            String numbString = Validations.getStringByRegex("Please enter value that you want to convert: ", "Please enter value that satisfy the base you choose", "[a-zA-Z0-9]+");
            try {
                System.out.println("Return value: " + controller.inputNumberAndBase(originalType, convertType, numbString));
            } catch (Exception e) {
                Validations.throwError(e.getMessage());
            }
        }
    }
}
