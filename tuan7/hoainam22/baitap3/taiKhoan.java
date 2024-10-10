package tuan7.hoainam22.baitap3;

import java.util.Scanner;

public class taiKhoan {
    private long STK;
    private String tenTK;
    private long soDu;
    private String passWork;
    public taiKhoan (long STK, String tenTK, long soDu, String passWork)
    {
        this.STK = STK;
        this.tenTK = tenTK;
        this.soDu =soDu;
        setpassWork(passWork);
    }
    public long getSTK(){
        return this.STK;
    }
    public String gettenTK(){
        return this.tenTK;
    }
    public long getsoDu(){
        return this.soDu;
    }
    public void setpassWork(String passWork)
    {
        if(passWork.length()>=6)
            this.passWork = passWork;
        else
            throw new IllegalArgumentException("mat khau phai nhieu hon 6 ki tu");
    }
    public static taiKhoan nhap(){
        long STK, soDu;
        Scanner sc = new Scanner(System.in);
        String tenTK,passWork;
        System.out.print("nhap vao so tai khoan: ");
        STK = sc.nextLong();
        tenTK = sc.nextLine();
        System.out.print("nhap vao ten tai khoan: ");
        tenTK = sc.nextLine();
        System.out.print("nhap vao so du: ");
        soDu = sc.nextLong();
        passWork = sc.nextLine();
        System.out.print("thiet lap passwork: ");
        passWork = sc.nextLine();
        return new taiKhoan(STK, tenTK, soDu, passWork);
    }
    public void xuat(){
        System.out.println(this.STK+" - "+this.tenTK+" - "+this.soDu+" - "+this.passWork);
    }
    public void doiPass(String matKhauCu, String matKhauMoi)
    {
        if(matKhauCu.equals(this.passWork))
            setpassWork(matKhauMoi);
        else
           throw new IllegalArgumentException("mat khau cu khong dung");
    }
    public void nhapPassDoi(){
        System.out.print("ban co muon doi mat khau khong (1|0): ");
        int n;
        String passcu, passmoi;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        if(n==1)
        {
            System.out.print("nhap vao mat khau cu: ");
            passcu = sc.nextLine();
            System.out.print("nhap mat khau moi: ");
            passmoi = sc.nextLine();
            doiPass(passcu, passmoi);
        }
    }
}
