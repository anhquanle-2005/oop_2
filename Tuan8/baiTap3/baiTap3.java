package TH.Tuan8.baiTap3;

import java.util.Scanner;

public class baiTap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng tài liệu: ");
        int soLuongTaiLieu = scanner.nextInt();
        scanner.nextLine();

        taiLieu[] danhSachTaiLieu = new taiLieu[soLuongTaiLieu];

        for (int i = 0; i < soLuongTaiLieu; i++) {
            System.out.println("Tài liệu thứ " + (i + 1) + ":");
            System.out.println("Chọn loại tài liệu (1 - Sách, 2 - Tạp chí, 3 - Báo): ");
            int loaiTaiLieu = scanner.nextInt();
            scanner.nextLine();

            switch (loaiTaiLieu) {
                case 1:
                    danhSachTaiLieu[i] = new sach();
                    break;
                case 2:
                    danhSachTaiLieu[i] = new tapChi();
                    break;
                case 3:
                    danhSachTaiLieu[i] = new bao();
                    break;
                default:
                    System.out.println("Loại không hợp lệ. Mặc định là Sách.");
                    danhSachTaiLieu[i] = new sach();
                    break;
            }

            danhSachTaiLieu[i].nhap();
        }

        System.out.println("\nThông tin tài liệu đã nhập:");
        for (taiLieu tl : danhSachTaiLieu) {
            tl.xuat();
            System.out.println();
        }
    }
}
