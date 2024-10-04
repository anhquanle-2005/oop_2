package tuan6.Thanh_Huy.baiTap2;
import java.util.*;
public class baiTap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n;
        System.out.print("so sinh vien can nhap vao: ");
        n = sc.nextInt();
        sinhVien[] sv = new sinhVien[n];
        for(i=0;i<n;i++)
        {
            sv[i] = new sinhVien();
            System.out.println("nhap vao sinh vien thu "+(i+1));
            sv[i].nhap();
        }
        sinhVien.sapxep(sv);

         for(sinhVien sx : sv)
        {
          sx.xuat();
        }
    }
}