package TH.BTN;

import java.util.*;

public class KhachHangBinhThuong extends KhachHang {

    public KhachHangBinhThuong(String maTK, String matKhau, String tenTaiKhoan, String tenKH, String sdt, double soTien, int diemThuong) {
        super(maTK, matKhau, tenTaiKhoan, tenKH, sdt, soTien, diemThuong);
    }

    @Override
    public void menu(FileManager fileManager) {
        System.out.println("Menu khách hàng bình thường");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----------------------------------");
            System.out.println("Chọn chức năng của Khách hàng:");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Nạp tiền");
            System.out.println("3. Chơi game");
            System.out.println("4. Đăng xuất");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng còn lại

            switch (choice) {
                case 1:
                    dangNhap(fileManager);
                    break;
                case 2:
                    System.out.print("Nhập số tiền muốn nạp: ");
                    double soTienNap = scanner.nextDouble();
                    this.napTien(soTienNap);
                    break;
                case 3:
                    choiGame();
                    break;
                case 4:
                    dangXuat(fileManager);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);
    }

    @Override
    protected boolean isVIP() {
        return false; // Khách hàng bình thường không phải là VIP
    }

    private void dangNhap(FileManager fileManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tài khoản: "); // Sử dụng tên tài khoản
        String tenTaiKhoan = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        fileManager.dangNhap(tenTaiKhoan, password);
    }

    private void choiGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số giờ bạn muốn chơi: ");
        int gioChoi = scanner.nextInt();
        System.out.print("Nhập số phút bạn muốn chơi: ");
        int phutChoi = scanner.nextInt();

        if (gioChoi < 0 || phutChoi < 0) {
            System.out.println("Số giờ và phút chơi không hợp lệ.");
            return;
        }

        double chiPhi = (gioChoi + phutChoi / 60.0) * 10;
        if (this.soTien >= chiPhi) {
            this.soTien -= chiPhi;
            this.themThoiGianChoi(gioChoi, phutChoi);
            System.out.println("Bạn đã chơi " + gioChoi + " giờ và " + phutChoi + " phút. Tổng thời gian chơi hiện tại: " + this.getThoiGianChoi());
            System.out.println("Số tiền còn lại: " + this.soTien);
        } else {
            System.out.println("Bạn không đủ tiền để chơi " + gioChoi + " giờ và " + phutChoi + " phút.");
        }
    }
}