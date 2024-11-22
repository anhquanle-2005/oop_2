package TH.BTN;

import java.io.Serializable;

public abstract class TaiKhoan implements Serializable {
    protected String tenTaiKhoan;
    protected double soDu;
    protected int thoiGianSuDung; // Thời gian chơi tính bằng phút

    public TaiKhoan(String tenTaiKhoan, double soDu) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.soDu = soDu;
        this.thoiGianSuDung = 0;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public abstract void napTien(double soTien);

    public void tangThoiGianSuDung(int phut) {
        if (phut > 0) {
            thoiGianSuDung += phut;
            System.out.println("Đã tăng thời gian sử dụng: " + phut + " phút");
        } else {
            System.out.println("Thời gian không hợp lệ.");
        }
    }

    public void xemSoGioChoi() {
        System.out.println("Số giờ chơi: " + (thoiGianSuDung / 60.0) + " giờ");
    }

    @Override
    public String toString() {
        return tenTaiKhoan + "," + soDu + "," + thoiGianSuDung;
    }
}