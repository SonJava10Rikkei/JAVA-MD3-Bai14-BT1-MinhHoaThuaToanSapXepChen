package view;

import config.Config;

public class Main {
    public Main() {
        do {
            System.out.println("\"****************STUDENT MANAGE****************\");\n" +
                    "                 \"1. Show List student\"\n" +
                    "                 \"2. Create Student\"\n" +
                    "                 \"3. Update Student\"\n" +
                    "                 \"4. Delete Student\"\n" +
                    "                 \"5. Sort Student By Name\"\n" +
                    "                 \"0. Thoát chương trình\"\n" +
                    "\"**********************************************\"\n" +
                    "                 Mời chọn: ");

            int chooseMenu;
            while (true) {
                try {
                    chooseMenu = Integer.parseInt(Config.scanner().nextLine());
                    break;
                } catch (NumberFormatException Err) {
                    System.out.println("Hãy nhập số bạn muốn lựa chọn: (0-6");
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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
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
