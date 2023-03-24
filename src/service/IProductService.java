package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> finAll();

    void save(Product product);

    Product findById(int id);

    void deleteById(int id);

}
