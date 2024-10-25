package tuan6.Anh_Quan.baiTap2;

import java.util.*;

public class Main {
    static Scanner sc;
    static String hoTen, MSV;
    static float dtb;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        int i, n;
        System.out.println("Nhap so luong sinh vien:");
        n=sc.nextInt();
        sinhVien [] sv =new sinhVien[n];
        for(i=0;i<n;i++)
        {
            sv[i]=new sinhVien(hoTen, MSV, n);
            System.out.println("nhap vao sinh vien thu "+(i+1));
            sv[i].Nhap();
        }
        for (sinhVien sx :sv)
            sx.xuat();

        
    }
}
