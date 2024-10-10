package tuan7.hoainam22.baitap1;
import java.util.*;

public class hinhTron {
    private double R;
    public hinhTron(double R)
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
    public double chuVi()
    {
        return 2*Math.PI*R;
    }
    public double dienTich()
    {
        return Math.PI*R*R;
    }
    public static hinhTron nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao ban kinh ");
        double R = sc.nextDouble();
        return new hinhTron(R);
    }
    public void xuat()
    {
        System.out.println("chu vi cua hinh tron ban kinh "+this.R+" la c="+chuVi());
        System.out.println("dien tich cua hinh tron ban kinh "+this.R+" la s="+dienTich());
    }
}
