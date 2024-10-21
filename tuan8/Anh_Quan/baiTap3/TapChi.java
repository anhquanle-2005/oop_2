package oop_2.tuan8.Anh_Quan.baiTap3;

public class TapChi extends TaiLieu{
    private int soPH;

    public TapChi(String mtl, String tenTaiLieu, Ngay ngayXuatBan, int soPH) {
        super(mtl, tenTaiLieu, ngayXuatBan);
        this.soPH = soPH;
    }

    public int getSoPH() {
        return soPH;
    }

    public void setSoPH(int soPH) {
        this.soPH = soPH;
    }
    
    public void soPH()
    {
        System.out.println("So phat hanh cua tap chi nay: "+this.getSoPH());
    }
}
