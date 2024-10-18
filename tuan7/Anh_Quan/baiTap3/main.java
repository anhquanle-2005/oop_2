package oop_2.tuan7.Anh_Quan.baiTap3;

import java.util.Scanner;

public class main {
    static Scanner sc;
    static long Gui, Rut;
    static int buoc;
    public static void main(String[] args) {
        sc =new Scanner(System.in);
        taiKhoan tk1= new taiKhoan(1005, 3000000, "Le Gia Anh Quan", "123");
        do
        {
            System.out.println("Xin chao quy khach toi co the giup gi cho ban");
            System.out.println("Nhap 1: De biet ve thong tin cua ban than");
            System.out.println("Nhap 2: De gui tien vao tai khoan cua ban");
            System.out.println("Nhap 3: De rut tien tu tai khoan cua quy khach");
            System.out.println("Nhap 4: Neu quy khach muon doi mat khau cua tai khoan hien tai");
            System.out.println("Nhap 0: De thoat khoi vong lap");
            System.out.println("Quy khach muon lam buoc nao:");
            buoc=sc.nextInt();

            switch (buoc) {
                case 1:
                    // in thông tin co ban cua chu tai khoan 1
                    System.out.println("Thong tin ve tai khoan 1 la: "+tk1);
                    break;
                case 2: 
                    //nhập số tiền bạn muốn gửi là bao nhiêu
                    System.out.println("So tien ban muon gui la bao nhieu:");
                    Gui=sc.nextLong();
                    //keu phuong thuc gui tien vao
                    System.out.println("So tai khoan cua quy khach sau khi gui la:"+tk1.guiTien(Gui));
                    break;
                case 3:
                    //keu phuong thuc rut tien
                    System.out.println("Quy khach muon rut so tien la bao nhieu:");
                    Rut=sc.nextLong();
                    System.out.println("So tai khoan cua quy khach sau khi rut la:"+tk1.rutTien(Rut));
                    break;
                case 4:
                    // em chua hieu cach lam
            }
        }
        while(buoc!=0);

    }   
}
