package entity;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String location;
    private int price;
    private Date expireDate;
    private Date produceDate;
    private String category;
    private StoreKeeper storeKeeper;
    private Date receiptDate;

    public Product() {

    }

    public Product(int id, String name, String location, int price, Date expireDate, Date produceDate, String category, StoreKeeper storeKeeper, Date receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expireDate = expireDate;
        this.produceDate = produceDate;
        this.category = category;
        this.storeKeeper = storeKeeper;
        this.receiptDate = receiptDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public StoreKeeper getStoreKeeper() {
        return storeKeeper;
    }

    public void setStoreKeeper(StoreKeeper storeKeeper) {
        this.storeKeeper = storeKeeper;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

//    @Override
//    public String toString() {
//        return (id + " | " + name + " | " + location + " | " + price + " | " + expireDate + " | " + produceDate + " | " + category + " | " + storeKeeper.getName() + " | " + receiptDate + "\n");
//    }
}
