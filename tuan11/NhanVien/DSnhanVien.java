package NhanVien;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DSnhanVien {
    protected ArrayList<nhanVien> NHANVIEN ;
    protected int s;
    protected Scanner sc;
    public DSnhanVien() {
        NHANVIEN = new ArrayList<>();
    }
    public void themNhanVienFT(){
        nhanVienFullTime NVFT = new nhanVienFullTime();
        NVFT.nhapFT();
        NHANVIEN.add(NVFT);
        try {
            FileWriter fw = new FileWriter("nhanvien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void themNhanVienPT()
    {
        nhaVienPartTime NVPT = new nhaVienPartTime();
        NVPT.nhappt();
        NHANVIEN.add(NVPT);
        try {
            FileWriter fw = new FileWriter("nhanvien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void xoaNV(String STK)
    {
        NHANVIEN.removeIf(nhanVien -> STK.equals(nhanVien.STK));
    }
    public void DangNhap(String STK, String password, int dem)
    {
        for (int i = 0; i < NHANVIEN.size(); i++) {
            if(STK.equals(NHANVIEN.get(i).STK)&&password.equals(NHANVIEN.get(i).getPassWord()))
            {
                dem=1;
                s=i;
                System.out.println("Dang nhap thanh cong !");
                break;
            }   
        }

    }
    public void thongTinChiTiet()
    {
        System.out.println("STK: "+NHANVIEN.get(s).STK);
        System.out.println("Tên nhân viên: "+NHANVIEN.get(s).tenNV);
        System.out.println("Ngay bat dau lam viec: "+NHANVIEN.get(s).NgayBD);
        System.out.println("So dien thoai: "+NHANVIEN.get(s).SDT);
        System.out.println("Luong co ban: "+NHANVIEN.get(s).luongCB);
        System.out.println("Luong: "+NHANVIEN.get(s).tinhLuong());
        if(NHANVIEN.get(s) instanceof nhanVienFullTime)
            System.out.println("Phu cap: "+((nhanVienFullTime) NHANVIEN.get(s)).phuCap);
        else
            System.out.println("So gio lam: "+((nhaVienPartTime) NHANVIEN.get(s)).gio);
    }
    public void doiMK()
    {
        sc = new Scanner(System.in);
        int dem =0;
        String passcu, passmoi;
        do { 
            if(dem<3)
                dem++;
            else
                throw new IllegalArgumentException("thao tac sai qua so lan cho phep !");
            System.out.print("Nhap vao mat khau: ");
            passcu= sc.nextLine();
            System.out.print("nhap vao mat khau moi: ");
            passmoi=sc.nextLine();
            if(passcu.equals(NHANVIEN.get(s).getPassWord()))
            {
                NHANVIEN.get(s).setpassWord(passmoi);
                break;
            }
        } while (true);
        
    }
    public void thongtinNV()
    {
        for (nhanVien nv : NHANVIEN) {
            System.out.println("STK: "+nv.STK);
            System.out.println("Tên nhân viên: "+nv.tenNV);
            System.out.println("Ngay bat dau lam viec: "+nv.NgayBD);
            System.out.println("So dien thoai: "+nv.SDT);
            System.out.println("Luong co ban: "+nv.luongCB);
            System.out.println("Luong: "+nv.tinhLuong());
            if(nv instanceof nhanVienFullTime)
                System.out.println("Phu cap: "+((nhanVienFullTime) nv).phuCap);
            else
                System.out.println("So gio lam: "+((nhaVienPartTime) nv).gio);
        }
    }
    public void quenpass()
    {
        NHANVIEN.get(s).quenpass();
    }
}
