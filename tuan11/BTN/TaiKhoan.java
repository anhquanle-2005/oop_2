package tuan11.BTN;

public class TaiKhoan {
    private String tenTaiKhoan;
    private double soDu;
    private int thoiGianSuDung;

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

    public int getThoiGianSuDung() {
        return thoiGianSuDung;
    }

    public void napTien(double soTien) {
        if (soTien > 0) {
            this.soDu += soTien;
            System.out.println("Đã nạp tiền thành công!");
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void tangThoiGianSuDung(int phut) {
        if (phut > 0) {
            thoiGianSuDung += phut;
            System.out.println("Đã tăng " + phut + " phút chơi.");
        } else {
            System.out.println("Số phút không hợp lệ.");
        }
    }

    @Override
    public String toString() {
        return "Tên tài khoản: " + tenTaiKhoan + ", Số dư: " + soDu + ", Thời gian sử dụng: " + (thoiGianSuDung / 60) + " giờ";
    }
}

