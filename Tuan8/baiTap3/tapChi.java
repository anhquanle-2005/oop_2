package TH.Tuan8.baiTap3;

import java.util.Scanner;

public class tapChi extends taiLieu {
    private int soPhatHanh;

    public tapChi() {
        super();
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phát hành: ");
        this.soPhatHanh = scanner.nextInt();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Số phát hành: " + soPhatHanh);
    }
}

