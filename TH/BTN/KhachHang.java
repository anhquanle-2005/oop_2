package TH.BTN;

public abstract class KhachHang extends TaiKhoan {
    protected String tenKH;
    protected String sdt;
    protected double soTien;
    protected int soGioChoi;
    protected int soPhutChoi;
    protected int diemThuong;
    protected String loaiKhachHang;

    public KhachHang(String maKH, String matKhau, String tenTaiKhoan, String tenKH, String sdt, double soTien, int diemThuong) {
        super(maKH, matKhau, tenTaiKhoan);
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.soTien = soTien;
        this.soGioChoi = 0;
        this.soPhutChoi = 0;
        this.diemThuong = diemThuong;
    }
    @Override
    public String toString() {
        return getMaKH() + ";" + tenTaiKhoan + ";" + tenKH + ";" + matKhau + ";" + sdt + ";" + soTien + ";" + soGioChoi + ";" + soPhutChoi + ";" + diemThuong;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getSDT() {
        return sdt;
    }

    public double getSoTien() {
        return soTien;
    }

    public int getSoGioChoi() {
        return soGioChoi;
    }

    public int getSoPhutChoi() {
        return soPhutChoi;
    }

    public int getDiemThuong() {
        return diemThuong;
    }

    public void tangDiemThuong(int diem) {
        this.diemThuong += diem;
    }

    public void quyDoiDiem(int diem) {
        if (diem <= diemThuong) {
            diemThuong -= diem;
            System.out.println("Quy đổi thành công! Bạn đã quy đổi " + diem + " điểm thưởng.");
        } else {
            System.out.println("Điểm thưởng không đủ để quy đổi.");
        }
    }

    public void napTien(double soTienNap) {
        if (soTienNap > 0) {
            this.soTien += soTienNap;
            double diemThuongTang = soTienNap / 10000; // 10,000 VND = 1 điểm thưởng
            this.diemThuong += diemThuongTang;
            System.out.printf("Nạp tiền thành công! Số tiền hiện tại: %.2f. Điểm thưởng hiện tại: %.2f%n", this.soTien, this.diemThuong);
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void dangXuat(FileManager fileManager) {
        double chiPhi = (soGioChoi + soPhutChoi / 60.0) * (isVIP() ? 5 : 10);
        this.soTien -= chiPhi; 
        fileManager.ghiLaiThongTin(this);
    }

    protected boolean isVIP() {
        return diemThuong > 250; 
    }

    public abstract void menu(FileManager fileManager);

    public void themThoiGianChoi(int gio, int phut) {
        this.soGioChoi += gio;
        this.soPhutChoi += phut;
        if (this.soPhutChoi >= 60) {
            this.soGioChoi += this.soPhutChoi / 60;
            this.soPhutChoi %= 60;
        }
    }

    public String getThoiGianChoi() {
        return soGioChoi + " giờ " + soPhutChoi + " phút";
    }
}