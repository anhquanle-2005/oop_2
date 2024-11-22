package tuan10;
import java.util.Scanner;
import java.io.Serializable;
import java.util.Calendar;

public class TaiKhoanTK extends TaiKhoan implements Serializable{
    private Double tienTK;
    
    public TaiKhoanTK() {
        this.tienTK = 0.0;
    }

    public TaiKhoanTK(String soTaiKhoan, Double soDu, String chuTk, String matKhau, String cccd, int SDT, String EMAIL, int pin, Double tienTK) { 
        super(soTaiKhoan, soDu, chuTk, matKhau, cccd, SDT, EMAIL, pin); 
        this.tienTK = tienTK; 
    }

    public double getTienTK() {
        return this.tienTK;
    }

    public void setTienTK(Double tienTK) {
        this.tienTK = tienTK;
    }

    @Override
    public void chuyenTien(TaiKhoan tkNhan) {
    }

    @Override
    public void guiTien(Double x) {
        if (x > 0) {
            this.setSoDu(this.getSoDu() + x);
            System.out.println("Gui tien thanh cong! So du hien tai: " + this.getSoDu());
        } else {
            System.out.println("So tien gui phai lon hon 0.");
        }
    }

    @Override
    public void napTien(Double x) {
        Scanner sc = new Scanner(System.in);  
        int luaChon;
        Double laiXuat = 0.0;
        this.setTienTK(x);
        Calendar cal = Calendar.getInstance();
        do {
            System.out.println("So tien trong tai khoan tiet kiem: " + this.tienTK);
            System.out.println("Ban co cac lua chon sau khi muon mo tai khoan tiet kiem");
            System.out.println("1. Tiet kiem dien tu");  
            System.out.println("2. Tiet kiem gui gop");
            System.out.println("0. Thoat");
            System.out.println("Ban se gui tiet kien cach nao: ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    System.out.println("Ban da chon gui tiet kiem dien tu");
                    if (x < 1000000) {
                        System.out.println("So tien toi thieu 1,000,000 VND");
                    } else {
                        System.out.println("Hay chon ky han ma ban muon co laiXuat");
                        System.out.println("1.  1  tuan  - 0.5%/Year");
                        System.out.println("2.  2  tuan  - 0.5%/Year");
                        System.out.println("3.  3  tuan  - 0.5%/Year");
                        System.out.println("4.  1  thang - 3.5%/Year");
                        System.out.println("5.  2  thang - 3.7%/Year");
                        System.out.println("6.  3  thang - 3.8%/Year");
                        System.out.println("7.  6  thang - 4.7%/Year");
                        System.out.println("8.  9  thang - 4.8%/Year");
                        System.out.println("9.  12 thang - 5.2%/Year");
                        System.out.println("10. 18 thang - 5.4%/Year");
                        System.out.println("11. 24 thang - 5.7%/Year");
                        System.out.println("12. 36 thang - 5.7%/Year");
                        System.out.println("Lua chon cua ban la:");
                        int y = sc.nextInt();
                        System.out.println("Ngay bat dau");
                        System.out.println(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));

                        switch (y) {
                            case 1:
                                laiXuat = 0.005 / 52;
                                cal.add(Calendar.WEEK_OF_YEAR, 1);
                                break;
                            case 2:
                                laiXuat = 0.005 / 26;
                                cal.add(Calendar.WEEK_OF_YEAR, 2);
                                break;
                            case 3:
                                laiXuat = 0.005 / 13;
                                cal.add(Calendar.WEEK_OF_YEAR, 3);
                                break;
                            case 4:
                                laiXuat = 3.5 / 100 / 12;
                                cal.add(Calendar.MONTH, 1);
                                break;
                            case 5:
                                laiXuat = 3.7 / 100 / 6;
                                cal.add(Calendar.MONTH, 2);
                                break;
                            case 6:
                                laiXuat = 3.8 / 100 / 4;
                                cal.add(Calendar.MONTH, 3);
                                break;
                            case 7:
                                laiXuat = 4.7 / 100 / 2;
                                cal.add(Calendar.MONTH, 6);
                                break;
                            case 8:
                                laiXuat = 4.8 / 100 / 12 * 9;
                                cal.add(Calendar.MONTH, 9);
                                break;
                            case 9:
                                laiXuat = 5.2 / 100;
                                cal.add(Calendar.MONTH, 12);
                                break;
                            case 10:
                                laiXuat = 5.4 / 100 / 12 * 18;
                                cal.add(Calendar.MONTH, 18);
                                break;
                            case 11:
                                laiXuat = 5.7 / 100 * 2;
                                cal.add(Calendar.MONTH, 24);
                                break;
                            case 12:
                                laiXuat = 5.7 / 100 * 3;
                                cal.add(Calendar.MONTH, 36);
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                                continue;
                        }

                        Double tienLai = x * laiXuat;
                        this.tienTK = x + tienLai;
                        System.out.println("Ngay ket thuc");
                        System.out.println(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
                        System.out.printf("So tien du tinh sau ky han la: %.3f%n", this.tienTK);
                    }
                    break;
                case 2: 
                    System.out.println("Ban da chon tiet kiem gui gop");
                    if(x < 100000)
                        System.out.println("Tien gui toi thieu la hon 100,000 VND");
                    else {
                        System.out.println("1.  1  thang - 0.5%/Year");
                        System.out.println("2.  2  thang - 3.8%/Year");
                        System.out.println("3.  3  thang - 3.8%/Year");
                        System.out.println("4.  6  thang - 3.8%/Year");
                        System.out.println("5.  9  thang - 3.8%/Year");
                        System.out.println("6.  12 thang - 3.8%/Year");
                        System.out.println("7.  18 thang - 3.8%/Year");
                        System.out.println("8.  24 thang - 3.8%/Year");
                        System.out.println("9.  36 thang - 3.8%/Year");
                        System.out.println("Lua chon cua ban la:");
                        int y = sc.nextInt();
                        System.out.println("Ngay bat dau");
                        System.out.println(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
                        
                        switch (y) {
                            case 1:
                                laiXuat = 0.5 / 100 / 12;
                                cal.add(Calendar.MONTH, 1);
                                break;
                            case 2:
                                laiXuat = 3.8 / 100 / 6;
                                cal.add(Calendar.MONTH, 2);
                                break;
                            case 3:
                                laiXuat = 3.8 / 100 / 4;
                                cal.add(Calendar.MONTH, 3);
                                break;
                            case 4:
                                laiXuat = 3.8 / 100 / 2;
                                cal.add(Calendar.MONTH, 6);
                                break;
                            case 5:
                                laiXuat = 3.8 / 100 / 12 * 9;
                                cal.add(Calendar.MONTH, 9);
                                break;
                            case 6:
                                laiXuat = 3.8 / 100;
                                cal.add(Calendar.MONTH, 12);
                                break;
                            case 7:
                                laiXuat = 3.8 / 100 / 12 * 18;
                                cal.add(Calendar.MONTH, 18);
                                break;
                            case 8:
                                laiXuat = 3.8 / 100 * 2;
                                cal.add(Calendar.MONTH, 24);
                                break;
                            case 9:
                                laiXuat = 3.8 / 100 * 3;
                                cal.add(Calendar.MONTH, 36);
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                                break;
                        }
                        Double tienLai = x * laiXuat;
                        this.tienTK = x + tienLai;
                        System.out.println("Ngay ket thuc");
                        System.out.println(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
                        System.out.printf("So tien du tinh sau ky han la: %.3f%n", this.tienTK);
                    }
                    break;
                default:
                    System.out.println("Ban thoat");
                    this.tienTK = x + x * laiXuat;
                    break;
            } 
        } while (luaChon != 0);
    }

    @Override
    public String toString() {
        return "TaiKhoanTK [tienTK=" + tienTK + ", pin=" + pin + ", soTaiKhoan=" + soTaiKhoan + ", SoDu=" + SoDu
                + ", chuTk=" + chuTk + ", matKhau=" + matKhau + ", getTienTK()=" + getTienTK() + ", getCccd()="
                + getCccd() + ", getSDT()=" + getSDT() + ", getEMAIL()=" + getEMAIL() + ", getPin()=" + getPin()
                + ", getSoTaiKhoan()=" + getSoTaiKhoan() + ", getSoDu()=" + getSoDu() + ", getChuTk()=" + getChuTk()
                + ", getMatKhau()=" + getMatKhau() + "]";
    }

    @Override
    public void rutTien() {
    }
}