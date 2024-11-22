package NhanVien;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DSnhanVien nv = new DSnhanVien();
        Scanner sc = new Scanner(System.in);
        int lc;

        System.out.println("--------------menu------------");
        System.out.println("| 1. Dang nhap               |");
        System.out.println("| 2. Dang ky                 |");
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
                    tg++;
                    System.out.print("Nhap vao so tai khoan: ");
                    STK = sc.nextLine();
                    password = sc.nextLine();
                    nv.DangNhap(STK, password,dem);
                    if(dem==1)
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
                    System.out.println("nhap vao lua chon: ");
                    Ch = sc.nextInt();
                    sc.nextLine();
                    switch (Ch) {
                        case 1:
                            nv.quenpass();
                            break;
                        default:
                            System.out.println("Thoat chuong trinh !");
                    }
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
                    System.out.println("------------------MENU------------------");
                    System.out.print("Nhap vao lua chon: ");
                    luaCh = sc.nextInt();
                    
                } while (true);
                

               }
               
            case 2:
            default:
                throw new AssertionError();
        }
    }
}
