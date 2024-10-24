package tuan8.Hoai_Nam_22.baitap2;

import java.util.Scanner;

public class nhanVienVanPhong extends nhanVien {
    protected double heSo;
    public nhanVienVanPhong()
    {
        super();
        nhap();
    }
    public double getheSo()
    {
        return this.heSo;
    }
    public void nhap()
    {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao he so luong: ");
        this.heSo = sc.nextDouble();
    }
    public double tinhLuong()
    {
        return this.luongCB*this.heSo;
    }
}
