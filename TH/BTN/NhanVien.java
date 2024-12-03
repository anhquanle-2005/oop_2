package TH.BTN;

import java.util.*;

public class NhanVien {
    private FileManager fileManager;

    public NhanVien(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
    
        do {
            System.out.println("-----------------------------");
            System.out.println("Chọn chức năng cho nhân viên:");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Xóa khách hàng");
            System.out.println("3. Thoát về menu chính");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng còn lại
    
            switch (choice) {
                case 1:
                    fileManager.themKhachHang();
                    break;
                case 2:
                    System.out.print("Nhập mã khách hàng cần xóa: ");
                    String maKH = scanner.nextLine();
                    fileManager.xoaKhachHang(maKH);
                    break;
                case 3:
                    System.out.println("Đang thoát về menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 3);
    }
}