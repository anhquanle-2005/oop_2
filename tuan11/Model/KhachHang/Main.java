package KhachHang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DSKhachHang ds = new DSKhachHang();
        ds.docFile();
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("-----------------");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Hien thi danh sach khach hang");
            System.out.println("4. Tim thong tin chi tiet khach hang");
            System.out.println("5. Dang nhap");
            System.out.println("6. Thoat");
            System.out.print("Nhap su lua chon cua ban: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    ds.themKhach();
                    break;
                case "2":
                    String ma;
                    System.out.println("Nhap vao ma khach hang ban muon xoa:");
                    ma=scanner.nextLine();
                    ds.xoaKhachHang(ma);
                    break;
                case "3":
                    ds.hienThiDSKH();
                    break;
                case "4":
                    String khach;
                    System.out.println("Nhap vao ma khach hang muon tim");
                    khach=scanner.nextLine();
                    KhachHang k1=ds.timKhachHang(khach);
                    if(k1!=null)
                    {
                        System.out.println("Thong tin cua khach hang");
                        System.out.println("Ten khach hang: "+k1.getTenKH());
                        System.out.println("Ma khach hang: "+k1.getMaKH());
                        System.out.println("Loai khach hang: "+k1.getLoaiKhachHang());
                        System.out.println("Thoi gian choi: "+k1.soGioChoi);
                        System.out.println("So dien thoai cua khach hang: "+k1.getSdt());
                    }
                    break;
                case"5":
                    // KhachHang kh= ds.dangNhap();
                    // if(kh!=null)
                    // {
                    //     System.out.println("Dang nhap thanh cong");
                    //     String chucNang;
                    //     do {
                    //         System.out.println("1. Doi mat khau");
                    //         System.out.println("2. Nap tien vao tai khoan");
                    //         System.out.println("3. Thanh toan");
                    //         System.out.println("4. Danh sach game");
                    //         System.out.println("5. Ban co muon nang tai khoan len VIP");
                    //         System.out.println("6. Thoat");
                    //         chucNang=scanner.nextLine();
                    //         switch (chucNang) {
                    //             case "1":
                                    
                    //                 break;
                    //             case "2":
                    //                 break;
                    //             case "3":
                    //                 break;
                    //             case "4":
                    //                 break;
                    //             case "5":
                    //                 break;
                    //             case"6":
                    //                 break;
                    //             default:
                    //                 System.out.println("Lua chon khong hop le");
                    //                 break;
                    //         }
                    //     } while (!chucNang.equals("6"));
                    // }
                    // break;
                case"6":
                    System.out.println("Ban da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (!choice.equals("6"));
    }
}