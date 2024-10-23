package tuan7.Hoai_Nam_22.baitap3;
import java.util.Scanner;
public class taiKhoan {
    private long STK;
    private String tenTK;
    private long soDu;
    private String passWork;
    private long tienGui;
    private long tienRut;
    public Scanner sc = new Scanner(System.in);
    public taiKhoan (){}
    public long getSTK(){
        return this.STK;
    }
    public String gettenTK(){
        return this.tenTK;
    }
    public long getsoDu(){
        return this.soDu;
    }
    public String getpassWork()
    {
        return this.passWork;
    }
    public long gettienGui(){
        return this.tienGui;
    }
    public long gettienRut(){
        return this.tienRut;
    }
    public void setpassWork(String passWork)
    {
        if(passWork.length()>=6)
            this.passWork = passWork;
        else
            throw new IllegalArgumentException("mat khau phai nhieu hon 6 ki tu");
    }
    public void settienGui(long tienGui){
        if(tienGui>0)
            this.tienGui = tienGui;
        else
        throw new IllegalArgumentException("tien gui phai lon hon 0");
    }
    public void settienRut(long tienRut){
        if(this.soDu>0 && this.soDu >= tienRut)
            this.tienRut = tienRut;
        else
        throw new IllegalArgumentException("so du khong du");
    }
    public void nhap(){
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
       
        
    }
    public void xuat(){
        System.out.println(getSTK()+" - "+gettenTK()+" - "+getsoDu());
    }
    public void doiPass(String matKhauCu, String matKhauMoi)
    {
        if(matKhauCu.equals(this.passWork))
        {
            setpassWork(matKhauMoi);
            System.out.println("doi pass thanh cong !");
        }
        else
           throw new IllegalArgumentException("mat khau cu khong dung");
    }
    public void nhapPassDoi(){
        String passcu, passmoi;
        System.out.print("nhap vao mat khau cu: ");
        passcu = sc.nextLine();
        System.out.print("nhap mat khau moi: ");
        passmoi = sc.nextLine();
        doiPass(passcu, passmoi);
    }
    public long guiTien()
    {
        System.out.print("nhap vao so tien can gui: ");
        tienGui = sc.nextLong();
        this.soDu = this.soDu + tienGui;
        return this.soDu;
    }
    public long rutTien()
    {
        System.out.print("nhap vao so tien muon rut: ");
        tienRut = sc.nextLong();
        this.soDu = this.soDu - tienRut;
        return this.soDu; 
    }
    
}
