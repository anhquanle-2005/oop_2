package tuan6.Hoai_Nam_22.baiTap3;
import java.util.*;
public class taiKhoan {
    static Scanner sc= new Scanner(System.in);
    private int stk;
    private String chuTK;
    private long soDu;
    public int getstk()
    {
        return this.stk;
    }
    public String getchuTK()
    {
        return this.chuTK;
    }
    public long getsoDu()
    {
        return this.soDu;
    }
    public void nhap()
    {
        
        System.out.print("nhap vao so tai khoan: ");
        this.stk = sc.nextInt();
        this.chuTK = sc.nextLine();
        System.out.print("nhap vao chu tai khoan: ");
        this.chuTK = sc.nextLine();
        System.out.print("nhap vao so du: ");
        this.soDu = sc.nextLong();
    }
    public void xuat(){
        System.out.println("STK: "+stk+" - TENTK: "+chuTK+" - SODU: "+soDu);
    }
 
    public long guiTien()
    {
        long tienGui;
        System.out.print("nhap vao so tien can gui: ");
        tienGui = sc.nextLong();
        this.soDu = this.soDu + tienGui;
        return this.soDu;
    }
    public long rutTien()
    {
        long tienRut;
        System.out.print("nhap vao so tien muon rut: ");
        tienRut = sc.nextLong();
        if(this.soDu>0 && this.soDu >= tienRut)
        {
            this.soDu = this.soDu - tienRut;
            return this.soDu;
        }
        System.out.println("so du khong du");
        return this.soDu;   
    }
}
