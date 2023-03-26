package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMP implements IProductService {
    public static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Quan Bo", 500000));
        productList.add(new Product(2, "Ao So Mi", 250000));
        productList.add(new Product(3, "Giay Da", 450000));
        productList.add(new Product(4, "That Lung", 300000));
    }

    @Override
    public List<Product> finAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }


    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
    }


}
