package taiKhoanNganHang;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
public abstract class taiKhoan {
    protected String STK;
    protected String tenTK;
    protected double soDu;
    private String passWord;
    protected String maPin;
    protected int OTP;
    protected String SDT;
    
    public Scanner sc = new Scanner(System.in);


    public taiKhoan (){
    }

   
    public taiKhoan(String STK, String tenTK, double soDu, String passWord, String maPin, int OTP, String SDT) {
        this.STK = STK;
        this.tenTK = tenTK;
        this.soDu = soDu;
        setpassWord(passWord);
        this.maPin = maPin;
        setOTP(OTP);
        setSDT(SDT);
    }


    public String getSTK(){
        return this.STK;
    }
    public String gettenTK(){
        return this.tenTK;
    }
    public void setsoDu(double soDu)
    {
        this.soDu = soDu;
    }
    public double getsoDu(){
        return this.soDu;
    }
    public void setMaPin(String maPin) {
        if(maPin.matches("\\d{6}"))
            this.maPin = maPin;
        else
        {
            System.out.println("vui long nhap dung dinh dang (vd:123456)!");
            System.out.print("thiet lap ma pin: ");
            maPin = sc.nextLine();   
            setMaPin(maPin);
        }
    }


    public void setSDT(String SDT) {
        if(SDT.matches("\\d{10}"))
            this.SDT = SDT;
        else{
            System.out.println("So dien thoai khong dung dinh dang !");
            System.out.print("Nhap vao so dien thoai: ");
            SDT = sc.nextLine();
            setSDT(SDT);
        }
    }


    public String getpassWord()
    {
        return this.passWord;
    }
    public String getmaPin()
    {
        return this.maPin;
    }
    public void setOTP(int OTP)
    {
        OTP = 1000 + (int)(Math.random()*9000);
        this.OTP = OTP;
    }
    public int getOTP(){
        return this.OTP;
    }
    public void setpassWord(String passWord){
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
    public void nhap(){
        System.out.print("nhap vao so tai khoan: ");
        STK = sc.nextLine();
        System.out.print("nhap vao ten tai khoan: ");
        tenTK = sc.nextLine();
        System.out.print("nhap vao so du: ");
        soDu = sc.nextDouble();
        sc.nextLine();
        System.out.print("thiet lap passWord: ");
        passWord = sc.nextLine();
        setpassWord(passWord);
        System.out.print("thiet lap ma pin: ");
        maPin = sc.nextLine();
        setMaPin(maPin);
        System.out.print("Nhap vao so dien thoai: ");
        SDT = sc.nextLine();
        setOTP(OTP);
    }
    public void xuat()
    {
        System.out.println("So tai khoan: "+getSTK());
        System.out.println("Ten nguoi dung: "+gettenTK());
        System.out.println("So du: "+getsoDu());
    }
    public void nhapPassDoi(){
        int dem =0;
        int dem1 =0;
        int dem2 =0;
        int dem3 =0;
        setOTP(OTP);
        String passcu, passmoi;
        System.out.print("nhap vao mat khau cu: ");
        passcu = sc.nextLine();
        System.out.print("nhap mat khau moi: ");
        passmoi = sc.nextLine();
        
        while (!passcu.equals(this.passWord)) {
                dem1++;
                if(dem1>=3)
                    throw new IllegalArgumentException("Thao tac sai qua so lan cho phep !");
                System.out.println("mat khau cu khong dung! moi nhap lai");
                System.out.print("nhap vao mat khau cu: ");
                passcu = sc.nextLine();
                System.out.print("nhap mat khau moi: ");
                passmoi = sc.nextLine();
                
            }
        while(passcu.equals(passmoi))
        {
            dem2++;
            if(dem2>=3)
                    throw new IllegalArgumentException("Thao tac sai qua so lan cho phep !");
            System.out.println("Mat khau moi khong duoc trung voi mat khau cu !");
            System.out.print("nhap vao mat khau cu: ");
            passcu = sc.nextLine();
            System.out.print("nhap mat khau moi: ");
            passmoi = sc.nextLine();
           
        }
        System.out.print("nhap vao so dien thoai: ");
        String SDTNhap = sc.nextLine();
        while (!SDTNhap.equals(this.SDT)) {
            dem3++;
            if(dem3>=3)
                throw new IllegalArgumentException("Thao tac sai qua so lan cho phep !");
            System.out.println("So dien thoai khong dung !");
            System.out.print("nhap vao so dien thoai: ");
            SDTNhap = sc.nextLine();
            
        }
        System.out.println("Ma OTP: "+this.OTP);
        System.out.print("Nhap vao OTP: ");
        int OTPNhap = sc.nextInt();
        sc.nextLine();

        while (OTPNhap != this.OTP) { 
            dem++;
            if(dem>=3)
                throw new IllegalArgumentException("thao tac sai nhieu lan !");
            System.out.println("ma OTP khong dung !");
            System.out.print("Nhap vao OTP: ");
            OTPNhap = sc.nextInt();
            sc.nextLine();
            
        }
        setpassWord(passmoi);
        System.out.println("doi pass thanh cong !");
       
    }
    public abstract double  guiTien(double B);
    public abstract double rutTien(double A);
    public void quenMK()
    {   

            setOTP(OTP);
            System.out.print("Nhap vao so dien thoai: ");
            String sdtnhap = sc.nextLine();
            setSDT(sdtnhap);
            int dem = 0;
            while(!sdtnhap.equals(SDT)&&dem<3){
                System.out.println("So dien thoai khong hop le !");
                System.out.print("Nhap vao so dien thoai: ");
                sdtnhap = sc.nextLine();
                dem++;
            }
            if(dem>=3)
                throw new IllegalArgumentException("thao tac sai qua nhieu lan cho phep !");
            System.out.println(getOTP());
            int demotp =0;
            System.out.print("Nhap vao OTP: ");
            int OTPNhap = sc.nextInt();
            sc.nextLine();
            while(OTPNhap != this.OTP && demotp <2){
                System.out.println("ma OTP khong hop le !");
                System.out.print("Nhap vao OTP: ");
                OTPNhap = sc.nextInt();
                demotp ++;
            }
            if(demotp>=3)
                throw new IllegalArgumentException("thao tac sai qua so lan cho phep");
            System.out.print("thiet lap passWord: ");
            String passWordNew = sc.nextLine();
            setpassWord(passWordNew);
    }
    public double chuyentien(double tienChuyen, int A)
    {
        if(A==1)
            soDu += tienChuyen;
        else
            soDu -= tienChuyen;
        return soDu;
    }
}
