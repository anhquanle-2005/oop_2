package tuan9;
import java.util.ArrayList;
public class BankServer {
    private ArrayList <TaiKhoan> DanhSach;

    public BankServer(){
        this.DanhSach= new ArrayList<TaiKhoan>();
    }
    public BankServer (ArrayList <TaiKhoan> DanhSach)
    {
        DanhSach=DanhSach;
    }
    public void ThemTaiKhoan(TaiKhoan tk)
    {
        this.DanhSach.add(tk);
    }
    public TaiKhoan DangNhap(long soTaiKhoan, String matKhau) {
        for (TaiKhoan tk : DanhSach) {
            if (tk.getSoTaiKhoan() == soTaiKhoan && tk.kiemTraMatKhau(matKhau)) {
                return tk; // Đăng nhập thành công
            }
        }
        return null; // Đăng nhập thất bại
    }
    //xóa tài khoản
    public boolean xoaTaiKhoan(TaiKhoan tk)
    {
        return this.DanhSach.remove(tk);
    }

    public TaiKhoan timTaiKhoan(long soTaiKhoan) {
        for (TaiKhoan tk : DanhSach) {
            if (tk.getSoTaiKhoan() == soTaiKhoan) {
                return tk;
            }
        }
        return null;
    }
    
}

