package tuan8.Anh_Quan.baiTap2;

public class NhanVienVanPhong extends NhanVien{
    private double heSo;

    public NhanVienVanPhong(String mnv, String ten, int luongCoBan, double heSo) {
        super(mnv, ten, luongCoBan);
        this.heSo = heSo;
    }
    
    public void luongVP()
    {
        System.out.println("Luong cua nhan vien van phong la:"+this.luongCoBan*heSo);
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }
}
