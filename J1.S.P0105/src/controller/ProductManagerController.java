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
    private final int SEARCH_BY_RECIPTDATE = 4;
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
            throw new Exception(("Can't found the product "));
        }
        product = input.productInput();
        return productManager.updateProduct(id, product);
    }

    public String searchByChoice(int choice) throws Exception {
        ArrayList<Product> list;
        String ret = "";
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
            case SEARCH_BY_RECIPTDATE ->
                    receiptDate = new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter receipt date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy"));
        }
        list = productManager.getProducts(name, category, storeKeeper, receiptDate);
        for (Product product : list) {
            ret += productManager.toString(product);
        }
        return ret;
    }

    public String sortByDate() throws Exception {
        ArrayList<Product> list = productManager.getListProduct();
        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) ((p1.getExpireDate().getTime() - p1.getProduceDate().getTime()) - (p2.getExpireDate().getTime() - p2.getProduceDate().getTime()));
            }
        });
        String ret = "";
        for (Product p : list) {
            ret += productManager.toString(p);
        }
        return ret;
    }
}