package tuan11.BTN;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameAction gameAction = new GameAction();
        TaiKhoan taiKhoan = new TaiKhoan("user01", 1000);

        while (true) {
            System.out.println("\n===== Quản lý game =====");
            System.out.println("1. Thêm game");
            System.out.println("2. Hiển thị danh sách game");
            System.out.println("3. Xóa game");
            System.out.println("4. Cập nhật game");
            System.out.println("5. Nạp tiền vào tài khoản");
            System.out.println("6. Xem thông tin tài khoản");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập ID game:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Nhập tên game:");
                    String name = scanner.nextLine();
                    System.out.println("Nhập thể loại game:");
                    String genre = scanner.nextLine();
                    System.out.println("Nhập giá mỗi giờ:");
                    double price = scanner.nextDouble();
                    gameAction.addGame(new Game(id, name, genre, price));
                    break;

                case 2:
                    gameAction.displayGames();
                    break;

                case 3:
                    System.out.println("Nhập ID game cần xóa:");
                    int idToDelete = scanner.nextInt();
                    gameAction.deleteGame(idToDelete);
                    break;

                case 4:
                    System.out.println("Nhập ID game cần cập nhật:");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Nhập tên game mới:");
                    String newName = scanner.nextLine();
                    System.out.println("Nhập thể loại game mới:");
                    String newGenre = scanner.nextLine();
                    System.out.println("Nhập giá mỗi giờ mới:");
                    double newPrice = scanner.nextDouble();
                    gameAction.updateGame(idToUpdate, newName, newGenre, newPrice);
                    break;
                case 5:
                    System.out.println("Nhập số tiền cần nạp:");
                    double amount = scanner.nextDouble();
                    taiKhoan.napTien(amount);
                    break;
                case 6:
                    System.out.println(taiKhoan);
                    break;
                case 7:
                    System.out.println("Thoát khỏi chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
