package tuan7.Hoai_Nam_22.baitap3;

import java.util.Scanner;

public class baiTap {
    public static void main(String[] args) {
        taiKhoan tk = new taiKhoan();
        Scanner sc = new Scanner(System.in);
        int n,tg,tr;
        tk.nhap();
        tk.xuat();
        System.out.print("ban co muon doi pass khong (1|0): ");
        n = sc.nextInt();
        sc.nextLine();
        if(n==1)
        {
            tk.nhapPassDoi();
            System.out.println("pass sau khi doi: "+tk.getpassWork());
        }
        System.out.print("ban co muon gui tien khong (1|0): ");
        tg = sc.nextInt();
        sc.nextLine();
        if(tg == 1)
            tk.guiTien();
        System.out.print("ban co muon rut tien khong (1|0): ");
        tr = sc.nextInt();
        if(tr == 1)
            tk.rutTien();
        System.out.println("so du hien tai la: "+tk.getsoDu());
        
    }
}
