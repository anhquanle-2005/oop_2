package TH.Tuan7.baiTap2;

import java.util.*;

public class SinhVien {
    // Các thuộc tính
    private String maSinhVien;
    private String ten;
    private String ngaySinh;
    private double diemTrungBinh;
    private String hocLuc;

    // Constructor mặc định
    public SinhVien() {
    }

    // Getter cho các thuộc tính
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    // Phương thức Nhap() để nhập thông tin sinh viên từ bàn phím
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        maSinhVien = scanner.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        ten = scanner.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        ngaySinh = scanner.nextLine();

        System.out.print("Nhập điểm trung bình: ");
        diemTrungBinh = scanner.nextDouble();

        xepLoai();
    }
    

    // Phương thức Xuat() để xuất thông tin sinh viên
    public void Xuat() {
        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Tên: " + ten);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
        System.out.println("Học lực: " + hocLuc);
    }

    // Phương thức xepLoai() để xếp loại học lực dựa trên điểm trung bình
    private void xepLoai() {
        if (diemTrungBinh >= 8.5) {
            this.hocLuc = "Giỏi";
        } else if (diemTrungBinh >= 7.0) {
            this.hocLuc = "Khá";
        } else if (diemTrungBinh >= 5.0) {
            this.hocLuc = "Trung Bình";
        } else {
            this.hocLuc = "Yếu";
        }
    }
}
