package tuan7.Anh_Quan.baiTap2 ;

public class Test {
    public static void main(String[] args) {
        Ngay ngay1= new Ngay(10, 12, 2005);
        Ngay ngay2= new Ngay(10, 12, 2006);
        Ngay ngay3= new Ngay(11, 4, 2004);

        Lop lop1= new Lop("23T1",   "khoa cong nghe so");
        Lop lop2= new Lop("23T2", "khoa cong nghe so");
        Lop lop3= new Lop("23T3", "khoa cong nghe so");
        
        SinhVien sv1= new SinhVien("0001", "le gia anhq quan", ngay3, 8.9, lop3);
        SinhVien sv2= new SinhVien("0002", "nguyen thanh manh", ngay1, 1.9, lop1);
        SinhVien sv3= new SinhVien("0003", "nguyen hoai nam", ngay2, 8.9, lop2);

        System.out.println("Khoa:"+sv1.layTenKhoa());
        System.out.println("Khoa:"+sv2.layTenKhoa());
        System.out.println("Khoa:"+sv3.layTenKhoa());

        System.out.println("Sinh vien 2 thi dat hay khong: "+sv2.thiDat());

        System.out.println("Hai sinh vien 1 va 2 co cung ngay sinh khong: "+sv2.kiemTraNgaySinh(sv3));

        System.out.println("Sinh vien 1 hoc luc gi: "+sv1.xepLoai());
    }
}
