package tuan8.Anh_Quan.baiTap3;

public class Bao extends TaiLieu{
    private int soTrang;

    public Bao(String mtl, String tenTaiLieu, Ngay ngayXuatBan, int soTrang) {
        super(mtl, tenTaiLieu, ngayXuatBan);
        this.soTrang = soTrang;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
    
    public void soTrang()
    {
        System.out.println("So trang cua bao: "+this.getSoTrang());
    }
}
