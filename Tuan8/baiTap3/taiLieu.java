package TH.Tuan8.baiTap3;

import java.util.Scanner;

public class taiLieu {
    protected String maTaiLieu;
    protected String tenTaiLieu;
    protected int namXuatBan;

    // Constructor mặc định
    public taiLieu() {
    }

    // Phương thức nhập thông tin chung
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tài liệu: ");
        this.maTaiLieu = scanner.nextLine();
        System.out.print("Nhập tên tài liệu: ");
        this.tenTaiLieu = scanner.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        this.namXuatBan = scanner.nextInt();
    }

    // Phương thức hiển thị thông tin
    public void xuat() {
        System.out.println("Mã tài liệu: " + maTaiLieu);
        System.out.println("Tên tài liệu: " + tenTaiLieu);
        System.out.println("Năm xuất bản: " + namXuatBan);
    }
}

