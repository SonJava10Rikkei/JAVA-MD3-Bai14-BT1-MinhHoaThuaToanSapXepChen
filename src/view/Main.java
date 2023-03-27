package view;

import config.Config;

public class Main {
    public Main() {
        do {
            System.out.println("\"****************STUDENT MANAGE****************\");\n" +
                    "                 \"1. Hiển thị danh sách sản phẩm\"\n" +
                    "                 \"2. Thêm mới sản phẩm\"\n" +
                    "                 \"3. Xóa sản phẩm theo Id\"\n" +
                    "                 \"4. Chỉnh sửa sản phẩm\"\n" +
                    "                 \"5. Tìm kiếm theo tên sản phẩm\"\n" +
                    "                 \"6. Sắp sếp théo giá tăng dần của sản phẩm\"\n" +

                    "                 \"0. Thoát chương trình\"\n" +
                    "\"**********************************************\"\n" +
                    "                 Mời chọn: ");

            int chooseMenu;
            while (true) {
                try {
                    chooseMenu = Integer.parseInt(Config.scanner().nextLine());
                    break;
                } catch (NumberFormatException Err) {
                    System.err.println("Hãy nhập số mà bạn muốn lựa chọn: (0-6");
                }
            }
            switch (chooseMenu) {
                case 1:
                    new ProductView().showTabelProduct();
                    break;
                case 2:
                    new ProductView().createTabelProduct();
                    break;
                case 3:
                    new ProductView().deleteById();
                    break;
                case 4:
                    new ProductView().editProduct();
                    break;
                case 5:
                    new ProductView().findProductByName();
                    break;
                case 6:
                    new ProductView().sortProductByPrice();
                    break;
                case 0:
                    System.exit(0);
                    System.err.println("Đã thoắt chương trình ! ");
                    break;
                default:
                    System.out.println("Hãy nhập lại lựa chọn của bạn (1-5) ");
            }
        } while (true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
