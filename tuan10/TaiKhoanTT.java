package tuan10;

import java.io.Serializable;
import java.util.Scanner;

public class TaiKhoanTT extends TaiKhoan implements Serializable {
    Scanner sc = new Scanner(System.in);

    public TaiKhoanTT() {
        super();
    }

    public TaiKhoanTT(String soTaiKhoan, double soDu, String chuTk, String matKhau, String cccd, int SDT, String EMAIL, int pin) {
        super(soTaiKhoan, soDu, chuTk, matKhau, cccd, SDT, EMAIL, pin);
    }

    @Override
    public void napTien(Double x) {
        if (x > 5000) {
            this.setSoDu(this.getSoDu() + x);
            System.out.println("Nap tien thanh cong! So du hien tai: " + this.getSoDu());
        } else {
            System.out.println("So tien nap khong hop le.");
        }
    }
    
    @Override
    public void guiTien(Double x) {
        if (x > 5000) {
            this.setSoDu(this.getSoDu() + x);
            System.out.println("Gui tien thanh cong! So du hien tai: " + this.getSoDu());
        } else {
            System.out.println("So tien gui khong hop le.");
        }
    }

    @Override
    public void rutTien() {
        System.out.println("Nhap so tien can rut: ");
        Double soTien = sc.nextDouble();
        if (soTien > 50000 && soTien <= SoDu) {
            SoDu -= soTien;
            System.out.println("Rut tien thanh cong! So du hien tai: " + SoDu);
        } else {
            System.out.println("So du khong du hoac so tien khong hop le.");
        }
    }

    @Override
    public void chuyenTien(TaiKhoan tkNhan) {
        System.out.println("Nhap so tien can chuyen: ");
        Double soTien = sc.nextDouble();
        System.out.println("Nhap vao ma pin de chuyen tien:");
        int pin= sc.nextInt();
        sc.nextLine();
        if (soTien > 5000 && soTien <= this.getSoDu() && pin ==this.getPin()) {
            this.setSoDu(this.getSoDu() - soTien);
            tkNhan.setSoDu(tkNhan.getSoDu() + soTien);
            System.out.println("Noi dung chuyen tien: ");
            String noiDung = sc.nextLine();
            System.out.println("Chuyen tien thanh cong! So du hien tai: " + this.getSoDu());
            // Giả lập ghi lại lịch sử chuyển tiền
            BankServer bankServer = new BankServer();
            bankServer.ghiLichSuChuyenTien(this.getSoTaiKhoan(), tkNhan.getSoTaiKhoan(), soTien, noiDung);
        } else {
            System.out.println("So du khong du hoac so tien khong hop le.");
        }
    }

    @Override
    public String toString() {
        return "TaiKhoanTT [sc=" + sc + ", pin=" + pin + ", soTaiKhoan=" + soTaiKhoan + ", SoDu=" + SoDu + ", chuTk="
                + chuTk + ", matKhau=" + matKhau + ", getCccd()=" + getCccd() + ", getSDT()=" + getSDT()
                + ", getEMAIL()=" + getEMAIL() + ", getPin()=" + getPin() + ", getSoTaiKhoan()=" + getSoTaiKhoan()
                + ", getSoDu()=" + getSoDu() + ", getChuTk()=" + getChuTk() + ", getMatKhau()=" + getMatKhau() + "]";
    }


    
}