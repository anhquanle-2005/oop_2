package tuan11;

import java.io.*;
import java.util.ArrayList;

public class DSPhong {
    private ArrayList<Phong> DSPhong;

    public DSPhong() {
        DSPhong = new ArrayList<>();
    }

    public void themPhong() {
        Phong pm = new Phong();
        pm.Nhap();
        DSPhong.add(pm);
    }

    public void xoaPhong(String maPhong) {
        DSPhong.removeIf(pm -> maPhong.equals(pm.getMaPhong()));
    }

    public Phong timPhong(String maPhong) {
        for (Phong p : DSPhong)
            if (p.getMaPhong().equals(maPhong))
                return p;
        return null;
    }

    // Phương thức ghi danh sách phòng ra file
    public void ghiDSPhong(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(DSPhong);
            System.out.println("Ghi danh sách phòng thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    // Phương thức đọc danh sách phòng từ file
    @SuppressWarnings("unchecked")
    public void docDSPhong(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            DSPhong = (ArrayList<Phong>) ois.readObject();
            System.out.println("Đọc danh sách phòng thành công.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    // Phương thức hiển thị danh sách các loại phòng
    public void hienThiDSPhong() {
        System.out.println("Danh sach phong Don:");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Don")) {
                hienThiThongTinPhong(p);
                System.out.println("\nDanh sach may tinh trong phong:");
                p.hienThiDanhSachMayTinh();
                System.out.println("\n------------------------------\n");
            }
        }

        System.out.println("Danh sach phong Doi:");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Doi")) {
                hienThiThongTinPhong(p);
                System.out.println("\nDanh sach may tinh trong phong:");
                p.hienThiDanhSachMayTinh();
                System.out.println("\n------------------------------\n");
            }
        }

        System.out.println("Danh sach phong Vip:");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Vip")) {
                hienThiThongTinPhong(p);
                System.out.println("\nDanh sach may tinh trong phong:");
                p.hienThiDanhSachMayTinh();
                System.out.println("\n------------------------------\n");
            }
        }

        System.out.println("Danh sach phong Thi Dau:");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("Phong thi Dau")) {
                hienThiThongTinPhong(p);
                System.out.println("\nDanh sach may tinh trong phong:");
                p.hienThiDanhSachMayTinh();
                System.out.println("\n------------------------------\n");
            }
        }
    }

    private void hienThiThongTinPhong(Phong p) {
        System.out.println("Ma phong: " + p.getMaPhong());
        System.out.println("Loai phong: " + p.getLoaiPhong());
        System.out.println("Phi phong: " + p.getPhiPhong());
    }
}