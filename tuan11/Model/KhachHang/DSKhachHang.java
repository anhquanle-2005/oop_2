package KhachHang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSKhachHang {
    private ArrayList <KhachHang> dsKhachHang;
    private Scanner sc = new Scanner(System.in);
    
    public DSKhachHang(ArrayList<KhachHang> dsKhachHang, Scanner sc) {
        this.dsKhachHang = dsKhachHang;
        this.sc = sc;
    }

    public DSKhachHang()
    {
        dsKhachHang= new ArrayList<>();
    }

    public void themKhach()
    {
        try {
            KhachHang kh= new KhachHang();
            kh.Nhap();
            kh.setLoaiKhachHang("Khach hang binh thuong");
            int dem=0;
            for(KhachHang k: dsKhachHang)
                if(k.getMaKH().equals(kh.getMaKH()))
                    dem++;
            if(dem==0)
            {
                dsKhachHang.add(kh);
                ghiDSKH(kh);

            }
            else 
                System.out.println("Da co ma khach hang nay");
        } catch (Exception e) {
            System.out.println("Loi khi them  khach hang"+e.getMessage());
        }
    }

    public KhachHang dangNhap()
    {
        System.out.println("Nhap ma cua khach hang: ");
        String maKH= sc.nextLine();
        KhachHang kh= timKhachHang(maKH);
        if(kh==null)
        {
            System.out.println("May la ai?");
            return null;
        }
        int thu=0;
        while (thu<3) {
            System.out.println("Nhap vao mat khau: ");
            String mk= sc.nextLine();
            if(kh.kiemTraMK(mk))
                return kh;
            else 
            {
                thu++;
                System.out.println("Mat khau sai. Ban con "+(3-thu)+" lan thu");
            }
        }

        System.out.println("Ban nhap sai qua 3 lan. Ban quen mat khau, co muon khoi phuc (Y|N)");
        String luaChon=sc.nextLine();
        if(luaChon.equalsIgnoreCase("Y"))
            quenMatKhau(kh);
        return null;
    }

    private void quenMatKhau(KhachHang kh)
    {
        System.out.println("Xac thuc so dien thoai");
        String sdt=sc.nextLine();
        System.out.println("Ten cua khach hang");
        String hoTen=sc.nextLine();
        if(sdt.equals(kh.getSdt()) && hoTen.equals(kh.getTenKH()))
        {
            System.out.println("Xac thuc thanh cong! Vui long nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            while (!kh.kiemTraDoManhMatKhau(matKhauMoi) || matKhauMoi.equals(kh.getMatKhau()) ) {
                System.out.println("Mat khau khong du manh va khong duoc giong mat khau gan nhat. Vui long nhap lai: ");
                matKhauMoi = sc.nextLine();
            }
            kh.setMatKhau(matKhauMoi);
            capNhatThongTinKhachHang(kh);
            System.out.println("Dat lai mat khau thanh cong!");
        }
        else
            System.out.println("Thong tin xac thuc khong chinh xac");
    }
    public void capNhatThongTinKhachHang(KhachHang kh)
    {
        try {
            BufferedReader br= new BufferedReader(new FileReader("dsKhachHang.txt"));
            List<String> dsKhach= new ArrayList<>();
            String line;
            while((line=br.readLine())!=null)
                dsKhach.add(line);
            br.close();

            for (int i = 0; i < dsKhach.size(); i++) {
                String [] phan=dsKhach.get(i).split(",");
                if(phan[1].equals(kh.getMaKH()))
                {
                    phan[2]= kh.getMatKhau();
                    dsKhach.set(i,String.join(",",phan));
                    break;
                }
            }
            BufferedWriter bw= new BufferedWriter(new FileWriter("dsKhachHang.txt"));
            for (String khach : dsKhach) {
                bw.write(khach);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Loi khi cap nhat: " + e.getMessage());
        }
    }
    public void docFile()
    {
        try {
            FileReader fr= new FileReader("dsKhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null) 
            {
                String [] txt =line.split(",");
                if(txt.length==9)
                {
                    String tenKH=txt[0];
                    String maKH=txt[1];
                    String mk=txt[2];
                    String sdt=txt[3];
                    String soTie=txt[4];
                    double soTien=Double.parseDouble(soTie);
                    String soGioCho=txt[5];
                    int soGioChoi=Integer.parseInt(soGioCho);
                    String soPhu=txt[6];
                    int soPhutChoi=Integer.parseInt(soPhu);
                    String diem=txt[7];
                    int soDiem=Integer.parseInt(diem);
                    String loaiKhach=txt[8];
                    KhachHang kh= new KhachHang(tenKH, maKH, mk ,sdt, soTien, soGioChoi, soPhutChoi,soDiem,loaiKhach);
                    // Đây là nơi bạn cần thêm vào danh sách khách hàng
                    dsKhachHang.add(kh);
                }
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so: " + e.getMessage());
        }
    }
    
    public void ghiDSKH(KhachHang kh)
    {
        try {
            FileWriter fw= new FileWriter("dsKhachHang.txt",true);
            BufferedWriter bw= new BufferedWriter(fw);
            bw.write(kh.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Loi khi ghi file: "+e.getMessage());
        }
    }

    public void capNhatFileKh()
    {
        try {
            FileWriter fw= new FileWriter("dsKhachHang.txt",false);
            BufferedWriter bw= new BufferedWriter(fw);
            for (KhachHang khachHang : dsKhachHang) {
                bw.write(khachHang.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Loi khi ghi file: "+e.getMessage());
        }
    }

    public void xoaKhachHang(String maKH)
    {
        dsKhachHang.removeIf(khachHang -> maKH.equals(khachHang.getMaKH()));
        capNhatFileKh();
    }

    public KhachHang timKhachHang(String maKH)
    {
        for (KhachHang khachHang : dsKhachHang) {
            if(khachHang.getMaKH().equals(maKH))
                return khachHang;
        }
        return null;
    }
    
    public void hienThiDSKH()
    {
        System.out.println("Danh sach khach hang");
        for (KhachHang khachHang : dsKhachHang) {
            System.out.println("Ma khach hang: "+khachHang.getMaKH());
            System.out.println("Ten khach hang: "+khachHang.getTenKH());
            System.out.println("Loai khach hang: "+khachHang.getLoaiKhachHang());
            System.out.println("Ma khach hang: "+khachHang.getSdt());
        }
    }


}
