
import java.util.*;

public class bai2 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner SL = new Scanner(System.in);

        // Nhập số lượng sinh viên
        System.out.print("Nhập số lượng sinh viên: ");
        int soLuongSinhVien = SL.nextInt();
        SL.nextLine();  // Để bỏ qua dòng new line sau khi nhập số

        // Tạo mảng để lưu danh sách sinh viên
        SinhVien[] danhSachSinhVien = new SinhVien[soLuongSinhVien];

        // Nhập thông tin cho từng sinh viên
        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1) + ":");
            danhSachSinhVien[i] = new SinhVien();  // Tạo một đối tượng baiTap2 mới
            danhSachSinhVien[i].Nhap(SL);
        }

        // Sắp xếp danh sách sinh viên theo điểm trung bình giảm dần
        Arrays.sort(danhSachSinhVien, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                // So sánh điểm trung bình theo thứ tự giảm dần
                return Double.compare(sv2.getDiemTrungBinh(), sv1.getDiemTrungBinh());
            }
        });

        // In thông tin danh sách sinh viên sau khi sắp xếp
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo điểm trung bình giảm dần:");
        for (SinhVien sv : danhSachSinhVien) {
            sv.Xuat();
            System.out.println();  
        }
    }
}
