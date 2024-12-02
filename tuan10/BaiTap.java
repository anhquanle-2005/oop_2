package tuan10;

import java.io.File;
import java.util.Scanner;

public class BaiTap {
    static Scanner sc = new Scanner(System.in);
    static BankServer ds = new BankServer();
    public static void main(String[] args) {
        int buoc = 0;
        do {
            // File f= new File("D:\\OOP\\thongTinTaiKhoan.txt");
            // ds.DocThongTin(f);
            System.out.println("Chon yeu cau cua ban");
            System.out.println("Nhap 1: Dang ky tai khoan");
            System.out.println("Nhap 2: Dang nhap tai khoan");
            System.out.println("Nhap 0: De thoat");
            buoc = sc.nextInt();
            sc.nextLine();  // Đọc bỏ dòng thừa sau khi nhập số
            switch (buoc) {
                case 1:
                    TaiKhoan tk = new TaiKhoanTT();
                    tk.Nhap();
                    tk.setSoDu(0.00);
                    ds.ThemTaiKhoan(tk);
                    ds.ghiThongTinTaiKhoan(new File("D:\\OOP\\thongTinTaiKhoan.txt"));
                    break;
                case 2:
                    TaiKhoan taiKhoan = ds.dangNhapVoiKiemTra();
                    if (taiKhoan != null) {
                        System.out.println("Dang nhap thanh cong!");
                        int luaChon;
                        do {
                            taiKhoan.Xuat();
                            System.out.println("Chon chuc nang:");
                            System.out.println("1. Doi mat khau");
                            System.out.println("2. Rut tien");
                            System.out.println("3. Chuyen tien");
                            System.out.println("4. Nap tien vao tai khoan");
                            System.out.println("5. Ban co muon mo tai khoan tiet kiem khong");
                            System.out.println("6. Xoa tai khoan");
                            System.out.println("0. Thoat");
                            luaChon = sc.nextInt();
                            sc.nextLine();  // Đọc bỏ dòng thừa sau khi nhập số
                            switch (luaChon) {
                                case 1:
                                    taiKhoan.doiMatKhau();
                                    ds.capNhatThongTinTaiKhoan(taiKhoan);
                                    break;
                                case 2:
                                    taiKhoan.rutTien();
                                    ds.capNhatThongTinTaiKhoan(taiKhoan);
                                    break;
                                case 3:
                                    System.out.println("Nhap so tai khoan nhan: ");
                                    String soTaiKhoanNhan = sc.nextLine();
                                    TaiKhoan tkNhan = ds.timTaiKhoan(soTaiKhoanNhan);
                                    if (tkNhan != null) {
                                        taiKhoan.chuyenTien(tkNhan);
                                        ds.capNhatThongTinTaiKhoan(taiKhoan);
                                        ds.capNhatThongTinTaiKhoan(tkNhan);
                                    } else {
                                        System.out.println("Tai khoan nhan khong ton tai.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("So tien ban muon nap vao: ");
                                    double soTienNap = sc.nextDouble();
                                    sc.nextLine();
                                    taiKhoan.napTien(soTienNap);
                                    ds.capNhatThongTinTaiKhoan(taiKhoan);
                                    break;
                                case 5:
                                    System.out.println("Ban co muon mo tai khoan tiet kiem (1: Co | 0: Khong): ");
                                    int x = sc.nextInt();
                                    if (x == 1) {
                                        System.out.println("Nhap so tien ban muon gui tiet kiem: ");
                                        double soTienGui = sc.nextDouble();
                                        if (soTienGui >= 100000 && soTienGui <= taiKhoan.getSoDu()) {
                                            TaiKhoanTK ttk = new TaiKhoanTK();
                                            ds.ThemTaiKhoan(ttk);
                                            taiKhoan.setSoDu(taiKhoan.getSoDu() - soTienGui);
                                            ttk.napTien(soTienGui);
                                            ds.capNhatThongTinTaiKhoan(ttk);
                                            System.out.println("So tien trong tai khoan tiet kiem: " + ttk.getTienTK());
                                            taiKhoan.setSoDu(taiKhoan.getSoDu() + ttk.getTienTK());
                                            ds.capNhatThongTinTaiKhoan(taiKhoan);
                                        } else 
                                            System.out.println("So tien khong hop le");   
                                    }
                                    break;
                                case 6:
                                    System.out.println("Nhap so dien thoai: ");
                                    int soDienThoai = sc.nextInt(); // Nhập số điện thoại dưới dạng int
                                    sc.nextLine(); // Đọc bỏ dòng thừa
                                    System.out.println("Nhap CCCD: ");
                                    String cccd = sc.nextLine();
                                    System.out.println("Nhap ma PIN: ");
                                    int maPin = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Nhap mat khau: ");
                                    String mk= sc.nextLine();
                                    System.out.println("Nhap email: ");
                                    String email = sc.nextLine();
                                    boolean ketQuaXoa = ds.xoaTaiKhoan(taiKhoan, soDienThoai, cccd, maPin, mk, email);
                                    
                                    if (ketQuaXoa) {
                                        System.out.println("Tai khoan da duoc xoa thanh cong.");
                                        main(args);
                                    } else {
                                        System.out.println("Khong the xoa tai khoan.");
                                    }
                                    break;
                                case 0:
                                    System.out.println("Thoat khoi chuong trinh.");
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le!");
                                    break;
                            }
                        } while (luaChon != 0);
                    } else {
                        System.out.println("Dang nhap that bai. Vui long kiem tra lai thong tin.");
                    }
                    break;
                case 0:
                    System.out.println("Thoat khoi chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (buoc != 0);
    }
}
