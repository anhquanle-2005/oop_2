package TH.Tuan7.baiTap3;
public class baiTap3 {
    public static void main(String[] args) {
        TaiKhoan tk = TaiKhoan.Nhap();
        tk.Xuat();
        tk.NhapPassDoi();
        System.out.println("Pass sau khi thay đổi: ");
        tk.Xuat();
    }
}