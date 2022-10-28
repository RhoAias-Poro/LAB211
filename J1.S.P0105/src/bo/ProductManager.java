package bo;

import entity.Product;
import entity.StoreKeeper;

import java.util.ArrayList;
import java.util.Date;

public class ProductManager {
    private ArrayList<Product> listProducts;

    public ProductManager() {
        listProducts = new ArrayList<>();
    }

    public boolean addProduct(Product product) throws Exception {
        if (product == null) {
            throw new Exception("Product cannot be null");
        }
        int i = searchById(product.getId());
        if (i == -1) {
            return listProducts.add(product);
        }
        throw new Exception("Duplicate ID");
    }

    public int searchById(int id) {
        int index = 0;
        for (Product product : listProducts) {
            if (product.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public Product updateProduct(int id, Product s) throws Exception {
        if (s == null) {
            throw new Exception("Product cannot be null");
        }
        int index = searchById(id);
        if (index != -1) {
            return listProducts.set(index, s);
        }
        throw new Exception("Product not found");
    }

    public Product getProductById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listProducts.get(index);
        }
        return null;
    }

//    public Product deleteProduct(int id) throws Exception {
//        int index = searchById(id);
//        if (index != -1) {
//            return listProducts.remove(index);
//        }
//        throw new Exception("Product doesn't exist");
//    }

    public ArrayList<Product> getProducts(String name, String category, StoreKeeper s, Date receiptDate) throws Exception {
        ArrayList<Product> ret = new ArrayList<Product>();
        for (Product p : listProducts) {
            if (name != null && p.getName().toLowerCase().contains(name.toLowerCase())) {
                ret.add(p);
            }
            if (category != null && p.getCategory().toLowerCase().contains(category.toLowerCase())) {
                ret.add(p);
            }
            if (s.getName() != null && p.getStoreKeeper().getName().toLowerCase().contains(s.getName().toLowerCase())) {
                ret.add(p);
            }
            if (p.getReceiptDate().equals(receiptDate)) {
                ret.add(p);
            }
        }
        if (ret.isEmpty()) {
            throw new Exception("No product can be found");
        }
        return ret;
    }

    public ArrayList<Product> getListProduct() throws Exception {
        if (listProducts.isEmpty()) {
            throw new Exception("The product list is empty");
        }
        ArrayList<Product> clone = new ArrayList<Product>(listProducts.size());
        for (Product s : listProducts) {
            clone.add(s);
        }
        return clone;
    }

    public String toString(Product p) throws Exception {
        if (p == null) {
            throw new Exception("Product cannot be null");
        }
        return (p.getId() + " | " + p.getName() + " | " + p.getLocation() + " | " + p.getPrice() + " | " + p.getExpireDate() + " | " + p.getProduceDate() + " | " + p.getCategory() + " | " + p.getStoreKeeper().getName() + " | " + p.getReceiptDate() + "\n");
    }
}
