package tuan7.Hoai_Nam_22.baitap2;
import java.util.*;
public class sinhVien {
    private String msv;
    private String hoTen;
    private String ngaySinh;
    private double diemTB;
    private String hocLuc;
    public sinhVien (String msv, String hoTen, String ngaySinh, double diemTB)
    {
        this.msv = msv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        setdiemTB(diemTB);
    }
    public void  setdiemTB(double diemTB)
    {
        if(diemTB<0 || diemTB>10)
            throw new IllegalArgumentException("diem trung binh phai trong khong 1->10");
        else
            this.diemTB=diemTB;
        xepLoai();
    }
    public String getmsv()
    {
        return this.msv;
    }
    public String gethoTen()
    {
        return this.hoTen;
    }
    public String getngaySinh()
    {
        return this.ngaySinh;
    }
    public double diemTB()
    {
        return this.diemTB;
    }
    public String gethocLuc()
    {
        return this.hocLuc;
    }
    public void xepLoai()
    {
        if(diemTB>=8.5)
            hocLuc = "gioi";
        else    
            if(diemTB>=6.5)
                hocLuc = "kha";
            else 
                if(diemTB>=5)
                    hocLuc = "trung binh";
                else 
                    hocLuc = "yeu";
    }
    public static sinhVien nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao ma sinh vien: ");
        String msv = sc.nextLine();
        System.out.print("nhap vao ten sinh vien: ");
        String hoTen = sc.nextLine();
        System.out.print("nhap vao ngay sinh: ");
        String ngaySinh = sc.nextLine();
        System.out.print("nhap vao diem trung binh: ");
        double diemTB = sc.nextDouble();
        return new sinhVien(msv, hoTen, ngaySinh, diemTB);

    }
    public void xuat()
    {
        System.out.println(this.msv+" - "+this.hoTen+" - "+this.ngaySinh+" - "+this.diemTB+" - "+this.hocLuc);
    }
}
