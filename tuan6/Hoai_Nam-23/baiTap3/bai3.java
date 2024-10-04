

import java.util.*;

public class bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin tài khoản
        System.out.print("Nhập số tài khoản: ");
        String soTaiKhoan = scanner.nextLine();

        System.out.print("Nhập tên chủ tài khoản: ");
        String chuTaiKhoan = scanner.nextLine();

        System.out.print("Nhập số dư ban đầu: ");
        double soDu = scanner.nextDouble();

        // Tạo đối tượng tài khoản ngân hàng
        baiTap3 taiKhoan = new baiTap3(soTaiKhoan, chuTaiKhoan, soDu);

        // Hiển thị thông tin tài khoản
        System.out.println("\nThông tin tài khoản:");
        taiKhoan.inThongTinTaiKhoan();

        // Gửi tiền
        System.out.print("Nhập số tiền gửi: ");
        double soTienGui = scanner.nextDouble();
        taiKhoan.guiTien(soTienGui);

        // Rút tiền
        System.out.print("Nhập số tiền rút: ");
        double soTienRut = scanner.nextDouble();
        taiKhoan.rutTien(soTienRut);

        // Kiểm tra số dư
        System.out.println("Số dư hiện tại là: " + taiKhoan.kiemTraSoDu());

        // Đóng scanner để tránh rò rỉ bộ nhớ
        scanner.close();
    }
}
