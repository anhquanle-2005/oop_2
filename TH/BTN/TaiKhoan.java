package TH.BTN;

public class TaiKhoan {
    protected String maKH;
    protected String matKhau;
    protected String tenTaiKhoan;

    public TaiKhoan(String maTK, String matKhau, String tenTaiKhoan) {
        this.maKH = maTK;
        this.matKhau = matKhau;
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }
}