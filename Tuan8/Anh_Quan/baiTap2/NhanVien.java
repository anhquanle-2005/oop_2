package oop_2.tuan8.Anh_Quan.baiTap2;

public class NhanVien {
    protected String mnv;
    protected String ten;
    protected int luongCoBan;

    public NhanVien(String mnv, String ten, int luongCoBan ){
        this.mnv=mnv;
        this.ten=ten;
        this.luongCoBan=luongCoBan;
    }

    public String getMnv() {
        return mnv;
    }

    public void setMnv(String mnv) {
        this.mnv = mnv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    @Override
    public String toString() {
        return "NhanVien [mnv=" + mnv + ", ten=" + ten + ", luongCoBan=" + luongCoBan + "]";
    }

    
}
