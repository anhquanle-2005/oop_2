package oop_2.tuan8.Anh_Quan.baiTap3;

public class TaiLieu {
    protected String mtl, tenTaiLieu;
    protected Ngay NgayXuatBan;

    public TaiLieu(String mtl, String tenTaiLieu, Ngay ngayXuatBan) {
        this.mtl = mtl;
        this.tenTaiLieu = tenTaiLieu;
        this.NgayXuatBan = ngayXuatBan;
    }

    public String getMtl() {
        return mtl;
    }

    public void setMtl(String mtl) {
        this.mtl = mtl;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    public Ngay getNgayXuatBan() {
        return NgayXuatBan;
    }

    public void setNgayXuatBan(Ngay ngayXuatBan) {
        this.NgayXuatBan = ngayXuatBan;
    }
    
    
}
