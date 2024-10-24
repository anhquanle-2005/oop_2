package TH.Tuan8.baiTap2;

import java.util.Scanner;

public class nhanVienVanPhong extends nhanVien {
    private double heSoLuong;

    public nhanVienVanPhong() {
        super();
    }

    // Ghi đè phương thức nhập thông tin để nhập thêm hệ số lương
    @Override
    public void nhapThongTin() {
        super.nhapThongTin(); // Gọi phương thức nhập thông tin chung từ lớp cha
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hệ số lương: ");
        this.heSoLuong = scanner.nextDouble();
    }

    // Ghi đè phương thức tính lương (lương = lương cơ bản * hệ số lương)
    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }
}
