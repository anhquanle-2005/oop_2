package taiKhoanNganHang;

public class taiKhoanTietKiem extends taiKhoan {
    protected double laiSuat;
    public taiKhoanTietKiem(){}
    public double getlaiSuat(){
        return this.laiSuat;
    }
    public taiKhoanTietKiem(String STK, String tenTK, double soDu, String passWord, String maPin, int OTP, String SDT) {
        super(STK, tenTK, soDu, passWord, maPin, OTP, SDT);
    }
    public double tinhLaiSuat(double tienGuiTK){
        int thg;
        System.out.println("-------------------");
        System.out.println("| chu ki 1 thang  |");
        System.out.println("| chu ki 2 thang  |");
        System.out.println("| chu ki 3 thang  |");
        System.out.println("| chu ki 6 thang  |");
        System.out.println("| chu ki 9 thang  |");
        System.out.println("| chu ki 12 thang |");
        System.out.println("| chu ki 24 thang |");
        System.out.println("| chu ki 36 thang |");
        System.out.println("| chu ki 48 thang |");
        System.out.println("| chu ki 60 thang |");
        System.out.println("-------------------");
        System.out.print("so chu ki gui (thang): ");
            thg = sc.nextInt();
        switch (thg) {
            case 1:
                laiSuat=(soDu*0.016);
                break;
            case 2:
                laiSuat=(soDu*0.016);
                break;
            case 3:
                laiSuat = (soDu*0.019);
                break;
            case 6:
                laiSuat = (soDu*0.029);
                break;
            case 9:
                laiSuat = (soDu*0.029);
                break;
            case 12:
                laiSuat = (soDu*0.046);
                break;
            case 24, 36, 48, 60:
                laiSuat = (soDu*0.047);
                break;
            default:
                System.out.println("lua chon khong hop le, vui long chon lai !");
        }
        return laiSuat;
    }
    
    @Override
    public double rutTien(double A) {
        System.out.print("Nhap vao ma pin: ");
        String maPinNhap = sc.nextLine();
        do
         { 
            if(!maPinNhap.equals(maPin))
            {
                System.out.println("ma pin khong dung moi nhap lai !");
                System.out.print("nhap vao ma pin: ");
                maPin = sc.nextLine();
            }
        } while (!maPinNhap.equals(maPin));
        do
        { 
            if(A<=0||A>soDu)
            {
                System.out.println("tien rut phai lon hon 0 hoac so du khong du !");
                System.out.print("nhap so tien can rut: ");
                A = sc.nextLong();
                sc.nextLine();
            }
        } while (A<=0||A>soDu);
        soDu -= A;
        return soDu;
    } 
    // public void guiTK(){
    //     System.out.print("nhap vao tien gui tiet kiem: ");
    //     double tien = sc.nextDouble();
    //     tinhLaiSuat(tien);
    // }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(STK).append(";");
        sb.append(tenTK).append(";");
        sb.append(soDu).append(";");
        sb.append(getpassWord()).append(";");
        sb.append(maPin).append(";");
        sb.append(SDT).append(";");
        sb.append("TK");
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
        tinhLaiSuat(B);
        soDu = soDu +B+ laiSuat;
        return soDu;
    }
}
