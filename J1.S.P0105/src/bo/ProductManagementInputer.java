package bo;

import entity.Product;
import entity.StoreKeeper;
import util.Validations;

import java.text.SimpleDateFormat;

public class ProductManagementInputer {
    public Product productInput() throws Exception {
        Product p = new Product();
        p.setId(Validations.getInt("Please enter id of product: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE));
        p.setName(Validations.getStringByRegex("Please enter name of a poduct: ", "Please enter character only", "[a-zA-Z\s]+"));
        p.setLocation(Validations.getStringByRegex("Please enter location of the seller: ", "Please enter character and number only", "[a-zA-Z0-9\s]+"));
        p.setPrice(Validations.getInt("Please enter price of a poduct: ", "Please enter number only", "Please enter positive numbe", 0, Integer.MAX_VALUE));
        p.setExpireDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter expire date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
        do {
            p.setProduceDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter manufacturre date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
            if (p.getProduceDate().compareTo(p.getExpireDate()) <= 0) break;
            else System.err.println("The product date must before the expire date");
        } while (true);
        p.setCategory(Validations.getStringByRegex("Please enter category for the product: ", "Please enter character only", "[a-zA-X\s]+"));
        p.setStoreKeeper(storeKeeperInput());
        do {
            p.setReceiptDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter reecept date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
            if (p.getReceiptDate().compareTo(p.getProduceDate()) >= 0 && p.getReceiptDate().compareTo(p.getExpireDate()) <= 0)
                break;
            else System.err.println("The receipt date must after produce date and before expire date");
        } while (true);
        return p;
    }

    public StoreKeeper storeKeeperInput() {
        StoreKeeper s = new StoreKeeper();
        s.setName(Validations.getStringByRegex("Please enter name of the seller: ", "Please enter character only", "[a-zA-X\s]+"));
        return s;
    }
}
