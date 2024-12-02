package tuan9;

import java.util.Scanner;

public class TaiKhoan {
    private long soTaiKhoan;
    private long SoDu;
    private String chuTk;
    private String matKhau;
    static Scanner sc = new Scanner(System.in);

    public TaiKhoan() {
    }

    public TaiKhoan(long soTaiKhoan, long soDu, String chuTk, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.SoDu = soDu;
        this.chuTk = chuTk;
        this.matKhau = matKhau;
    }

    public long getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public long getSoDu() {
        return SoDu;
    }

    public void setSoDu(long soDu) {
        SoDu = soDu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public boolean kiemTraMatKhau(String matKhauNhap)
    {
        return this.matKhau.equals(matKhauNhap);
    }

    public boolean kiemTraDoManhMatKhau(String matKhau)
    {
        return matKhau.length() >= 6 &&
                matKhau.matches(".*[a-zA-Z]+.*") &&
                matKhau.matches(".*[0-9]+.*") &&
                matKhau.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
    }

    public void doiMatKhau() {
        System.out.println("Nhap mat khau cu: ");
        String matKhauCu = sc.nextLine();
        
        if (kiemTraMatKhau(matKhauCu)) {
            System.out.println("Nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            
            while (!kiemTraDoManhMatKhau(matKhauMoi)) {
                System.out.println("Mat khau khong du manh. Vui long nhap lai: ");
                matKhauMoi = sc.nextLine();
            }
            
            this.matKhau = matKhauMoi;
            System.out.println("Doi mat khau thanh cong!");
        } else {
            System.out.println("Mat khau cu khong dung.");
        }
    }
    
    public void nhap()
    {
        sc = new Scanner(System.in);
        System.out.println("Nhap vao so tai khoan muon tao: ");
        this.soTaiKhoan= sc.nextLong();
        sc.nextLine();
        System.out.println("Nhap vao ten cua chu tai khoan: ");
        this.chuTk= sc.nextLine();
        System.out.println("Nhap vao mat khau:");
        this.matKhau=sc.nextLine();
        do {
            if (!kiemTraDoManhMatKhau(this.matKhau)) {
                System.out.println("Mat khau khong du manh");
                System.out.println("Nhap vao mat khau:");
                System.out.println("Nhap vao mat khau phai bao gom ky tu viet hoa, ky tu dac biet va so");
                this.matKhau=sc.nextLine();
            }
        } while (!kiemTraDoManhMatKhau(this.matKhau));
    }

    
    // public void xuat()
    // {
    //     System.out.println("Thong tin hien tai cua tai khoan");
    //     System.out.println("So tai khoan: "+this.soTaiKhoan);
    //     System.out.println("So du hien tai:  "+this.SoDu);
    //     System.out.println("Ten cua chu tai khoan: "+this.chuTk);
    // }
}
