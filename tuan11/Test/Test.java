package Test;

import java.util.Scanner;

import Admin.DSPhong;
import NhanVien.DSnhanVien;
import Admin.MayTinh;
import Admin.Phong;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSPhong dsPhong= new DSPhong();
        dsPhong.docfile();
        dsPhong.docfileMayTinh();
        DSnhanVien nv= new DSnhanVien();
        String luaChon;
        do {
            System.out.println("1. Admin");
            System.out.println("2. Nhan Vien");
            System.out.println("3. Khach Hang");
            System.out.println("Lua chon: ");
            luaChon=sc.nextLine();
            switch (luaChon) {
                case "1":
                    String choice;
                    System.out.println("Admin");
                    do {
                        System.out.println("------------------MENU------------------");
                        System.out.println("| 1. Them phong may                    |");
                        System.out.println("| 2. Them may tinh vao phong           |");
                        System.out.println("| 3. Them nhan vien                    |");
                        System.out.println("| 4. Xoa nhan vien                     |");
                        System.out.println("| 5. Xem danh sach nhan vien           |");
                        System.out.println("| 0. Thoat                             |");
                        System.out.println("------------------MENU------------------");
                        System.out.print("Nhap vao lua chon: ");
                        choice=sc.nextLine();
                        switch (choice) {
                            case "1":
                                dsPhong.themPhong();
                                break;
                            case "2":
                                System.out.print("Nhap ma phong muon them may tinh: ");
                                String maPhong = sc.nextLine();
                                Admin.Phong phong = dsPhong.timPhong(maPhong);
                                if (phong != null){
                                    phong.themMayTinh();
                                    dsPhong.capNhatfile();
                                }
                                else 
                                    System.out.println("Khong tim thay phong voi ma: " + maPhong);
                                break;
                            case "3":
                            int LCH;
                            do { 
                                System.out.println("--------------MENU--------------");
                                System.out.println("| 1. Them nhan vien full time  |");
                                System.out.println("| 2. Them nhan vien part time  |");
                                System.out.println("| 0. Thoat                     |");
                                System.out.println("--------------MENU--------------");
                                System.out.print("nhap vao lua chon: ");
                                LCH = sc.nextInt();
                                sc.nextLine();
                                switch (LCH) {
                                    case 1:
                                        nv.themNhanVienFT();
                                        break;
                                    case 2:
                                        nv.themNhanVienPT();
                                        break;
                                    case 0:
                                        System.out.println("Thoat chuong trinh !");
                                        break;
                                    default:
                                        System.out.println("lua chon khong hop le !");
                                }
                            }while (LCH!=0);
                            break;
                            case "4":
                                String STKnv;
                                System.out.print("nhap vao so tai khoan cua nhan vien can xoa :");
                                STKnv = sc.nextLine();
                                nv.xoaNV(STKnv);
                                nv.ghilai2(STKnv);
                                // nv.capNhatfile();
                                break;
                            case "5":
                                nv.thongtinNV();
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                                break;
                        }
                    } while (!choice.equals("0"));
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
                                    System.out.println("| 5. Chon phong                        |");
                                    System.out.println("| 6. Hien thi thong tin may o phong    |");
                                    System.out.println("| 7. Cham cong                         |");
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
                                            System.out.println("Ban muon cho loai phong nao");
                                            System.out.println("phong Don || phong Doi || phong Vip || phong Thi Dau");
                                            System.out.println("Loai phong ban muon choi: ");
                                            String loaiPhong= sc.nextLine();
                                            switch (loaiPhong) {
                                                case "phong Don":
                                                    dsPhong.hienThiDSPhong(loaiPhong);
                                                    System.out.println("Chon phong: ");
                                                    String mp2= sc.nextLine();
                                                    Phong p1=dsPhong.timPhong(mp2);
                                                    if(p1!=null)
                                                    {
                                                        p1.hienThiDanhSachMayTinh();
                                                        System.out.println("Chon may ban muon choi: ");
                                                        String maMay=sc.nextLine();
                                                        Admin.MayTinh m1=p1.timMayTinh(maMay);
                                                        if(m1!=null)
                                                        {
                                                            m1.setTrangThai("Da dat");
                                                            p1.capNhatTrangThaiMay(m1);
                                                            dsPhong.capNhatfile();
                                                        }
                    
                                                        else 
                                                            System.out.println("May da duoc dat || bao tri");
                                                    }
                                                    break;
                                                case "phong Doi":
                                                    dsPhong.hienThiDSPhong(loaiPhong);
                                                    System.out.println("Chon phong: ");
                                                    String mp3= sc.nextLine();
                                                    Phong p2=dsPhong.timPhong(mp3);
                                                    if(p2!=null)
                                                    {
                                                        p2.hienThiDanhSachMayTinh();
                                                        System.out.println("Chon may ban muon choi: ");
                                                        String maMay=sc.nextLine();
                                                        Admin.MayTinh m1=p2.timMayTinh(maMay);
                                                        if(m1!=null)
                                                        {
                                                            m1.setTrangThai("Da dat");
                                                            p2.capNhatFileMayTinh();
                                                            dsPhong.capNhatfile();
                                                        }
                                                        else 
                                                            System.out.println("May da duoc dat || bao tri");
                                                    }
                                                    break;
                                                case "phong Vip":
                                                    dsPhong.hienThiDSPhong(loaiPhong);
                                                    System.out.println("Chon phong: ");
                                                    String mp4= sc.nextLine();
                                                    Phong p3=dsPhong.timPhong(mp4);
                                                    if(p3!=null)
                                                    {
                                                        p3.hienThiDanhSachMayTinh();
                                                        System.out.println("Chon may ban muon choi: ");
                                                        String maMay=sc.nextLine();
                                                        Admin.MayTinh m1=p3.timMayTinh(maMay);
                                                        if(m1!=null)
                                                        {
                                                            m1.setTrangThai("Da dat");
                                                            p3.capNhatFileMayTinh();
                                                            dsPhong.capNhatfile();
                                                        }
                                                        else 
                                                            System.out.println("May da duoc dat || bao tri");
                                                    }
                                                    break;
                                                case "phong Thi Dau":
                                                    dsPhong.hienThiDSPhong(loaiPhong);
                                                    System.out.println("Chon phong: ");
                                                    String mp5= sc.nextLine();
                                                    Phong p4=dsPhong.timPhong(mp5);
                                                    if(p4!=null)
                                                    {
                                                        p4.hienThiDanhSachMayTinh();
                                                        for(Admin.MayTinh mt: p4.getDSMAYTINH())
                                                        {
                                                            mt.setTrangThai("Da dat");
                                                            p4.capNhatFileMayTinh();
                                                            dsPhong.capNhatfile();
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Lua chon khong hop le");
                                                    break;
                                            }
                                            break;
                                        case "6":
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
                                        case "7":
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
                default:
                    break;
            }
        } while (!luaChon.equals("0"));
    }
}
