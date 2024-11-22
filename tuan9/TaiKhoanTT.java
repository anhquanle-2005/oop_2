package tuan9;
import java.util.Scanner;

public class TaiKhoanTT extends TaiKhoan {
    private Scanner sc = new Scanner(System.in);

    public TaiKhoanTT() {
        super();
    }

    public TaiKhoanTT(long soTaiKhoan, long soDu, String chuTk, String matKhau) {
        super(soTaiKhoan, soDu, chuTk, matKhau);
    }
    
    public void guiTien(long soTien) {
        if (soTien > 0) {
            this.setSoDu(this.getSoDu() + soTien);
            System.out.println("Gui tien thanh cong! So du hien tai: " + this.getSoDu());
        } else {
            System.out.println("So tien gui khong hop le.");
        }
    }

    public void chuyenTien(TaiKhoan tkNhan) {
        System.out.println("Nhap so tien can chuyen: ");
        long soTien = sc.nextLong();
        sc.nextLine();

        if (soTien > 0 && soTien <= this.getSoDu()) {
            this.setSoDu(this.getSoDu() - soTien);
            tkNhan.guiTien(soTien);
            System.out.println("Chuyen tien thanh cong! So du hien tai: " + this.getSoDu());
        } else {
            System.out.println("So du khong du hoac so tien khong hop le.");
        }
    }

  
    public void napTien(long x) {
        if (x > 0) {
            this.setSoDu(this.getSoDu() + x);
            System.out.println("Nap tien thanh cong! So du hien tai: " + this.getSoDu());
        } else {
            System.out.println("So tien nap khong hop le.");
        }
    }

public void rutTien() {
    System.out.println("Nhap so tien can rut: ");
    long soTien = sc.nextLong();
    sc.nextLine();

    if (soTien > 0 && soTien <= SoDu) {
        SoDu -= soTien;
        System.out.println("Rut tien thanh cong! So du hien tai: " + SoDu);
    } else {
        System.out.println("So du khong du hoac so tien khong hop le.");
    }
}
}
