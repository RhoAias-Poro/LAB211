package bo;

import entity.Product;
import entity.StoreKeeper;

import java.util.ArrayList;
import java.util.Date;

public class ProductManager {
    ArrayList<Product> listProducts = new ArrayList<Product>();

    public Product addProduct(Product product) {
        listProducts.add(product);
        return product;
    }

    private int searchById(int id) {
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
        int index = searchById(id);
        if (index != -1) return listProducts.set(index, s);
        throw new Exception("Product not found");
    }

    public Product getProductById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) return listProducts.get(index);
        throw new Exception("ID not found");
    }

    public Product deleteProduct(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listProducts.remove(index);
        }
        throw new Exception("Product doesn't exist");
    }

    public ArrayList<Product> getProducts(String name, String category, StoreKeeper s, Date receiptDate) throws Exception {
        ArrayList<Product> ret = new ArrayList<Product>();
        for (Product p : listProducts) {
            if (name != null && p.getName().toLowerCase().contains(name.toLowerCase())) ret.add(p);
            if (category != null && p.getCategory().toLowerCase().contains(category.toLowerCase())) ret.add(p);
            if (s.getName() != null && p.getName().toLowerCase().contains(s.getName().toLowerCase())) ret.add(p);
            if (p.getReceiptDate().equals(receiptDate)) ret.add(p);
        }
        return ret;
    }
}
