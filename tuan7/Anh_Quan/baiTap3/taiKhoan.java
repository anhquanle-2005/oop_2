package tuan7.Anh_Quan.baiTap3;
import java.util.Scanner;
public class taiKhoan {
    private long soTaiKhoan;
    private long soDu;
    private String chuTk;
    private String matKhau;
    
    public taiKhoan(long soTaiKhoan, long soDu, String chuTk, String matKhau) {
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
        


    
}   
