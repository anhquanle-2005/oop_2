package KhachHang;

import java.util.Scanner;

public class KhachHang  {
    protected String tenKH;
    protected String maKH;
    protected String matKhau;
    protected String sdt;
    protected double soTien;
    protected int soGioChoi;
    protected int diem;
    protected String loaiKhachHang;


    public KhachHang() {
    }
    
    public KhachHang(String tenKH, String maKH, String matKhau, String sdt, double soTien, int soGioChoi,int diem,String loaiKhachHang) {
        this.tenKH = tenKH;
        this.maKH = maKH;
        this.matKhau = matKhau;
        this.sdt = sdt;
        this.soTien = soTien;
        this.soGioChoi = soGioChoi;
        this.diem=diem;
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public int getSoGioChoi() {
        return soGioChoi;
    }

    public void setSoGioChoi(int soGioChoi) {
        this.soGioChoi = soGioChoi;
    }
    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }
    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public boolean kiemTraMK(String mkNhap)
    {
        return this.matKhau.equals(mkNhap);
    }
    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
    public void doiMatKhau(String mk)
    {
        if(kiemTraDoManhMatKhau(mk))
            this.setMatKhau(mk);
    }
    public boolean kiemTraDoManhMatKhau(String matKhau) {
        return matKhau.length() >= 6 &&
                matKhau.matches(".*[a-zA-Z]+.*") &&
                !matKhau.contains(" ") &&
                matKhau.matches(".*[0-9]+.*") &&
                matKhau.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
    }
    public boolean kiemTraSDT(String sdt)
    {
        return sdt.length()==10 && 
                sdt.matches(".*[0-9]+.*");
    }
    public boolean kiemTraTen(String ten)
    {
        return ten.matches("[A-Z\\s]+");
    }
    public boolean kiemTraMaKH(String maKh)
    {
        return maKh.length() == 5 &&
        maKh.matches(".*[0-9]+.*") && 
        !maKh.contains(" ") &&
        !maKh.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*") &&
        !maKh.matches(".*[a-zA-Z]+.*");
    }
    public void Nhap()
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap vao ten cua khach hang: ");
            this.tenKH = sc.nextLine();
            if(kiemTraTen(this.tenKH))
                break;
            else 
                System.out.println("Viet hoa ho va ten cua ban");
        }
        while (true) {
            System.out.println("Nhap vao ma khach hang: ");
            this.maKH=sc.nextLine();
            if(kiemTraMaKH(maKH))
                break;
            else 
                System.out.println("Trong ma khach hang chi co 5 chu so");
        }

        System.out.println("Nhap vao mat khau:");
        this.matKhau = sc.nextLine();
        do {
            if (!kiemTraDoManhMatKhau(this.matKhau)) {
                System.out.println("Mat khau khong du manh");
                System.out.println("Nhap vao mat khau phai bao gom ky tu viet hoa, ky tu dac biet, so va khong chua khoang trang");
                this.matKhau = sc.nextLine();
            }
        } while (!kiemTraDoManhMatKhau(this.matKhau));
       
        while (true) {
            System.out.println("Nhap vao so dien thoai: ");
            this.sdt=sc.nextLine();
            if(kiemTraSDT(sdt))
                break;
            else 
                System.out.println("Nhap du 10 so");
        }
    }

        public void napTien(Double x) {
            if (x > 5000) {
                this.setSoTien(this.getSoTien() + x);
                System.out.println("Nap tien thanh cong! So du hien tai: " + this.getSoTien());
            } else {
                System.out.println("So tien nap khong hop le.");
            }
        }
        
        public void thanhToan(Double x)
        {
            if (x > 5000) {
                this.setSoTien(this.getSoTien()-x);
                System.out.println("Thanh toan thanh cong! So du hien tai: " + this.getSoTien());
            } else {
                System.out.println("So tien gui khong hop le.");
            }
        }

        @Override
        public String toString() {
            return tenKH + "," + maKH + "," + matKhau + "," + sdt + ","
                + soTien + "," + soGioChoi + ","+diem +"," + loaiKhachHang;
        }

        
    // public void napTien(double soTienNap) {
    //     if (soTienNap > 0) {
    //         this.soTien += soTienNap;
    //         double diemThuongTang = soTienNap / 10000; // 10,000 VND = 1 điểm thưởng
    //         this.diemThuong += diemThuongTang;
    //         System.out.printf("Nạp tiền thành công! Số tiền hiện tại: %.2f. Điểm thưởng hiện tại: %.2f%n", this.soTien, this.diemThuong);
    //     } else {
    //         System.out.println("Số tiền nạp không hợp lệ.");
    //     }
    // }


    // public String getThoiGianChoi() {
    //     return soGioChoi + " giờ " + soPhutChoi + " phút";
    // }
}