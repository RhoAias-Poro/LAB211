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
        return storeKeeperManager.addStoreKeeper(storeKeeper);
    }

    public Product addProduct() throws Exception {
        product = input.productInput();
        storeKeeperManager.ensureStoreKeeperExist(product.getStoreKeeper());
        return productManager.addProduct(product);
    }

    public Product updateProduct(int id) throws Exception {
        product = productManager.getProductById(id);
        if (product == null) throw new Exception(("Can't found the product "));
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
            case 1 ->
                    name = Validations.getStringByRegex("Please enter name of the product: ", "Please enter character only", "[a-zA-X\s]+");
            case 2 ->
                    category = Validations.getStringByRegex("Please enter category for the product: ", "Please enter character only", "[a-zA-X\s]+");
            case 3 ->
                    storeKeeper.setName(Validations.getStringByRegex("Please enter name of the seller: ", "Please enter character only", "[a-zA-X\s]+"));
            case 4 ->
                    receiptDate = new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter receipt date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy"));
        }
        list = productManager.getProducts(name, category, storeKeeper, receiptDate);
        for (Product product : list) {
            ret += productManager.toString(product);
        }
        return ret;
    }

    public String sortByDate() throws Exception {
        ArrayList<Product> list = productManager.returnProductList();
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