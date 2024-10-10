package tuan7.hoainam22.baitap2;

import java.util.Scanner;

public class baitap {
    public static void main(String[] args) {
        int i,n;
        Scanner sc = new Scanner(System.in);
        System.out.print("so sinh vien can nhap: ");
        n = sc.nextInt();
        sinhVien[] sv = new sinhVien[n];
        for(i=0;i<n;i++)
        {
            System.out.println("nhap vao sinh vien thu "+(i+1));
            sv[i] = sinhVien.nhap();
    
        }
        for(sinhVien x : sv)
        {
            x.xuat();
        }
    }
}
