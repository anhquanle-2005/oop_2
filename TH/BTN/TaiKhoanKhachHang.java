package TH.BTN;

public class TaiKhoanKhachHang {
    private String tenTaiKhoan;
    private double soDu;
    private int thoiGianSuDung;
    private String matKhau;

    public TaiKhoanKhachHang(String tenTaiKhoan, double soDu, String matKhau) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
        this.thoiGianSuDung = 0; // Khởi tạo thời gian sử dụng
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public int getThoiGianSuDung() {
        return thoiGianSuDung;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void napTien(double soTien) {
        this.soDu += soTien;
    }

    public void tangThoiGianSuDung(int thoiGian) {
        this.thoiGianSuDung += thoiGian;
    }

    public void xemSoGioChoi() {
        System.out.println("Thời gian sử dụng: " + thoiGianSuDung + " phút");
    }

    @Override
    public String toString() {
        return tenTaiKhoan + "," + soDu + "," + thoiGianSuDung + "," + matKhau;
    }
}