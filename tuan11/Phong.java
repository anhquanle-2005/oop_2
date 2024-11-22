package tuan11;

import java.util.ArrayList;
import java.util.Scanner;

public class Phong {
    private String maPhong;
    private String loaiPhong;
    private Double phiPhong;
    protected ArrayList<MayTinh> DSMAYTINH;

    public Phong() {
        DSMAYTINH = new ArrayList<>();
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
        DSMAYTINH = dSMAYTINH;
    }

    public void themMayTinh() {
        MayTinh mt = new MayTinh();
        mt.Nhap();
        DSMAYTINH.add(mt);
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
        int soPhong = sc.nextInt();
        sc.nextLine();
        do {
            System.out.println("Nhap vao loai phong (phong Don || phong Doi || phong Vip || Phong thi Dau):");
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
                case "Phong thi Dau":
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
        return maPhong + ", " + loaiPhong + ", " + phiPhong;
    }

    
}
