package ui;

import util.IntegerUtils;

public class Main {
    public static void main(String[] args) {
        String menu = "Welcome to the product management system\n" +
                "1. Add StoreKeeper\n" +
                "2. Add Product\n" +
                "3. Update Product\n" +
                "4. Search Product\n" +
                "5. Sort Product by Expiry date, Date of manufacturer";
        int choice = 0;
        do {
            System.out.println(menu);
            choice = IntegerUtils.getOption();
            switch (choice) {
                case 1:
                    break;
            }
        } while (choice != 6);
    }
}
