package bo;

import entity.Product;
import entity.StoreKeeper;
import util.Validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProductManagementInputer {
    public void productInput(Product p, StoreKeeper s) throws Exception {
        p.setId(Validations.getInt("Please enter id of product: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE));
        p.setName(Validations.getStringByRegex("Please enter name of a poduct: ", "Please enter character only", "[a-zA-Z\s]+"));
        p.setLocation(Validations.getStringByRegex("Please enter location of the seller: ", "Please enter character and number only", "[a-zA-Z0-9\s]+"));
        p.setPrice(Validations.getInt("Please enter price of a poduct: ", "Please enter number only", "Please enter positive numbe", 0, Integer.MAX_VALUE));
        p.setExpireDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter expire date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
        p.setProduceDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter manufacturre date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
        p.setCategory(Validations.getStringByRegex("Please enter category for the product: ", "Please enter character only", "[a-zA-X\s]+"));
        p.setStoreKeeper(storeKeeperInput(s));
        p.setReceiptDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter reecept date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
    }

    public StoreKeeper storeKeeperInput(StoreKeeper s) throws Exception {
        StoreKeeperManager manager = new StoreKeeperManager();
        while (true) {
            try {
                s.setName(Validations.getStringByRegex("Please enter name of the seller: ", "Please enter character only", "[a-zA-X\s]+"));
                manager.searchByStoreKeeper(s);
            } catch (Exception e) {
                manager.addStoreKeeper(s);
                break;
            }
        }
    }
}
