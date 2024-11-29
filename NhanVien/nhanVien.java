package NhanVien;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public abstract class nhanVien implements InhanVien{
    protected String STK;
    protected String tenNV;
    private String passWord;
    protected LocalDate NgayBD;
    protected String SDT;
    protected double luongCB;
    protected Scanner sc;
    protected int OTP;
    public nhanVien(){}

    public nhanVien(LocalDate NgayBD, String SDT, double luongCB, String maNV, String passWord, String tenNV) {
        this.NgayBD = NgayBD;
        this.SDT = SDT;
        this.luongCB = luongCB;
        this.STK = maNV;
        this.passWord = passWord;
        this.tenNV = tenNV;
    }

    public String getSTK() {
        return STK;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getPassWord() {
        return passWord;
    }
    public void setpassWord(String passWord)
    {
        if(passWord.length() >= 6 &&
        passWord.matches(".*[a-zA-Z]+.*") &&
        passWord.matches(".*[0-9]+.*") &&
        passWord.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*"))
            this.passWord = passWord;
        else
        {
            System.out.println("mat khau phai co chu so, chu cai va ki tu dac biet !");
            System.out.print("thiet lap passWord: ");
            passWord = sc.nextLine();
            setpassWord(passWord);
        }
    }
    public void setOTP(int OTP)
    {
        OTP = 1000 + (int)(Math.random()*9000);
        this.OTP = OTP;
    }
    public LocalDate getNgayBD() {
        return NgayBD;
    }

    public String getSDT() {
        return SDT;
    }
    public void setSDT(String SDT)
    {
        if(SDT.matches("\\d{10}"))
            this.SDT = SDT;
        else{
            System.out.println("So dien thoai khong dung dinh dang !");
            System.out.print("Nhap vao so dien thoai: ");
            SDT = sc.nextLine();
            setSDT(SDT);
        }
    }
    public double getLuongCB() {
        return luongCB;
    }
    public void nhap()
    {
         sc = new Scanner(System.in);
        System.out.print("nhap vao so tai khoan: ");
        STK = sc.nextLine();
        System.out.print("nhap vao ten nhan vien: ");
        tenNV = sc.nextLine();
        System.out.print("nhap vao passWork: ");
        passWord = sc.nextLine();
        System.out.print("nhap vao luong co ban: ");
        luongCB = sc.nextDouble();
        sc.nextLine();
        System.out.print("nhapp vao so dien thoai: ");
        SDT = sc.nextLine();
        setSDT(SDT);
        System.out.print("nhap vao ngay bat dau theo dinh dang (yyyy-MM-dd): ");
        String date = sc.nextLine();
        try {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           NgayBD = LocalDate.parse(date,formatter);
        } catch (Exception e) {
            // TODO: handle exception
        }
        setOTP(OTP);
    }
    public abstract double tinhLuong();
    public void doiMK(String passcu, String passmoi)
    {
            setpassWord(passmoi);
    }
    public void quenpass()
    {
        String passWord;
        String sdt;
        int dem=0,dem1=0;
        int otp;
        System.out.print("thiet lap mat khau moi :");
        passWord = sc.nextLine();
        System.out.print("Nhap vao so dien thoai: ");
        sdt=sc.nextLine();
        while(!sdt.equals(this.SDT))
        {
            dem++;
            System.out.println("Nhap vao so dien thoai: ");
            sdt=sc.nextLine();
            if(dem ==3)
                break;
        }
        if(dem>=3)
            throw new IllegalArgumentException("thao tac sai qua so lan cho phep !");
        System.out.println(OTP);
        System.out.print("nhap vao OTP: ");
        otp=sc.nextInt();
        sc.nextLine();
        while(otp!=OTP)
        {
            dem1++;
            System.out.print("nhap vao OTP: ");
            otp=sc.nextInt();
            sc.nextLine();
            if(dem1==3)
                break;
        }
        if(dem1>=3)
            throw new IllegalArgumentException("thao tac sai qua so lan cho phep !");
        setpassWord(passWord);
        System.out.println("Doi mat khau thanh cong !");
    }
    public abstract void chamCong();

}
