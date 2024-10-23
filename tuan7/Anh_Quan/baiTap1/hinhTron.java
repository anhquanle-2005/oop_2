package oop_2.tuan7.Anh_Quan.baiTap1;
import java.util.Scanner;
public class hinhTron 
{
    private double R;
    public double getR()
    {
        return this.R;
    }
    public void setR(double r)
    {
        this.R=r;
    }
    public double tinhChuVi()
    {
        return (2*Math.PI * this.R);
    }
    public double tinhDienTich()
    {
        return (Math.PI * Math.pow(R, 2));
    }
    public  hinhTron(){}
    public hinhTron(double r)
    {
        this.R=r;
    }
    public hinhTron(hinhTron t)
    {
        this.R=t.R;
    }
    public void Nhap()
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("nhap ban kinh R:");
            this.R=sc.nextDouble();
    }
    public void Xuat()
    {
        System.out.println("Ban kinh R="+this.R);
        System.out.println("chu vi hinh tron ="+this.tinhChuVi());
    }
}
