package NhanVien;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DSnhanVien nv = new DSnhanVien();
        Scanner sc = new Scanner(System.in);
        int lc;
        do { 
            System.out.println("--------------menu------------");
            System.out.println("| 1. Dang nhap               |");
            System.out.println("| 0. Thoat                   |");
            System.out.println("--------------menu------------");
            System.out.print("moi lua chon chuc nang: ");
            lc= sc.nextInt();
            sc.nextLine();
            switch (lc) {
                case 1:
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
                    int luaCh;
                    do { 
                        
                        System.out.println("------------------MENU------------------");
                        System.out.println("| 1. Xem thong tin ca nhan             |");
                        System.out.println("| 2. Them nhan vien                    |");
                        System.out.println("| 3. Doi mat khau                      |");
                        System.out.println("| 4. Xoa nhan vien                     |");
                        System.out.println("| 5. Xem danh sach nhan vien           |");
                        System.out.println("| 6. Cham cong                         |");
                        System.out.println("------------------MENU------------------");
                        System.out.print("Nhap vao lua chon: ");
                        luaCh = sc.nextInt();
                        sc.nextLine();
                        switch (luaCh) {
                            case 1:
                                nv.thongTinChiTiet();
                                break;
                            case 2: 
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
                                } while (LCH!=0);
                                break;
                            case 3: 
                                nv.doiMK();
                                break;
                            case 4:
                                String STKnv;
                                System.out.print("nhap vao so tai khoan cua nhan vien can xoa :");
                                STKnv = sc.nextLine();
                                nv.xoaNV(STKnv);
                                // nv.ghilai();
                                break;
                            case 5:
                                    nv.thongtinNV();
                                    break;
                            case 6:
                                nv.chamconglam();
                                nv.ghilai();
                                break;
                            case 0:
                                System.out.println("Thoat !");
                                break;
                            default:
                                System.out.println("lua chon khong hop le, vui long nhap lai !");
                        }
                    } while (luaCh!=0);
                   }
                   case 2: 
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
                               System.out.println("Them thanh cong !");
                               break;
                           case 2:
                               nv.themNhanVienPT();
                               System.out.println("Them thanh cong !");
                               break;
                           case 0:
                               System.out.println("Thoat chuong trinh !");
                               break;
                           default:
                               System.out.println("lua chon khong hop le !");
                       }
                   } while (LCH!=0);
                   break;
                case 0:
                   System.out.println("Thoat !");
                default:
                    throw new AssertionError();
            }
        } while(lc!=0);
       
    }
}
