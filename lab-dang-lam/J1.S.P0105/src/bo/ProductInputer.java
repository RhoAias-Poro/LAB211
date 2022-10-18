package bo;

import entity.Product;
import entity.StoreKeeper;
import util.Validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductInputer {
    public void productInput(Product p) throws ParseException {
        Date format = new SimpleDateFormat("dd/MM/yyyy").get2DigitYearStart();
        StoreKeeper storeKeeper = new StoreKeeper();
        p.setId(Validations.getInt("Please enter id of product: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE));
        p.setName(Validations.getStringByRegex("Please enter name of a poduct: ", "Please enter character only", "[a-zA-Z\s]+"));
        p.setLocation(Validations.getStringByRegex("Please enter location of the seller: ", "Please enter character and number only", "[a-zA-Z0-9\s]+"));
        p.setPrice(Validations.getInt("Please enter price of a poduct: ", "Please enter number only", "Please enter positive numbe", 0, Integer.MAX_VALUE));
        p.setExpireDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter expire date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
        p.setProduceDate(new SimpleDateFormat("dd/MM/yyyy").parse(Validations.getDob("Please enter manufacturre date of product (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy")));
        p.setCategory(Validations.getStringByRegex("Please enter category for the product: ", "Please enter character only", "[a-zA-X\s]+"));
        storeKeeper.setName(Validations.getStringByRegex("Please enter name of the seller: ", "Please enter character only", "[a-zA-X\s]+"));
        p.setStoreKeeper(storeKeeper.setName(Validations.getStringByRegex("Please enter name of the seller: ", "Please enter character only", "[a-zA-X\s]+")));
    }
}
