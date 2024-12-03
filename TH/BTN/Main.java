package TH.BTN;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-----------------");
            System.out.println("Chọn vai trò:");
            System.out.println("1. Nhân viên");
            System.out.println("2. Khách hàng");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng còn lại

            switch (choice) {
                case 1:
                    NhanVien nhanVien = new NhanVien(fileManager);
                    nhanVien.menu();
                    break;
                case 2:
                    KhachHangBinhThuong khachHang = new KhachHangBinhThuong("", "", "", "", "", 0, 0);
                    khachHang.menu(fileManager);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 3);

        // Đóng scanner nếu không còn sử dụng
        scanner.close();
    }
}