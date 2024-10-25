package TH.Tuan8.baiTap2;
import java.util.Scanner;

public class nhanVien {
    protected String maNhanVien;
    protected String tenNhanVien;
    protected double luongCoBan;

    // Constructor mặc định
    public nhanVien() {
    }

    // Phương thức nhập thông tin chung của nhân viên
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên: ");
        this.maNhanVien = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        this.tenNhanVien = scanner.nextLine();
        
        // Nhập lương cơ bản với điều kiện không âm
        do {
            System.out.print("Nhập lương cơ bản: ");
            this.luongCoBan = scanner.nextDouble();
            if (luongCoBan < 0) {
                System.out.println("Lương không được âm. Vui lòng nhập lại.");
            }
        } while (luongCoBan < 0);
    }

    // Phương thức tính lương (sẽ được ghi đè ở các lớp con)
    public double tinhLuong() {
        return luongCoBan;
    }

    // Phương thức hiển thị thông tin nhân viên
    public void hienThiThongTin() {
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Tên nhân viên: " + tenNhanVien);
        System.out.println("Lương: " + tinhLuong());
    }
}
