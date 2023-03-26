package view;

import config.Config;
import controller.ProductController;
import model.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.showListProduct();

    public void showTabelProduct() {
        System.out.println("****************PRODUCT MANAGE****************");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(" " + productList.get(i));
        }
        System.out.println("Type enter or type any key to return to Menu");
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
        System.out.println("__Đã thêm sản phẩm__! ");
        System.out.println("Nhấn enter hoặc nhập bất kì ký tự nào để quay lại Menu");
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

    // 3,1 tìm kiếm sản phẩm
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return i;
            }
        }
        System.out.println("Không tìm thấy sản phẩm trong danh sách");
        return -1;
    }

    public void editProduct() {
        System.out.println("Nhập ID của sản phẩm bạn muốn chỉnh sửa: ");
        int id = Config.scanner().nextInt();
        int index = findIndexById(id);
        if (index != -1) {
            System.out.println("Nhập tên sản phẩm mới: ");
            String newName = Config.scanner().nextLine();
            System.out.println("Nhập giá sản phẩm mới: ");
            double newPrice = Config.scanner().nextDouble();
            productList.get(index).setName(newName);
            productList.get(index).setPrice(newPrice);
            System.out.println("__Đã cập nhật sản phẩm__! ");
            System.out.println("Nhấn enter hoặc nhập bất kì ký tự nào để quay lại Menu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) ;
            new Main();
        }
    }

    //     3.2 Xóa sản phẩm
    public void deleteById() {
        System.out.println("Nhập Id của sản phẩm bạn muốn xóa");
        int id = Config.scanner().nextInt();
        int index = findIndexById(id);
        if (index != -1) {
            productList.remove(index);
        }
        System.out.println("__Đã xóa sản phẩm__");
        System.out.println("Nhấn enter hoặc nhập bất kì ký tự nào để quay lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) ;
        new Main();
    }

    // 5 Tìm kiếm sản phẩm theo tên
    public void findProductByName() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = Config.scanner().nextLine();
        boolean found = false;
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với tên \"" + name + "\" trong danh sách.");
        }
    }

    // 6. Sắp xếp theo giá tăng dần và giảm dần đổi +-1
    public void sortProductByPrice() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() < p2.getPrice()) {
                    return -1; //1
                } else if (p1.getPrice() > p2.getPrice()) {
                    return 1; // -1
                } else {
                    return 0;
                }
            }
        });

        System.out.println("Danh sách sản phẩm theo giá tăng dần: ");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("Nhấn enter hoặc nhập bất kì ký tự nào để quay lại Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) ;
        new Main();

    }
}
