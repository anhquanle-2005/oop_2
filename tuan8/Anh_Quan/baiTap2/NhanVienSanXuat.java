package tuan8.Anh_Quan.baiTap2;

public class NhanVienSanXuat extends NhanVien{
    private int SanPham;

    public NhanVienSanXuat(String mnv, String ten, int luongCoBan, int sanPham) {
        super(mnv, ten, luongCoBan);
        this.SanPham = sanPham;
    }
    
    public void luong ()
    {
        System.out.println("Luong cua nhan vien san xuat:"+this.luongCoBan*SanPham);
    }

    public int getSanPham() {
        return SanPham;
    }

    public void setSanPham(int sanPham) {
        SanPham = sanPham;
    }
    
}
