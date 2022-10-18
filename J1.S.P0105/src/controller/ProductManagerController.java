package controller;

import bo.ProductManagementInputer;
import bo.ProductManager;
import bo.StoreKeeperManager;
import entity.Product;
import entity.StoreKeeper;
import util.Validations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProductManagerController {
    private ProductManager productManager;
    private ProductManagementInputer input;
    private StoreKeeperManager storeKeeperManager;
    private StoreKeeper storeKeeper;
    private Product product;

    public ProductManagerController() {
        productManager = new ProductManager();
        input = new ProductManagementInputer();
        storeKeeperManager = new StoreKeeperManager();
    }

    public StoreKeeper addStoreKeeper() throws Exception {
        storeKeeper = new StoreKeeper();
        while (true) {
            input.storeKeeperInput(storeKeeper);
            try {
                storeKeeperManager.searchByStoreKeeper(storeKeeper);
                System.err.println("The storeKeeper is exists");
            } catch (Exception e) {
                storeKeeperManager.addStoreKeeper(storeKeeper);
                break;
            }
        }
        return storeKeeper;
    }

    public Product addProduct() throws Exception {
        product = new Product();
        storeKeeper = new StoreKeeper();
        while (true) {
            input.productInput(product, storeKeeper);
            try {
                productManager.getProductById(product.getId());
            } catch (Exception e) {
                productManager.addProduct(product);
                break;
            }
        }
        return product;
    }

    public Product updateProduct(int id) throws Exception {
        try {
            product = productManager.getProductById(id);
        } catch (Exception e) {
            storeKeeper = new StoreKeeper();
            input.productInput(product, storeKeeper);
            return productManager.updateProduct(id, product);
        }
        throw new Exception("This product exist already");
    }

    public ArrayList<Product> searchByChoice(int choice) throws Exception {
        Date receiptDate = null;
        String name = null;
        String category = null;
        storeKeeper = new StoreKeeper(null);
        switch (choice) {
            case 1:
                name = Validations.getStringByRegex("Please enter name of the product: ", "Please enter character only", "[a-zA-X\s]+");
                break;
            case 2:
                category = Validations.getStringByRegex("Please enter category for the product: ", "Please enter character only", "[a-zA-X\s]+");
                break;
            case 3:
                storeKeeper.setName(Validations.getStringByRegex("Please enter name of the seller: ", "Please enter character only", "[a-zA-X\s]+"));
                break;
            case 4:
                receiptDate = new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter expire date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy"));
                break;
        }
        return productManager.getProducts(name, category, storeKeeper, receiptDate);
    }
}