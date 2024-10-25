package tuan8.Anh_Quan.baiTap3;

public class Sach extends TaiLieu{
        private int soTrang;

        public Sach(String mtl, String tenTaiLieu, Ngay ngayXuatBan, int soTrang) {
            super(mtl, tenTaiLieu, ngayXuatBan);
            this.soTrang = soTrang;
        }

        public int getSoTrang() {
            return soTrang;
        }

        public void setSoTrang(int soTrang) {
            this.soTrang = soTrang;
        }
        
        public void thongTin()
        {
            System.out.println("Sach co so trang:"+this.getSoTrang());
        }
}
