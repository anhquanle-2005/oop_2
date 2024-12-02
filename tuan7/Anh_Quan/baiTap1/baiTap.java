package tuan7.Anh_Quan.baiTap1 ;
import java.util.Scanner;
public class baiTap 
{   
    static Scanner sc;
    static double R;
    static float dienTich;
    public static void main(String[] args) 
    {
        hinhTron t1=new hinhTron();
        t1.setR(2);
        t1.Xuat();
        hinhTron t2=new hinhTron();
        t2.Nhap();
        t2.Xuat();
        hinhTron t3=new hinhTron(10);
        t3.Xuat();
        hinhTron t4=new hinhTron(t3);
        t4.Xuat();
    }
}