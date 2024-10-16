package oop_2.tuan6.Anh_Quan.baiTap3;

public class Main 
{
    static String chuTk;
    static long soTaiKhoan;
    static long soDu;
    public static void main(String[] args) {
        Tk so1= new Tk(soTaiKhoan, soDu, chuTk);
        so1.nhap();
        so1.guiTien();
        so1.xuat();
        so1.guiTien();
        so1.rutTien();
    }
}
