package ui;

import controller.BaseConverterController;
import entity.BaseType.baseType;
import utils.utils.Validations;

public class Main {
    public static void main(String[] args) {
        BaseConverterController controller = new BaseConverterController();
        int choice = 0;
        String menu = "Welcome to base converter\n" +
                "1. Binary\n" +
                "2. Decimal\n" +
                "3. Hexadecimal\n" +
                "4. Exit\n";

        do {
            System.out.println(menu);
            choice = Validations.getInt("Please enter a option: ", "Please enter number format", "Enter option in above", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println(controller.inputNumberAndBase(baseType.BIN));
                    break;
                case 2:
                    System.out.println(controller.inputNumberAndBase(baseType.DEC));
                    break;
                case 3:
                    System.out.println(controller.inputNumberAndBase(baseType.HEX));
                    break;
                case 4:
                    choice = 4;
                    break;
            }
        } while (choice != 4);
    }
}
