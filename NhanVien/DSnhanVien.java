package NhanVien;

import static java.nio.file.Files.readAllLines;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSnhanVien {
    protected ArrayList<nhanVien> NHANVIEN ;
    protected int s =-1;
    protected Scanner sc;
    public DSnhanVien() {
        NHANVIEN = new ArrayList<>();
        try {
            FileReader fr = new FileReader("nhanvien.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) { 
                line = br.readLine();
                if(line == null)
                    break;
                String txt[] = line.split(";");
                String stk = txt[0];
                String name = txt[1];
                String mk = txt[2];
                String date = txt[3];
                String sdt = txt[4];
                double luong =Double.parseDouble(txt[5]);
                double phucap = Double.parseDouble(txt[6]);
                int cong = Integer.parseInt(txt[7]);
                int gio = Integer.parseInt(txt[8]);
                LocalDate ngaybd;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                ngaybd = LocalDate.parse(date,formatter);
                if(txt[7]==null)
                {
                    nhanVienFullTime nvft = new nhanVienFullTime(phucap, ngaybd, sdt, luong,stk, mk, name,cong);
                    NHANVIEN.add(nvft);
                }
                else{
                    nhaVienPartTime nvpt = new nhaVienPartTime(gio,ngaybd,sdt,luong,stk,mk,name);
                    NHANVIEN.add(nvpt);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public void themNhanVienFT(){
        nhanVienFullTime NVFT = new nhanVienFullTime();
        NVFT.nhapFT();
        NHANVIEN.add(NVFT);
        try {
            FileWriter fw = new FileWriter("nhanvien.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(NVFT.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void themNhanVienPT()
    {
        nhaVienPartTime NVPT = new nhaVienPartTime();
        NVPT.nhap();
        NHANVIEN.add(NVPT);
        try {
            FileWriter fw = new FileWriter("nhanvien.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(NVPT.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void xoaNV(String STK)
    {
        NHANVIEN.removeIf(nhanVien -> STK.equals(nhanVien.STK));
        System.out.println("Cap nhat thanh cong !");
    }
    public void DangNhap(String STK, String password)
    {
        for (int i = 0; i < NHANVIEN.size(); i++) {
            if(STK.equals(NHANVIEN.get(i).STK)&&password.equals(NHANVIEN.get(i).getPassWord()))
            {
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
        {
             System.out.println("So cong tich luy: "+((nhanVienFullTime) NHANVIEN.get(s)).cong);
             System.out.println("Phu cap: "+((nhanVienFullTime) NHANVIEN.get(s)).phuCap);
        }
           
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
                System.out.println("Doi mat khau thanh cong !");
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
            {
                System.out.println("So cong tich luy: "+((nhanVienFullTime) nv).cong);
                System.out.println("Phu cap: "+((nhanVienFullTime) nv).phuCap);
            }
                
            else
                System.out.println("So gio lam: "+((nhaVienPartTime) nv).gio);
        }
    }
    public void quenpass()
    {
        NHANVIEN.get(s).quenpass();
    }
    public void chamconglam()
    {
        NHANVIEN.get(s).chamCong();
    }
    public void ghilai()
    {
        try {
            List<String> lines = readAllLines(Paths.get("nhanvien.txt"));
            String line=null;
            for(int i =0;i<lines.size();i++)
            {
                if(lines.get(i).startsWith(NHANVIEN.get(s).STK))
                    if(NHANVIEN.get(i) instanceof nhanVienFullTime)
                        line = NHANVIEN.get(s).STK+";"+NHANVIEN.get(s).tenNV+";"+NHANVIEN.get(s).getPassWord()+";"+NHANVIEN.get(s).NgayBD+";"+NHANVIEN.get(s).SDT+";"+NHANVIEN.get(s).luongCB+";"+((nhanVienFullTime)NHANVIEN.get(s)).phuCap+";"+((nhanVienFullTime)NHANVIEN.get(s)).cong+";"+"0";
                    else
                        line = NHANVIEN.get(s).STK+";"+NHANVIEN.get(s).tenNV+";"+NHANVIEN.get(s).getPassWord()+";"+NHANVIEN.get(s).NgayBD+";"+NHANVIEN.get(s).SDT+";"+NHANVIEN.get(s).luongCB+";"+"0"+";"+"0"+";"+((nhaVienPartTime)NHANVIEN.get(s)).gio;
                lines.set(i, line);
                break;
            }
            Files.write(Paths.get("nhanvien.txt"),lines);
            
        } catch (Exception e) {
            System.err.println("Lỗi khi xử lý file: " + e.getMessage());
        }
        
    }
}
