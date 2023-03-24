package view;

import config.Config;
import controller.ProductController;
import model.Product;

import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.showListProduct();

    public void showTabelProduct() {
        System.out.println("****************PRODUCT MANAGE****************");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(" " + productList.get(i));
        }
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) ;
        new Main();
    }

    public void createTabelProduct() {

        int productId;
        if (productList.isEmpty()) {
            productId = 1;
        } else {
            productId = new ProductView().findMaxId() + 1;
        }
        System.out.println("Nhập tên sản phẩm: ");
        String newName = Config.scanner().nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double newPrice = Config.scanner().nextDouble();
        Product product = new Product(productId, newName, newPrice);
        productController.createProduct(product);
        System.out.println("Đã thêm sản phẩm! ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) ;
        new Main();

    }

    public int findMaxId() {
        int maxId = productList.get(0).getId();
        for (int i = 0; i < productList.size(); i++) {
            if (maxId < productList.get(i).getId()) {
                maxId = productList.get(i).getId();
            }
        }
        return maxId;
    }
}
