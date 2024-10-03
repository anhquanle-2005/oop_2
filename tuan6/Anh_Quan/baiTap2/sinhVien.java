package tuan6.Anh_Quan.baiTap2;
import java.util.*;
public class sinhVien 
{
    private String hoTen, MSV;
    private float dtb;

    public sinhVien (String hoTen, String MSV, float dtb)
    {
        this.hoTen=hoTen;
        this.MSV=MSV;
        this.dtb=dtb;
    }
    public void Nhap()
    {
        Scanner sc= new Scanner (System.in);
        System.out.println("Nhap ma sinh vien: ");
        this.MSV= sc.nextLine();
        System.out.println("Nhap vao ten sinh vien:");
        this.hoTen= sc.nextLine();
        System.out.println("Nhap diem trung binh cua sinh vien nay:");
        this.dtb=sc.nextFloat();
    }
    // public void sapXep (int dtb)
    // {
        
    // }

    public void xuat ()
    {   
        System.out.println(this.MSV+ "-" +this.hoTen +"-"+this.dtb);
    }
}
