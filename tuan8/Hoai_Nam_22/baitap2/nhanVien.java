package tuan8.Hoai_Nam_22.baitap2;

import java.util.Scanner;

public class nhanVien {
    protected String maNV;
    protected String tenNV;
    protected long luongCB;
    public nhanVien()
    {
    }
    public String getmaNV(){
        return this.maNV;
    }
    public String gettenNV(){
        return this.tenNV;
    }
    public long getluongCB(){
        return this.luongCB;
    }
    public void setluongCB(long luongCB)
    {
        if(luongCB >=0)
            this.luongCB = luongCB;
        else 
        throw new IllegalArgumentException("luong co ban phai lon hon 0");
    }
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao ma nhan vien: ");
        this.maNV = sc.nextLine();
        System.out.print("nhap vao ten nhan vien: ");
        this.tenNV = sc.nextLine();
        System.out.print("nhap vao luong co ban: ");
        this.luongCB = sc.nextLong();
    }
    public double tinhLuong()
    {
        return 0;
    }
}
