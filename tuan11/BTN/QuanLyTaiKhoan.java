package TH.BTN;

import java.util.List;
import java.util.Scanner;

public class QuanLyTaiKhoan {

    private static FileManager fileManager = new FileManager("taikhoan.txt");

    public static void dangKyTaiKhoan(String tenTaiKhoan, double soDu, String matKhau) {
        TaiKhoanKhachHang taiKhoan = new TaiKhoanKhachHang(tenTaiKhoan, soDu, matKhau);
        fileManager.writeAccount(taiKhoan);
    }

    public static TaiKhoanKhachHang dangNhap(String tenTaiKhoan, String matKhau) {
        List<TaiKhoanKhachHang> accounts = fileManager.readAccounts();
        for (TaiKhoanKhachHang taiKhoan : accounts) {
            if (taiKhoan.getTenTaiKhoan().equals(tenTaiKhoan)) {
                // Xóa hoặc bình luận dòng sau
                // System.out.println("So sánh mật khẩu: " + taiKhoan.getMatKhau() + " với " + matKhau);
                if (taiKhoan.getMatKhau().equals(matKhau)) {
                    return taiKhoan; // Đăng nhập thành công
                } else {
                    System.out.println("Mật khẩu không đúng.");
                    return null; // Mật khẩu sai
                }
            }
        }
        System.out.println("Không tồn tại tài khoản."); // Tài khoản không tồn tại
        return null; // Tài khoản không tìm thấy
    }
    public static void xoaTaiKhoan(String tenTaiKhoan) {
        List<TaiKhoanKhachHang> accounts = fileManager.readAccounts();
        boolean found = false;
        for (TaiKhoanKhachHang taiKhoan : accounts) {
            if (taiKhoan.getTenTaiKhoan().equals(tenTaiKhoan)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tồn tại tài khoản: " + tenTaiKhoan); // Tài khoản không tồn tại
            return;
        }
        fileManager.deleteAccount(tenTaiKhoan);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("----------------------");
                System.out.println("1. Đăng ký tài khoản");
                System.out.println("2. Đăng nhập");
                System.out.println("3. Xóa tài khoản");
                System.out.println("4. Thoát");
                System.out.println("------------------------");
                System.out.print("Chọn tùy chọn: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên tài khoản: ");
                        String tenTaiKhoan = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        String matKhau = scanner.nextLine();
                        System.out.print("Nhập số tiền nạp: ");
                        double soDu = scanner.nextDouble();
                        dangKyTaiKhoan(tenTaiKhoan, soDu, matKhau);
                        break;

                    case 2:
                        System.out.print("Nhập tên tài khoản để đăng nhập: ");
                        String taiKhoanDangNhap = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        String matKhauDangNhap = scanner.nextLine();
                        TaiKhoanKhachHang taiKhoan = dangNhap(taiKhoanDangNhap, matKhauDangNhap);
                        if (taiKhoan != null) {
                            System.out.println("Đăng nhập thành công: " + taiKhoan.getTenTaiKhoan());
                            taiKhoan.xemSoGioChoi();
                            
                        }
                        break;

                    case 3:
                        System.out.print("Nhập tên tài khoản để xóa: ");
                        String taiKhoanXoa = scanner.nextLine();
                        xoaTaiKhoan(taiKhoanXoa);
                        break;

                    case 4:
                        System.out.println("Thoát chương trình.");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        } finally {
            scanner.close(); // Đảm bảo scanner được đóng
        }
    }
}