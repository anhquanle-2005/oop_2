package Test;

import Admin.DSPhong;
import Admin.Phong;
import Game.DSgame;
import KhachHang.DSKhachHang;
import NhanVien.DSnhanVien;
import View.AdminView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DSPhong dsPhong= new DSPhong();
        dsPhong.docfile();
        dsPhong.docfileMayTinh();
        DSnhanVien nv= new DSnhanVien();
        DSKhachHang kh = new DSKhachHang();
        DSgame game = new DSgame();
        String luaChon;
        do {
            System.out.println("1. Admin");
            System.out.println("2. Nhan Vien");
            System.out.println("3. Khach Hang");
            System.out.println("Lua chon: ");
            luaChon=sc.nextLine();
            switch (luaChon) {
                case "1":
                    // String choice;
                    // System.out.println("Admin");
                    // do {
                    //     System.out.println("------------------MENU------------------");
                    //     System.out.println("| 1. Them phong may                    |");
                    //     System.out.println("| 2. Them may tinh vao phong           |");
                    //     System.out.println("| 3. Them nhan vien                    |");
                    //     System.out.println("| 4. Xoa nhan vien                     |");
                    //     System.out.println("| 5. Xem danh sach nhan vien           |");
                    //     System.out.println("| 0. Thoat                             |");
                    //     System.out.println("------------------MENU------------------");
                    //     System.out.print("Nhap vao lua chon: ");
                    //     choice=sc.nextLine();
                    //     switch (choice) {
                    //         case "1":
                    //             dsPhong.themPhong();
                    //             break;
                    //         case "2":
                    //             System.out.print("Nhap ma phong muon them may tinh: ");
                    //             String maPhong = sc.nextLine();
                    //             Admin.Phong phong = dsPhong.timPhong(maPhong);
                    //             if (phong != null){
                    //                 phong.themMayTinh();
                    //                 dsPhong.capNhatfile();
                    //             }
                    //             else 
                    //                 System.out.println("Khong tim thay phong voi ma: " + maPhong);
                    //             break;
                    //         case "3":
                    //         int LCH;
                    //         do { 
                    //             System.out.println("--------------MENU--------------");
                    //             System.out.println("| 1. Them nhan vien full time  |");
                    //             System.out.println("| 2. Them nhan vien part time  |");
                    //             System.out.println("| 0. Thoat                     |");
                    //             System.out.println("--------------MENU--------------");
                    //             System.out.print("nhap vao lua chon: ");
                    //             LCH = sc.nextInt();
                    //             sc.nextLine();
                    //             switch (LCH) {
                    //                 case 1:
                    //                     nv.themNhanVienFT();
                    //                     break;
                    //                 case 2:
                    //                     nv.themNhanVienPT();
                    //                     break;
                    //                 case 0:
                    //                     System.out.println("Thoat chuong trinh !");
                    //                     break;
                    //                 default:
                    //                     System.out.println("lua chon khong hop le !");
                    //             }
                    //         }while (LCH!=0);
                    //         break;
                    //         case "4":
                    //             String STKnv;
                    //             System.out.print("nhap vao so tai khoan cua nhan vien can xoa :");
                    //             STKnv = sc.nextLine();
                    //             nv.xoaNV(STKnv);
                    //             nv.ghilai();
                    //             break;
                    //         case "5":
                    //             nv.thongtinNV();
                    //             break;
                    //         default:
                    //             System.out.println("Lua chon khong hop le");
                    //             break;
                    //     }
                    // } while (!choice.equals("0"));
                    new AdminView();
                    break;
                case "2":
                    String lc;
                    do { 
                        System.out.println("--------------menu------------");
                        System.out.println("| 1. Dang nhap               |");
                        System.out.println("| 0. Thoat                   |");
                        System.out.println("--------------menu------------");
                        System.out.print("moi lua chon chuc nang: ");
                        lc= sc.nextLine();
                        switch (lc) {
                            case "1":
                                String STK, password;
                                int tg = 0,dem=0;
                                do { 
                                    
                                    if(tg!=0)
                                        System.out.println("So tai khoan hoac mat khau khong dung !");
                                    tg++;
                                    System.out.print("Nhap vao so tai khoan: ");
                                    STK = sc.nextLine();
                                    System.out.print("Nhap vao mat khau: ");
                                    password = sc.nextLine();
                                    nv.DangNhap(STK, password);
                                    if(nv.s!=-1)
                                        break;
                                    if(tg == 3)
                                        break;
                                } while (true);
                            if(tg>=3)
                            {
                                    int Ch;
                                    System.out.println("--------------menu------------");
                                    System.out.println("| 1. Quen mat khau           |");
                                    System.out.println("| 0. Thoat                   |");
                                    System.out.println("--------------menu------------");
                                    System.out.print("nhap vao lua chon: ");
                                    Ch = sc.nextInt();
                                    sc.nextLine();
                                    switch (Ch) {
                                        case 1:
                                            nv.quenpass();
                                            break;
                                        default:
                                            System.out.println("Thoat chuong trinh !");
                                    }
                                    break;
                            }
                            else
                            {
                                String luaCh;
                                do {
                                    System.out.println("------------------MENU------------------");
                                    System.out.println("| 1. Xem thong tin ca nhan             |");
                                    System.out.println("| 2. Doi mat khau                      |");
                                    System.out.println("| 3. Hien thi danh sach phong          |");
                                    System.out.println("| 4. Cap nhat trang thai may tinh      |");
                                    System.out.println("| 5. Hien thi thong tin may o phong    |");
                                    System.out.println("| 6. Them khach hang                   |");
                                    System.out.println("| 7. Xoa khach hang                    |");
                                    System.out.println("| 8. Xem dan sach khach hang           |");
                                    System.out.println("| 9. Them Game                        |");
                                    System.out.println("| 10. Xoa game                         |");
                                    System.out.println("| 11. Danh sach game                   |");
                                    System.out.println("| 12. Cham cong                        |");
                                    System.out.println("| 0. Dang xuat                         |");
                                    System.out.println("------------------MENU------------------");
                                    System.out.print("Nhap vao lua chon: ");
                                    luaCh = sc.nextLine();
                                    switch (luaCh) {
                                        case "1":
                                            nv.thongTinChiTiet();
                                            break;
                                        case "2":
                                            nv.doiMK();
                                            nv.ghilai();
                                            break;
                                        case "3":
                                            dsPhong.hienThiDSPhong();
                                            break;
                                        case "4":
                                            Boolean valid = false;
                                            System.out.println("Ma phong ban muon cap nhat trang thai may");
                                            String maP = sc.nextLine();
                                            Phong p = dsPhong.timPhong(maP);
                                            if (p != null) {
                                                System.out.println("Ma may tinh can duoc cap nhat");
                                                String maMay = sc.nextLine();
                                                Admin.MayTinh mt = p.timMT(maMay);
                                                if (mt != null) {
                                                    System.out.println("Cap nhat trang thai:");
                                                    System.out.println("Da dat || Bao tri || Chua dat");
                                                    String trangThai = sc.nextLine();
                                                    do {
                                                        try {
                                                            if (trangThai.equals("Da dat") || trangThai.equals("Bao tri") || trangThai.equals("Chua dat")) {
                                                                mt.setTrangThai(trangThai);
                                                                valid = true;
                                                                p.capNhatFileMayTinh();  // Ghi cập nhật vào file của phòng
                                                                dsPhong.capNhatfile();  // Cập nhật lại danh sách phòng vào file
                                                            } else {
                                                                throw new IllegalArgumentException("Lua chon khong hop le");
                                                            }
                                                        } catch (IllegalArgumentException e) {
                                                            System.out.println("Lua chon khong hop le, hay nhap lai");
                                                            trangThai = sc.nextLine();  // Nhập lại trạng thái nếu không hợp lệ
                                                        }
                                                    } while (!valid);
                                                } else {
                                                    System.out.println("Khong tim thay may tinh voi ma: " + maMay);
                                                }
                                            } else {
                                                System.out.println("Khong tim thay phong voi ma: " + maP);
                                            }
                                            break;
                                            case "5":
                                            System.out.println("Ma phong ban muon kiem tra: ");
                                            String Phong =sc.nextLine();
                                            Phong p1 = dsPhong.timPhong(Phong);
                                            if(p1!=null)
                                            {
                                                System.out.println("Danh sach may tinh co trong phong "+Phong);
                                                p1.hienThiDanhSachMayTinh();
                                            }
                                            else 
                                                System.out.println("Khong co ma phong "+Phong);
                                            break;
                                        case "6":
                                            kh.themKhach();
                                            break;
                                        case "7":
                                            String ma;
                                            System.out.println("Nhap vao ma khach hang ban muon xoa:");
                                            ma=sc.nextLine();
                                            kh.xoaKhachHang(ma);
                                            break;
                                        case "8":
                                            kh.hienThiDSKH();
                                            break;
                                        case "9":   
                                            kh.themGame();
                                            break;
                                        case "10":
                                            String magame;
                                            kh.dsgame();
                                            System.out.print("Nhap vao ma game can xoa: ");
                                            magame = sc.nextLine();
                                            kh.xoaGame(magame);
                                            break;
                                        case "11":
                                            System.out.println("--------------------------DSGAME--------------------------");
                                            kh.dsgame();
                                            System.out.println("--------------------------DSGAME--------------------------");
                                            break;
                                        case "12":
                                            nv.chamconglam();
                                            nv.ghilai();
                                            break;

                                        case "0":
                                            System.out.println("Dang xuat !");
                                            break;
                                        default:
                                            System.out.println("Lua chon khong hop le !");
                                            break;
                                    }
                                } while (!luaCh.equals("0"));
                            }
                        
                        case "0":
                            System.out.println("Thoat !");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le !");
                            break;
                        }
                    }while (!lc.equals("0"));
                    break;
                case "3":
                    String a;
                    do
                    {
                        System.out.println("-------------MENU--------------");
                        System.out.println("| 1. Dang nhap                |");
                        System.out.println("| 0. Thoat !                  |");
                        System.out.println("-------------MENU--------------");
                        System.out.print("Nhap vao lua chon: ");
                        a=sc.nextLine();
                        switch (a) {
                            case "1":
                                String STK1, MK;
                                int tg = 0,dem=0;
                                do { 
                                    
                                    if(tg!=0)
                                        System.out.println("So tai khoan hoac mat khau khong dung !");
                                    tg++;
                                    System.out.print("Nhap vao so tai khoan: ");
                                    STK1 = sc.nextLine();
                                    System.out.print("Nhap vao mat khau: ");
                                    MK= sc.nextLine();
                                    kh.dn(STK1, MK);
                                    if(kh.b!=-1) 
                                        break;
                                    if(tg == 3)
                                        break;
                                } while (true);
                                if(tg>=3)
                                {
                                    int Ch;
                                    System.out.println("--------------menu------------");
                                    System.out.println("| 1. Quen mat khau           |");
                                    System.out.println("| 0. Thoat                   |");
                                    System.out.println("--------------menu------------");
                                    System.out.print("nhap vao lua chon: ");
                                    Ch = sc.nextInt();
                                    sc.nextLine();
                                    switch (Ch) {
                                        case 1:
                                            String stk;
                                            int d=0;
                                            do {
                                                if(d!=0)
                                                    System.out.println("So tai khoan khong ton tai !");
                                                d++;
                                                System.out.println("Nhap vao so tai khoan:");
                                                stk = sc.nextLine();
                                                if(d>=3)
                                                    break;
                                            } while (kh.timKhachHang(stk)==null);
                                            if(d>=3)
                                                throw new IllegalArgumentException("loi");
                                            else
                                                kh.quenMatKhau(kh.timKhachHang(stk));
                                            break;
                                           
                                        default:
                                            System.out.println("Thoat chuong trinh !");
                                    }
                                }
                                else
                                {
                                    String ch;
                                    do { 
                                        System.out.println("------------------MENU------------------");
                                        System.out.println("| 1. Xem thong tin ca nnhan            |");
                                        System.out.println("| 2. Doi mat khau                      |");
                                        System.out.println("| 3. Nap tien vao tai khoan            |");
                                        System.out.println("| 4. Chon phong                        |");
                                        System.out.println("| 5. Dang ky gio choi                  |");
                                        System.out.println("| 6. Dang ky game                      |");
                                        System.out.println("| 7. Danh sach game da dang ky         |");
                                        System.out.println("| 8. Xem bien lai                      |");
                                        if(kh.ktraTK(STK1))
                                            System.out.println("| 9. Dang ky tai khoan VIP             |");
                                        System.out.println("| 0. Dang xuat                         |");
                                        System.out.println("------------------MENU------------------");
                                        System.out.print("Nhap vao lua chon: ");
                                        ch = sc.nextLine();
                                        switch (ch) {
                                            case "1":
                                                kh.xemThongTin();
                                                break;
                                            case "2":
                                                kh.doimk();
                                                break;
                                            case "3":
                                                kh.napTien();
                                                break;
                                            case "4":
                                                kh.chonph();
                                                break;
                                            case"5":
                                                int gio;
                                                System.out.print("so gio ban muon dang ky: ");
                                                gio = sc.nextInt();
                                                sc.nextLine();
                                                kh.dkGioChoi(gio);
                                                kh.capNhatFileKh();
                                                break;
                                            case "6":
                                                String mag;
                                                kh.dsgame();
                                                System.out.print("Nhap vao mag muon dang ky: ");
                                                mag = sc.nextLine();
                                                kh.dkgame(mag);
                                                break;
                                            case"7":
                                                kh.dsGameDaThue();
                                                break;
                                            case "8":
                                                kh.xembl();
                                                break;
                                                // System.out.println("Phi phong: "+);
                                            case "9":
                                                kh.DKVIP();
                                                break;
                                            case"0":
                                                if(kh.ktrasodu())
                                                {
                                                     kh.dangxuat();
                                                }
                                                else
                                                {
                                                    System.out.println("So du khong du vui long nap them tien !");
                                                    ch="3";
                                                }
                                                break;
                                            default:
                                                System.out.println("lua chon khong hop le !");
                                        }
                                    } while (!ch.equals("0"));
                                    
                                }
                                break;
                            case "0":
                                System.out.println("Thoat !");
                                break;
                            default:
                               System.out.println("lua chon khong hop le !");
                        }
                    }while(!a.equals("0"));
                default:
                    break;
            }
        } while (!luaChon.equals("0"));
    }
}
