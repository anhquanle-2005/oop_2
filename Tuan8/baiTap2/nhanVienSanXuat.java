package TH.Tuan8.baiTap2;

import java.util.Scanner;

public class nhanVienSanXuat extends nhanVien {
    private int soSanPham;

    public nhanVienSanXuat() {
        super();
    }

    // Ghi đè phương thức nhập thông tin để nhập thêm số sản phẩm
    @Override
    public void nhapThongTin() {
        super.nhapThongTin(); // Gọi phương thức nhập thông tin chung từ lớp cha
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số sản phẩm: ");
        this.soSanPham = scanner.nextInt();
    }

    // Ghi đè phương thức tính lương (lương = lương cơ bản + số sản phẩm * 5000)
    @Override
    public double tinhLuong() {
        return luongCoBan * soSanPham ;
    }
}

