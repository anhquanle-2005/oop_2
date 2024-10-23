package TH.Tuan7.baiTap1;

import java.util.*;

public class HinhTron {
    private double R;
    public HinhTron(double R)
    {
        setR(R);
    }
    public void setR(double R)
    {
        if(R>0)
            this.R=R;
        else
            throw new IllegalArgumentException("ban kinh phai lon hon 0");
    }
    public double getR()
    {
        return this.R;
    }
    public double ChuVi()
    {
        return 2*Math.PI*R;
    }
    public double DienTich()
    {
        return Math.PI*R*R;
    }
    public static HinhTron Nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao ban kinh ");
        double R = sc.nextDouble();
        return new HinhTron(R);
    }
    public void Xuat()
    {
        System.out.println("chu vi cua hinh tron la: C="+ChuVi());
        System.out.println("dien tich cua hinh tron  la S="+ienTich());
    }
}