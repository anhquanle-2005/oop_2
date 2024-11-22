package taiKhoanNganHang;

public class taiKhoanThanhToan extends taiKhoan {
    public double phiThuongNien;
    public taiKhoanThanhToan()
    {
        // super();
    }
    public taiKhoanThanhToan(String STK, String tenTK, double soDu, String passWord, String maPin, int OTP, String SDT) {
        super(STK, tenTK, soDu, passWord, maPin, OTP, SDT);
    }
    public double getphiThuongNien()
    {
        
        return this.phiThuongNien;
    } 
    // public void setsoDu_tt(double soDu)
    // {
    //     super.getsoDu();
    // }
    public double tinhPhiThuongNien(){
        this.soDu -= phiThuongNien;
        return this.soDu;
    }
    public void nhap_tt()
    {
        super.nhap();
        this.phiThuongNien = 20000;
        tinhPhiThuongNien();
    }
    public void xuat_tt(){
        super.xuat();
    }
    @Override
    public double rutTien(double A) {
        System.out.print("nhap vao ma pin: ");
        String maPinNhap = sc.nextLine();
        do { 
            if(!maPinNhap.equals(maPin))
            {
                System.out.println("ma pin khong dung moi nhap lai !");
                System.out.print("nhap vao ma pin: ");
                maPin = sc.nextLine();
            }
        } while (!maPinNhap.equals(maPin));
        soDu -= A;
        return soDu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(STK).append(";");
        sb.append(tenTK).append(";");
        sb.append(soDu).append(";");
        sb.append(getpassWord()).append(";");
        sb.append(maPin).append(";");
        sb.append(SDT).append(";");
        sb.append("TT");
        return sb.toString();
    }
    @Override
    public double guiTien(double B) {
        System.out.print("nhap vao ma pin: ");
        String maPinNhap = sc.nextLine();
        do { 
            if(!maPinNhap.equals(maPin))
            {
                System.out.println("ma pin khong dung moi nhap lai !");
                System.out.print("nhap vao ma pin: ");
                maPin = sc.nextLine();
            }
        } while (!maPinNhap.equals(maPin));
        do { 
            if(B<=0)
            {
                System.out.println("tien chuyen phai lon hon 0 !");
                System.out.print("nhap so tien can gui: ");
                B = sc.nextDouble();
                sc.nextLine();
            }
        } while (B <=0);
        soDu += B;
        return soDu;
    }

}
