package tuan6.Anh_Quan.baiTap3;
import java.util.*;
public class Tk 
{
    static Scanner sc;
    private int soTaiKhoan;
    private long soDu;
    private String chuTK; 

    public Tk (long soTaiKhoan, long soDu, String chuTK)
    {
        this.soTaiKhoan=soTaiKhoan;
        this.soDu=soDu;
        this.chuTK=chuTK;
    }

    public void nhap()
    {
        sc= new Scanner(System.in);
        System.out.println("nhap so tai khoan:");
        this.soTaiKhoan=sc.nextInt();
        System.out.println("ten cua chu tai khoan");
        this.chuTK=sc.nextLine();
        System.out.println("nhap vao so du");
        this.soDu=sc.nextLong();
    }
    public void xuat ()
    {
        System.out.println(this.chuTK+"-"+this.soTaiKhoan+"-"+this.soDu);
    }
    public int guiTien()
    {
        sc=new Scanner(System.in);
        long guiTien;
        System.out.println("nhap so tien muon gui:");
        guiTien=sc.nextLong();
        this.soDu=this.soDu+guiTien;
        return this.soDu;
    }
    public int rutTien()
    {
        long rut;
        sc=new Scanner(System.in);
        System.out.println("so tien muon rut la:");
        rut=sc.nextLong();
        if(this.soDu>0 &&this.soDu > rut)
        {
            this.soDu=this.soDu-rut;
            return this.soDu;
        }
        else    
        {
            System.out.println("so du khong du");
            return this.soDu;
        }
    }

}
