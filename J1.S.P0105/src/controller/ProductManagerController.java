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

    private int checkStoreKeeper(StoreKeeper storeKeeper) throws Exception {
        try {
            storeKeeperManager.searchByStoreKeeper(storeKeeper);
            return 1;
        } catch (Exception e) {
            storeKeeperManager.addStoreKeeper(storeKeeper);
            return -1;
        }
    }

    public StoreKeeper addStoreKeeper() throws Exception {
        storeKeeper = input.storeKeeperInput();
        int i = checkStoreKeeper(storeKeeper);
        if (i == 1) throw new Exception("This StoreKeeper is already exist");
        else return storeKeeper;
    }

    public Product addProduct() throws Exception {
        product = input.productInput();
        checkStoreKeeper(product.getStoreKeeper());
        int i = productManager.searchById(product.getId());
        if (i == -1) return productManager.addProduct(product);
        else throw new Exception("Duplicate ID");
    }

    public Product updateProduct(int id) throws Exception {
        try {
            product = productManager.getProductById(id);
            storeKeeper = new StoreKeeper();
            product = input.productInput();
            return productManager.updateProduct(id, product);
        } catch (Exception e) {
            throw new Exception("This product not exist");
        }
    }

    public String searchByChoice(int choice) throws Exception {
        ArrayList<Product> list;
        String ret = "";
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
                receiptDate = new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter receipt date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy"));
                break;
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