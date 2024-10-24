package TH.Tuan8.baiTap3;

import java.util.Scanner;

public class bao extends taiLieu {
    private String ngayPhatHanh;

    public bao() {
        super();
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày phát hành (dd/MM/yyyy): ");
        this.ngayPhatHanh = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Ngày phát hành: " + ngayPhatHanh);
    }
}

