package tuan7.hoainam22.baitap3;

public class baiTap {
    public static void main(String[] args) {
        taiKhoan tk = taiKhoan.nhap();
        tk.xuat();
        tk.nhapPassDoi();
        System.out.println("pass sau khi doi: ");
        tk.xuat();
    }
}
