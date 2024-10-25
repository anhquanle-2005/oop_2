package tuan7.Anh_Quan.Project_tuan7;
import java.util.Scanner;
public class TaiKhoan {
    private long soTaiKhoan;
    private long soDu;
    private String chuTk;
    private String matKhau;
    
    public TaiKhoan(long soTaiKhoan, long soDu, String chuTk, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
        this.chuTk = chuTk;
        this.matKhau = matKhau;
    }

    public long getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public void setSoTaiKhoan(long soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
    public long getSoDu() {
        return soDu;
    }
    public void setSoDu(long soDu) {
        this.soDu = soDu;
    }
    public String getChuTk() {
        return chuTk;
    }
    public void setChuTk(String chuTk) {
        this.chuTk = chuTk;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }


    // public void dangNhap(long soTaiKhoanNhapVao, String matKhauNhapVao)
    // {
    //     if(kiemTraSoTaiKhoan(soTaiKhoanNhapVao)&&kiemTraMatKhau(matKhauNhapVao))
    //             System.out.println("Dang nhap thanh cong");
    // }

    // public boolean kiemTraSoTaiKhoan(long soTaiKhoanNhapVao)
    // {
    //     if(this.soTaiKhoan==soTaiKhoanNhapVao)
    //         return true;
    //     else 
    //         return false;
    // }
    public boolean kiemTraMatKhau (String matKhau)
    {
        return this.matKhau.equals(matKhau);
    }
    public long guiTien(long x){
        return this.soDu+x;
    }

    public long rutTien(long x){
        if(this.soDu>=x)
            return this.soDu-x;
        else 
            {
                System.out.println("Tai khoan cua quy khach hien khong du");
                return this.soDu;
            }
    }
    public void Nhap()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap vao so tai khoan:");
        this.soTaiKhoan= sc.nextLong();
        sc.nextLine(); 
        System.out.println("Nhap vao ten cua chu tai khoan:");
        this.chuTk= sc.nextLine();
        System.out.println("Nhap vao so du cua tai khoan nay:");
        this.soDu= sc.nextLong();
        sc.nextLine();
        System.out.println("Mat khau cua tai khoan: ");
        this.matKhau= sc.nextLine();
    }

    public void Xuat()
    {
        System.out.println("============================");
        System.out.println("So tai khoan: "+this.soTaiKhoan);
        System.out.println("Ten cua chu tai khoan: "+this.chuTk);
        System.out.println("So du cua tai khoan nay: "+this.soDu);
        System.out.println("Mat khau cua tai khoan: "+this.matKhau);
        System.out.println("============================");
    }

    @Override
    public String toString() {
        return "[soTaiKhoan=" + soTaiKhoan + ", soDu=" + soDu + ", chuTk=" + chuTk + ", matKhau=" + matKhau
                + "]";
    }

    
}
