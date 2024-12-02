package tuan9;

import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BankServer ds = new BankServer();
        int buoc = 0;
        do {
            System.out.println("Chon yeu cau cua ban");
            System.out.println("Nhap 1: Dang ky tai khoan");
            System.out.println("Nhap 2: Dang nhap tai khoan");
            System.out.println("Nhap 0: De thoat");
            buoc = sc.nextInt();
            switch (buoc) {
                case 1:
                    TaiKhoan tk = new TaiKhoan();
                    tk.nhap();
                    ds.ThemTaiKhoan(tk);
                    break;
                case 2:
                    System.out.println("Nhap vao so tai khoan: ");
                    long soTaiKhoan = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Nhap vao mat khau: ");
                    String matKhau = sc.nextLine();
                    TaiKhoan taiKhoan = ds.DangNhap(soTaiKhoan, matKhau);

                    if (taiKhoan != null) {
                        System.out.println("Dang nhap thanh cong!");
                        int luaChon;
                        do 
                        {
                            System.out.println("So du hien tai: " + taiKhoan.getSoDu());
                            System.out.println("Chon chuc nang:");
                            System.out.println("1. Doi mat khau");
                            System.out.println("2. Rut tien");
                            System.out.println("3. Chuyen tien");
                            System.out.println("4. Nap tien vao tai khoan");
                            System.out.println("5. Mo tai khoan tiet kiem");
                            System.out.println("0. Thoat");
                            luaChon = sc.nextInt();
                            sc.nextLine();

                            switch (luaChon) {
                                case 1:
                                    taiKhoan.doiMatKhau();
                                    break;
                                case 2:
                                    taiKhoan.rutTien();
                                    break;
                                case 3:
                                    System.out.println("Nhap so tai khoan nhan: ");
                                    long soTaiKhoanNhan = sc.nextLong();
                                    sc.nextLine(); // Thêm dòng này
                                    TaiKhoan tkNhan = ds.timTaiKhoan(soTaiKhoanNhan);

                                    if (tkNhan != null) 
                                        taiKhoan.chuyenTien(tkNhan);
                                    else 
                                        System.out.println("Tai khoan nhan khong ton tai.");
                                    break;
                                case 4:
                                    System.out.println("So tien ban muon nap vao: ");
                                    long soTienNap = sc.nextLong();
                                    sc.nextLine();
                                    taiKhoan.napTien(soTienNap); // Thay thế lệnh gọi phương thức
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
