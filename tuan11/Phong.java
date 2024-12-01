package tuan11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phong {
    private String maPhong;
    private String loaiPhong;
    private Double phiPhong;
    protected ArrayList<MayTinh> DSMAYTINH;

    public Phong() {
        DSMAYTINH = new ArrayList<>();
    }

    public Phong(String maPhong) {
        this.maPhong = maPhong;
    }

    public Phong(String maPhong, String loaiPhong, Double phiPhong) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.phiPhong = phiPhong;
        this.DSMAYTINH=new ArrayList<>();
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Double getPhiPhong() {
        return phiPhong;
    }

    public void setPhiPhong(Double phiPhong) {
        this.phiPhong = phiPhong;
    }

    public ArrayList<MayTinh> getDSMAYTINH() {
        return DSMAYTINH;
    }

    public void setDSMAYTINH(ArrayList<MayTinh> dSMAYTINH) {
        this.DSMAYTINH = dSMAYTINH;
    }

    public void themMayTinh() {
        MayTinh mt = new MayTinh();
        mt.Nhap();
        DSMAYTINH.add(mt);
        ghiFileMayTinh(mt);
    }

    public MayTinh timMayTinh(String maMay)
    {
        for(MayTinh mt: DSMAYTINH)
            if(mt.getMaMay().equals(maMay) && mt.getTrangThai().equals("Chua dat"))
                return mt;
        return null;
    }
    public void ghiFileMayTinh(MayTinh mt) {
        try {
            FileWriter fw = new FileWriter("dsMayTinh.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.maPhong+","+mt.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Loi khi ghi file may tinh: " + e.getMessage());
        }
    }
    /*
     * for(int i=0; i<danhSachMay.size();i++)
     * {
     *      String [] parts= danhSachMay.get(i).split(",");
     *      if(parts[1].equals(mt.getMaMay()))
     *      {
     *          parts[6]=mt.getTrangThai();
     *          danhSachMay.set(i,String.join(",", parts))
     *      } 
     * 
     * }
     */
    public void capNhatTrangThaiMay(MayTinh mt) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("dsMayTinh.txt"));
            List<String> danhSachMay = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                danhSachMay.add(line);
            }
            br.close();

            for (int i = 0; i < danhSachMay.size(); i++) {
                String[] parts = danhSachMay.get(i).split(",");
                if (parts[1].equals(mt.getMaMay())) {
                    parts[6] = mt.getTrangThai(); 
                    danhSachMay.set(i, String.join(",", parts));
                    break;
                }
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("dsMayTinh.txt"));
            for (String may : danhSachMay) {
                bw.write(may);
                bw.newLine();
            }
            bw.close();
    
            System.out.println("Cập nhật trạng thái máy thành công");
        } catch (IOException e) {
            System.out.println("Lỗi khi cập nhật file máy tính: " + e.getMessage());
        }
    }
    
    public void capNhatFileMayTinh() {
        try {
            FileWriter fw = new FileWriter("dsMayTinh.txt"); 

     

            BufferedWriter bw = new BufferedWriter(fw);
            for (MayTinh mt : DSMAYTINH) {
                bw.write(this.getMaPhong() +","+ mt.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Cap nhat danh sach may tinh thanh cong");
        } catch (IOException e) {
            System.out.println("Loi khi cap nhat file may tinh: " + e.getMessage());
        }
    }
    public void xoaMayTinh(String maMT) {
        DSMAYTINH.removeIf(mt -> maMT.equals(mt.getMaMay()));
    }

    public MayTinh timMT(String maMT) {
        for (MayTinh mt : DSMAYTINH) {
            if (mt.getMaMay().equals(maMT))
                return mt;
        }
        return null;
    }

    public boolean kiemTraSoPhong(String so) {
        return so.length() == 3 &&
                so.matches(".*[0-9]+.*") && 
                !so.contains(" ") &&
                !so.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*") &&
                !so.matches(".*[a-zA-Z]+.*");
    }
    public void hienThiDanhSachMayTinh(String trangThai)
    {
        System.out.println("Danh sach may tinh chua dat");
        for(MayTinh mt:DSMAYTINH)
        {
            if (mt.getTrangThai().equals(trangThai)) {
                hienThiThongTinMayTinh(mt);
            }
        }
    }
    public void hienThiDanhSachMayTinh() {
        System.out.println("Danh sach may tinh Pho thong:");
        for (MayTinh mt : DSMAYTINH) {
            if (mt.getLoaiMay().equals("Pho thong")) {
                hienThiThongTinMayTinh(mt);
            }
        }

        System.out.println("Danh sach may tinh Trung cap:");
        for (MayTinh mt : DSMAYTINH) {
            if (mt.getLoaiMay().equals("Trung cap")) {
                hienThiThongTinMayTinh(mt);
            }
        }

        System.out.println("Danh sach may tinh Cao cap:");
        for (MayTinh mt : DSMAYTINH) {
            if (mt.getLoaiMay().equals("Cao cap")) {
                hienThiThongTinMayTinh(mt);
            }
        }
    }

    private void hienThiThongTinMayTinh(MayTinh mt) {
        System.out.println("Ma may: " + mt.getMaMay());
        System.out.println("CPU: " + mt.getCpu());
        System.out.println("RAM: " + mt.getRam());
        System.out.println("GPU: " + mt.getGpu());
        System.out.println("Loai may: " + mt.getLoaiMay());
        System.out.println("Trang thai: " + mt.getTrangThai());
        System.out.println("Gia gio: " + mt.getGiaGio());
        System.out.println("----------------------------");
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        System.out.println("Them phong moi");
        System.out.print("Nhap vao so phong: ");
        String soPhong = sc.nextLine();
        do {
            if(!kiemTraSoPhong(soPhong)){
                System.out.println("So phong chi co 3 chu so");
                System.out.println("Nhap lai: ");
                soPhong=sc.nextLine();
            }
        } while (!kiemTraSoPhong(soPhong));
        do {
            System.out.println("Nhap vao loai phong (phong Don || phong Doi || phong Vip || phong Thi Dau):");
            this.loaiPhong = sc.nextLine();
            switch (this.loaiPhong) {
                case "phong Don":
                    this.phiPhong = 5000.0;
                    this.maPhong = "P" + soPhong;
                    valid = true;
                    break;
                case "phong Doi":
                    this.phiPhong = 10000.0;
                    this.maPhong = "PD" + soPhong;
                    valid = true;
                    break;
                case "phong Vip":
                    this.phiPhong = 12000.0;
                    this.maPhong = "PV" + soPhong;
                    valid = true;
                    break;
                case "phong Thi Dau":
                    this.phiPhong = 20000.0;
                    this.maPhong = "PX" + soPhong;
                    valid = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, hay nhap lai.");
                    break;
            }
        } while (!valid);
    }
    @Override
    public String toString() {
        return maPhong + "," + loaiPhong + "," + phiPhong;
    }
}