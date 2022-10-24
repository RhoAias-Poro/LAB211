package ui;

import controller.ProductManagerController;
import entity.Product;
import entity.StoreKeeper;
import util.IntegerUtils;
import util.Validations;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String menu = "Welcome to the product management system\n" +
                "1. Add StoreKeeper\n" +
                "2. Add Product\n" +
                "3. Update Product\n" +
                "4. Search Product\n" +
                "5. Sort Product by Expiry date, Date of manufacturer\n" +
                "6. Exit";
        String searchByChoice = "Element you want to search from\n" +
                "1. Name\n" +
                "2. Category\n" +
                "3. StoreKeeper\n" +
                "4. ReceiptDate\n" +
                "Please enter: ";
        int choice = 0, id = 0, searchChoice = 0;
        ProductManagerController controller = new ProductManagerController();
        Product product = new Product();
        StoreKeeper storeKeeper = new StoreKeeper();
        ArrayList<Product> foundList;
        String ret = "";
        do {
            System.out.println(menu);
            choice = IntegerUtils.getOption();
            switch (choice) {
                case 1:
                    try {
                        storeKeeper = controller.addStoreKeeper();
                        System.out.println("Add complete");
                    } catch (Exception e) {
                        Validations.throwError(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        product = controller.addProduct();
                        System.out.println("Add complete");
                    } catch (Exception e) {
                        Validations.throwError(e.getMessage());
                    }
                    break;
                case 3:
                    id = Validations.getInt("Please enter a id of a product: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE);
                    try {
                        product = controller.updateProduct(id);
                    } catch (Exception e) {
                        Validations.throwError(e.getMessage());
                    }
                    break;
                case 4:
                    searchChoice = Validations.getInt(searchByChoice, "Please enter number only", "Please enter number on the menu", 1, 4);
                    try {
                        System.out.println(controller.searchByChoice(searchChoice));
                    } catch (Exception e) {
                        Validations.throwError(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println(controller.sortByDate());
                    } catch (Exception e) {
                        Validations.throwError(e.getMessage());
                    }
                    break;
                default:
                    choice = 6;
                    break;
            }
        } while (choice != 6);
    }
}
