package tuan6.Anh_Quan.baiTap1;

import java.util.Scanner;

public class hinhChuNhat 
{
    private int chieuDai;
    private int chieuRong;

    public hinhChuNhat(int cd, int cr)
    {
        this.chieuDai=cd;
        this.chieuRong=cr;
    }
    public int chuVi ()
    {
        return this.chieuDai+this.chieuRong;
    }
    public int dienTich()
    {
        return this.chieuDai*this.chieuRong;
    }
        public void Nhap()
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("nhap chieu dai cua hinh chu nhat:");
        this.chieuDai=sc.nextInt();
        System.out.println("nhap chieu rong cua hinh chu nhat");
        this.chieuRong=sc.nextInt();
    }
    public void Xuat()
    {
        System.out.println("Chu vi hinh chu nhat nay = "+this.chuVi());
        System.out.println("Dien tich cua hinh chu nhat nay = "+this.dienTich());
    }
}
