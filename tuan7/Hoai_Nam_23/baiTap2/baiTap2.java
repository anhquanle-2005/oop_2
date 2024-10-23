package TH.Tuan7.baiTap2;
import java.util.*;
public class baiTap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        // Hỏi người dùng số lượng sinh viên cần nhập
        System.out.print("Nhập số lượng sinh viên cần nhập: ");
        int soLuongSinhVien = scanner.nextInt();
        // Tạo mảng SinhVien để lưu trữ danh sách sinh viên
        SinhVien[] danhSachSinhVien = new SinhVien[soLuongSinhVien];

        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            danhSachSinhVien[i] = new SinhVien();  // Tạo một đối tượng SinhVien mới
            danhSachSinhVien[i].Nhap();  
        }

        // Xuất thông tin của tất cả các sinh viên
        System.out.println("\nDanh sách sinh viên đã nhập:");
        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println("\nThông tin sinh viên thứ " + (i + 1) + ":");
            danhSachSinhVien[i].Xuat();  
        }
        scanner.close();
    }
}
    
