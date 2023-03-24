package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceIMP;

import java.util.List;

public class ProductController {
    IProductService productService = new ProductServiceIMP();

    public List<Product> showListProduct() {
        return productService.finAll();
    }

    public void createProduct(Product product) {
        productService.save(product);
    }
}
