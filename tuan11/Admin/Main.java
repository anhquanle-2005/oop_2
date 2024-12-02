package Admin;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSPhong dsPhong = new DSPhong();
        dsPhong.docfile();
        dsPhong.docfileMayTinh();
        int choice;
        do {
            System.out.println("==== MENU ====");
            System.out.println("1. Them phong");
            System.out.println("2. Them may tinh vao phong: ");
            System.out.println("3. Hien thi danh sach phong: ");//nv
            System.out.println("4. Cap nhat trang thai may tinh: ");//nv
            System.out.println("5. Chon phong ");//nv
            System.out.println("6. Hien thi thong tin may o phong: ");//nv
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            try {
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        dsPhong.themPhong();
                        break;
                    case 2:
                        System.out.print("Nhap ma phong muon them may tinh: ");
                        String maPhong = sc.nextLine();
                        Phong phong = dsPhong.timPhong(maPhong);
                        if (phong != null){
                            phong.themMayTinh();
                            dsPhong.capNhatfile();
                        }
                        else 
                            System.out.println("Khong tim thay phong voi ma: " + maPhong);
                        break;
                    case 3:
                        dsPhong.hienThiDSPhong();
                        break;
                    case 4:
                        Boolean valid = false;
                        System.out.println("Ma phong ban muon cap nhat trang thai may");
                        String maP = sc.nextLine();
                        Phong p = dsPhong.timPhong(maP);
                        if (p != null) {
                            System.out.println("Ma may tinh can duoc cap nhat");
                            String maMay = sc.nextLine();
                            MayTinh mt = p.timMT(maMay);
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
                    case 5:
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
                                    MayTinh m1=p1.timMayTinh(maMay);
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
                                    MayTinh m1=p2.timMayTinh(maMay);
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
                                    MayTinh m1=p3.timMayTinh(maMay);
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
                                    for(MayTinh mt: p4.getDSMAYTINH())
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
                    case 6: 
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

                    case 7:
                        System.out.println("Thoat chuong trinh. Tam biet!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhap khong hop le. Vui long nhap mot so nguyen.");
                sc.nextLine();
                choice = 0; 
            }
        } while (choice != 99); 
    }
}