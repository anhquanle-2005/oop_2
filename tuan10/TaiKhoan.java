package tuan10;

import java.io.Serializable;
import java.util.Scanner;

public abstract class TaiKhoan implements Serializable {
    private String cccd;
    private int SDT;
    private String EMAIL;
    protected int pin;
    protected String soTaiKhoan;
    protected Double SoDu;
    protected String chuTk;
    protected String matKhau;

    static Scanner sc = new Scanner(System.in);
    
    public TaiKhoan() {}

    public TaiKhoan(String soTaiKhoan, Double soDu, String chuTk, String matKhau, String cccd, int SDT, String EMAIL, int pin) {
        this.soTaiKhoan = soTaiKhoan;
        this.SoDu = soDu;
        this.chuTk = chuTk;
        this.matKhau = matKhau;
        this.cccd = cccd;
        this.SDT = SDT;
        this.EMAIL = EMAIL;
        this.pin = pin;
    }
    public String getCccd() {
        return cccd;
    }
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
    public int getSDT() {
        return SDT;
    }

    public void setSDT(int sDT) {
        SDT = sDT;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String eMAIL) {
        EMAIL = eMAIL;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public Double getSoDu() {
        return SoDu;
    }

    public void setSoDu(Double soDu) {
        SoDu = soDu;
    }

    public String getChuTk() {
        return chuTk;
    }

    public void setChuTk(String chuTk) {
        this.chuTk = chuTk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        TaiKhoan.sc = sc;
    }

    public boolean kiemTraTen(String ten)
    {
        return ten.matches("[A-Z\\s]+");
    }
    public boolean kiemTraMatKhau(String matKhauNhap) {
        return this.matKhau.equals(matKhauNhap);
    }
    public boolean kiemTraSoTaiKhoan(String soTaiKhoan)
    {
        return !soTaiKhoan.contains(" ");
    }
    public boolean kiemTraDoManhMatKhau(String matKhau) {
        return matKhau.length() >= 6 &&
                matKhau.matches(".*[a-zA-Z]+.*") &&
                !matKhau.contains(" ") &&
                matKhau.matches(".*[0-9]+.*") &&
                matKhau.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
    }
    public boolean kiemTraSDT(int SDT) {
        return String.valueOf(SDT).length() == 10;
    }
    
    public boolean kiemTraEmail(String email) {
        return email.contains("@");
    }
    
    public boolean kiemTraPin(int pin) {
        return String.valueOf(pin).length() == 4;
    }
    public boolean kiemTraCCCD(String cccd) {
        return cccd.matches("\\d{12}");
    }
    public void doiMatKhau() {
        System.out.println("Nhap mat khau cu: ");
        String matKhauCu = sc.nextLine();

        if (kiemTraMatKhau(matKhauCu)) {
            System.out.println("Nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            while (!kiemTraDoManhMatKhau(matKhauMoi) || matKhauMoi.equals(matKhauCu)) {
                System.out.println("Mat khau khong du manh va khong duoc trung mat khau cu. Vui long nhap lai: ");
                matKhauMoi = sc.nextLine();
            }

            this.matKhau = matKhauMoi;
            System.out.println("Doi mat khau thanh cong!");
        } else {
            System.out.println("Mat khau cu khong dung.");
        }
    }

    public void Nhap() {
        sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap vao so tai khoan muon tao: ");
            this.soTaiKhoan = sc.nextLine();
            if (kiemTraSoTaiKhoan(this.soTaiKhoan))
                break;
            else
                System.out.println("Khong duoc co khoang trang");
        }
        while (true) {
            System.out.println("Nhap vao ten cua chu tai khoan: ");
            this.chuTk = sc.nextLine();
            if(kiemTraTen(this.chuTk))
                break;
            else 
                System.out.println("Viet hoa ho  va ten cua ban");
        }
      
        while (true) {
            System.out.println("Nhap vao so CCCD: ");
            this.cccd = sc.nextLine();
            if (kiemTraCCCD(this.cccd)) 
                break; // Thoát khỏi vòng lặp nếu nhập thành công và hợp lệ
            else 
                System.out.println("CCCD phai co dung 12 chu so.");
        }
        
        while (true) {
            try {
                System.out.println("Nhap vao SDT: ");
                this.SDT = Integer.parseInt(sc.nextLine());
                if (kiemTraSDT(this.SDT)) 
                    break; // Thoát khỏi vòng lặp nếu nhập thành công và hợp lệ
                else 
                    System.out.println("SDT phai co dung 10 chu so.");
                
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap SDT hop le (so nguyen).");
            }
        }
        
        do {
            System.out.println("Nhap vao EMAIL: ");
            this.EMAIL = sc.nextLine();
            if (!kiemTraEmail(this.EMAIL)) 
                System.out.println("EMAIL phai chua ky tu '@'.");
        } while (!kiemTraEmail(this.EMAIL));
        
        while (true) {
            try {
                System.out.println("Nhap vao pin (4 chu so): ");
                this.pin = Integer.parseInt(sc.nextLine());
                if (kiemTraPin(this.pin)) 
                    break; // Thoát khỏi vòng lặp nếu nhập thành công và hợp lệ
                else 
                    System.out.println("Pin phai la 4 chu so.");
                
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap pin hop le (so nguyen).");
            }
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
    }
    public void Xuat() {
        System.out.println("Thong tin hien tai cua tai khoan:");
        System.out.println("So tai khoan: " + this.soTaiKhoan);
        System.out.println("So du hien tai: " + this.SoDu);
        System.out.println("Ten cua chu tai khoan: " + this.chuTk);
    }
    public abstract void rutTien();
    public abstract void napTien(Double x);
    public abstract void chuyenTien(TaiKhoan tkNhan);
    public abstract void guiTien(Double x);
}
