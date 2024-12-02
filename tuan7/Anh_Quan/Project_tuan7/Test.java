package tuan7.Anh_Quan.Project_tuan7;
import java.util.Scanner;
public class Test {
    static Scanner sc;
    static String chuTk,matKhau;
    static long soTaiKhoan, soDu,x;
    static int n;

    public static void main(String[] args) {
        sc= new Scanner(System.in);
        TaiKhoan tk= new TaiKhoan(soTaiKhoan, soDu, chuTk, matKhau);
        System.out.println("Tao tai khoan");
        tk.Nhap();
        System.out.println("Thong tin cua tai khoan vua tao");
        tk.Xuat();
        
        // System.out.println("Dang nhap tai khoan");
        // System.out.println("Nhap vao so tai khoan hien tai:");
        // sc.nextLong();
        // sc.nextLine();
        // System.out.println("Nhap vao mat khau");
        // sc.nextLine();
        // tk.dangNhap(soTaiKhoan, matKhau);
        do
        {
            System.out.println("===Chuc nang===");
            System.out.println("Nhap phim 1 neu ban muon chuyen tien");
            System.out.println("Nhap phim 2 neu ban muon rut tien");
            System.out.println("Nhap phim 3 de doi mat khau tai khoan");
            System.out.println("Phim 0 de thoat chuong trinh");
            System.out.println("Lua chon cua ban la gi:");
            n= sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Nhap vao so tien muon gui");
                    x= sc.nextLong();
                    System.out.println("So du hien tai cua ban:"+tk.guiTien(x));
                    break;
                case 2:
                    System.out.println("Nhap vao so tien ban muon rut");
                    x= sc.nextLong();
                    do {
                        if(tk.getSoDu() < x){
                            System.out.println("So du hien tai khong du");
                            System.out.println("Nhap vao so tien ban muon rut");
                            x= sc.nextLong();
                            System.out.println("So du hien tai cua ban: "+tk.rutTien(x));
                        }
                    } while ((tk.getSoDu() < x));
                    System.out.println("So du hien tai cua ban: "+tk.rutTien(x));
                default:
                    break;
            }
        }
        while (n!=0);
}
}