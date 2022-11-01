package controller;

import bo.ProductManagementInputer;
import bo.ProductManager;
import bo.StoreKeeperManager;
import entity.Product;
import entity.StoreKeeper;
import util.Validations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class ProductManagerController {
    private final int SEARCH_BY_NAME = 1;
    private final int SEARCH_BY_CATEGORY = 2;
    private final int SEARCH_BY_STOREKEPPER = 3;
    private final int SEARCH_BY_RECIPT_DATE = 4;
    private final int SORT_BY_EXPIRE_DATE = 1;
    private final int SORT_BY_DATE_OF_MANUFACTURE = 2;
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
        storeKeeper = input.storeKeeperInput();
        storeKeeperManager.addStoreKeeper(storeKeeper);
        return storeKeeper;
    }

    public Product addProduct() throws Exception {
        product = input.productInput();
        storeKeeperManager.ensureStoreKeeperExist(product.getStoreKeeper());
        productManager.addProduct(product);
        return product;
    }

    public Product updateProduct(int id) throws Exception {
        product = productManager.getProductById(id);
        if (product == null) {
            throw new Exception("Can't found the product ");
        }
        product = input.productInput();
        return productManager.updateProduct(id, product);
    }

    public String searchByChoice(int choice) throws Exception {
        ArrayList<Product> list;
        StringBuilder ret = new StringBuilder();
        Date receiptDate = null;
        String name = null;
        String category = null;
        storeKeeper = new StoreKeeper(null);
        switch (choice) {
            case SEARCH_BY_NAME ->
                    name = Validations.getStringByRegex("Please enter name of the product: ", "Please enter character only", "[a-zA-X\s]+");
            case SEARCH_BY_CATEGORY ->
                    category = Validations.getStringByRegex("Please enter category for the product: ", "Please enter character only", "[a-zA-X\s]+");
            case SEARCH_BY_STOREKEPPER ->
                    storeKeeper.setName(Validations.getStringByRegex("Please enter name of the seller: ", "Please enter character only", "[a-zA-X\s]+"));
            case SEARCH_BY_RECIPT_DATE ->
                    receiptDate = new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter receipt date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy"));
            default -> throw new Exception("Invalid choice to search!!!!!");
        }
        list = productManager.getProductsByChoice(name, category, storeKeeper, receiptDate);
        for (Product product : list) {
            ret.append(productManager.toString(product));
        }
        return ret.toString();
    }

    public String sortByDate(int choice) throws Exception {
        ArrayList<Product> list = productManager.getListProduct();
        switch (choice) {
            case SORT_BY_EXPIRE_DATE -> list = sort(list, true);
            case SORT_BY_DATE_OF_MANUFACTURE -> list = sort(list, false);
            default -> throw new Exception("Invalid choice to sort!!!!!");
        }
        StringBuilder ret = new StringBuilder();
        for (Product p : list) {
            ret.append(productManager.toString(p));
        }
        return ret.toString();
    }

    private ArrayList<Product> sort(ArrayList<Product> list, boolean isExpireDate) {
        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (isExpireDate) {
                    return (int) (p1.getExpireDate().getTime() - p2.getExpireDate().getTime());

                } else {
                    return (int) (p1.getProduceDate().getTime() - p2.getProduceDate().getTime());
                }
            }
        });
        return list;
    }
}