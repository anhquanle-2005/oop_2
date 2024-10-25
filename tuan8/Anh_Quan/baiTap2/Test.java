package tuan8.Anh_Quan.baiTap2;

public class Test {
    public static void main(String[] args) {
        NhanVienSanXuat nv1= new NhanVienSanXuat("2311", "Nguyen Van A", 5000, 10);
        System.out.println("Ma nhan vien cua nhan vien san xuat:"+nv1.getMnv());
        System.out.println("Ten cua nhan vien san xuat:"+nv1.getTen());
        System.out.println("San pham nhan vien nay lam:"+nv1.getSanPham());
        nv1.luong();
        
        NhanVienVanPhong nv2= new NhanVienVanPhong("2312", "Tran Thi B", 10000, 1.5);
        System.out.println("Ma nhan vien cua nhan vien van phong:"+nv2.getMnv());
        System.out.println("Ten cua nhan vien van phong:"+nv2.getTen());
        System.out.println("He so luong cua nhan vien van phong:"+nv2.getHeSo());
        nv2.luongVP();
    }
}
