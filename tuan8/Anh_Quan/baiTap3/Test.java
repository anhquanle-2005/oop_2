package oop_2.tuan8.Anh_Quan.baiTap3;

public class Test {
    public static void main(String[] args) {
        Ngay ngay1= new Ngay(12, 10, 2024);
        Ngay ngay2=new Ngay(13, 9, 2024);
        Ngay ngay3=new Ngay(14, 10, 2024);
        Ngay ngay4=new Ngay(16, 11, 2024);
        Ngay ngay5=new Ngay(18, 12, 2024);
        Ngay ngay6=new Ngay(15, 1, 2024);


        Bao bao1= new Bao("001", "Bao moi ", ngay1, 5);
        System.out.println("Ma tai lieu cua bao 1: "+bao1.getMtl());
        System.out.println("Ten cua bao 1: "+bao1.getTenTaiLieu());
        System.out.println("Ngay xuat ban cua bao 1: "+bao1.NgayXuatBan.toString());
        bao1.soTrang();

        Bao bao2= new Bao("002", "Bao moi ", ngay2, 7);
        System.out.println("Ma tai lieu cua bao 2: "+bao2.getMtl());
        System.out.println("Ten cua bao 2: "+bao2.getTenTaiLieu());
        System.out.println("Ngay xuat ban cua bao 2: "+bao2.NgayXuatBan.toString());
        bao2.soTrang();

        Sach sach1 = new Sach("100", "Sach tu vung", ngay1, 500);
        System.out.println("Ma tai lieu cua sach 1: "+sach1.getMtl());
        System.out.println("Ten cua sach 1: "+sach1.getTenTaiLieu());
        System.out.println("Ngay xua ban cua sach  1"+sach1.NgayXuatBan.toString());
        sach1.thongTin();

        Sach sach2 = new Sach("101", "Sach ngu phap", ngay2, 350);
        System.out.println("Ma tai lieu cua sach 2: "+sach2.getMtl());
        System.out.println("Ten cua sach 2: "+sach2.getTenTaiLieu());
        System.out.println("Ngay xua ban cua sach  2"+sach2.NgayXuatBan.toString());
        sach2.thongTin();

        TapChi tapChi1= new TapChi("200", "Tap chi Anime", ngay1, 50);
        System.out.println("Ma tai lieu cua tap chi 1:"+tapChi1.getMtl());
        System.out.println("Ten cua tap chi 1: "+tapChi1.getTenTaiLieu());
        System.out.println("Ngay xuat ban cua tap chi 1: "+tapChi1.NgayXuatBan.toString());
        tapChi1.soPH();

        TapChi tapChi2= new TapChi("201", "Tap chi ve xe hoi", ngay5, 100);
        System.out.println("Ma tai lieu cua tap chi 2:"+tapChi2.getMtl());
        System.out.println("Ten cua tap chi 2: "+tapChi2.getTenTaiLieu());
        System.out.println("Ngay xuat ban cua tap chi 2: "+tapChi2.NgayXuatBan.toString());
        tapChi2.soPH();
    }
}
