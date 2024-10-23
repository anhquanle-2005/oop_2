package tuan8.Hoai_Nam_22.bai2;

import java.util.Scanner;

public class nhanVienSanXuat extends nhanVien {
    protected long soSanPham;
    public nhanVienSanXuat()
    {
        super();
        nhap();
    }
    public long getsoSanPham(){
        return this.soSanPham;
    }
    public void nhap()
    {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao so san pham: ");
        this.soSanPham = sc.nextLong();
    }
    public double tinhLuong()
    {
        return this.luongCB*soSanPham;
    }
}
