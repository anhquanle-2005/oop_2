

import java.util.*;


// Tạo lớp baiTap2
public class SinhVien {
    // Thuộc tính
    private String maSinhVien;
    private String ten;
    private String ngaySinh;
    private double diemTrungBinh;

    // Constructor mặc định
    public SinhVien() {
    }

    // Constructor có tham số
    public SinhVien(String maSinhVien, String ten, String ngaySinh, double diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    // Phương thức nhập thông tin sinh viên
    public void Nhap(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        maSinhVien = scanner.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        ten = scanner.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        ngaySinh = scanner.nextLine();

        // Kiểm tra điểm trung bình
        while (true) {
            System.out.print("Nhập điểm trung bình (0-10): ");
            diemTrungBinh = scanner.nextDouble();
            if (diemTrungBinh >= 0 && diemTrungBinh <= 10) {
                break;  // Thoát khỏi vòng lặp nếu nhập hợp lệ
            } else {
                System.out.println("Điểm trung bình phải nằm trong khoảng từ 0 đến 10. Vui lòng nhập lại.");
            }
        }
        scanner.nextLine();  // Để bỏ qua dòng new line sau khi nhập số
    }

    // Phương thức in thông tin sinh viên
    public void Xuat() {
        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Họ và Tên: " + ten);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
    }

    // Getter để lấy điểm trung bình mặc dù đang ở ngoài lớp điểm trung bình
    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }
}
