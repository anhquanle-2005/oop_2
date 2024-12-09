package Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import KhachHang.KhachHang;

public class DSPhong {
    
    private ArrayList<Phong> DSPhong;
    private Scanner sc = new Scanner(System.in);

    public DSPhong() {
        DSPhong = new ArrayList<>();
    }

    public void docfile() {
        try {
            FileReader fr = new FileReader("dsphong.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals("Danh sach may tinh") && 
                    !line.equals("-------------------------------")) {
                    String[] txt = line.split(",");
                    if (txt.length == 3) {
                        String maph = txt[0];
                        String loaiph = txt[1];
                        String phiph = txt[2];
                        double phiphong = Double.parseDouble(phiph.trim());
                        Phong ph = new Phong(maph, loaiph, phiphong);
                        DSPhong.add(ph);
                    }
                } else if (line.equals("Danh sach may tinh")) {
                    break;
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
    public void docfileMayTinh() {
        try {
            FileReader fr = new FileReader("dsMayTinh.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 8) { // Đảm bảo có đủ 8 phần tử (mã phòng + 7 thuộc tính máy tính)
                    String maPhong = txt[0]; // Mã phòng
                    String maMay = txt[1]; // Mã máy
                    String cpu = txt[2];
                    String ram = txt[3];
                    String gpu = txt[4];
                    String loaiMay = txt[5];
                    String trangThai = txt[6];
                    double giaGio = Double.parseDouble(txt[7].trim());
    
                    MayTinh mt = new MayTinh(maMay, cpu, ram, gpu, loaiMay, trangThai, giaGio);
    
                    Phong phong = timPhong(maPhong);
                    if (phong != null) {
                        phong.getDSMAYTINH().add(mt);
                    } else {
                        System.out.println("Không tìm thấy phòng với mã: " + maPhong);
                    }
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file máy tính: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số: " + e.getMessage());
        }
    }
    public void themPhong() {
        try {
            Phong pm = new Phong();
            pm.Nhap();
            int ddem =0;
            for (Phong phong : DSPhong) {
                if(pm.getMaPhong().equals(phong.getMaPhong())){
                    ddem++;
                }
            }
            if(ddem==0)
            {
                DSPhong.add(pm);
                ghiFilePhong(pm);
                System.out.println("Them thanh cong");
            }
            else 
                System.out.println("Da co ma phong");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm phòng: " + e.getMessage());
        }
    }
    public void themPhong(Phong p)
    {
        DSPhong.add(p);
        ghiFilePhong(p);
        System.out.println("Them thanh cong");
    }


    public void ghiFilePhong(Phong pm) {
        try {
            FileWriter fw = new FileWriter("dsphong.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pm.toString());
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public void capNhatfile() {
        try {
            FileWriter fw = new FileWriter("dsphong.txt"); 
            BufferedWriter bw = new BufferedWriter(fw);
            for (Phong pm : DSPhong) {
                if (pm != null) {
                    bw.write(pm.toString());
                    bw.newLine();
                    if (pm.getDSMAYTINH() == null) {
                        bw.write("Khong co may tinh nao trong phong");
                    } else if (pm.getDSMAYTINH().isEmpty()) {
                        bw.write("Khong co may tinh nao trong phong");
                    } else {
                        bw.write("Danh sach may tinh:");
                        bw.newLine();
                        for (MayTinh mt : pm.getDSMAYTINH()) {
                            if (mt != null) {
                                bw.write("\t" + mt.toString());
                                bw.newLine();
                            } else {
                                System.out.println("Null MayTinh detected in phong: " + pm.getMaPhong());
                            }
                        }
                    }
                    bw.write("-------------------------------");
                    bw.newLine();
                } else {
                    System.out.println("Null Phong detected in DSPhong.");
                }
            }
            bw.close();
            fw.close();
            System.out.println("Cap nhat file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi cap nhat file: " + e.getMessage());
        }
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

    public void hienThiDSPhong() {
        System.out.println("DANH SACH PHONG DON");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Don")) {
                hienThiThongTinPhong(p);
            }
        }

        System.out.println("DANH SACH PHONG DOI");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Doi")) {
                hienThiThongTinPhong(p);
            }
        }

        System.out.println("DANH SACH PHONG VIP");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Vip")) {
                hienThiThongTinPhong(p);
            }
        }

        System.out.println("DANH SACH PHONG THI DAU");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("Phong thi Dau")) {
                hienThiThongTinPhong(p);
            }
        }
    }

    public void hienThiDSPhong(String loaiPhong)
    {
        if(loaiPhong.equals("phong Don")){
            System.out.println("DANH SACH PHONG DON");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("phong Don")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
    
        if(loaiPhong.equals("phong Doi")){
            System.out.println("DANH SACH PHONG DOI");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("phong Doi")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
        
        if(loaiPhong.equals("phong Vip")){
            System.out.println("DANH SACH PHONG VIP");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("phong Vip")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
       
        if(loaiPhong.equals("phong Thi Dau")){
            System.out.println("DANH SACH PHONG THI DAU");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("Phong thi Dau")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
    }
    
    public boolean kiemTraMaPhong(String maPhong) {
        for (Phong phong : DSPhong) {
            if (phong.getMaPhong().equals(maPhong)) {
                return true; // Nếu tìm thấy mã phòng, trả về true
            }
        }
        return false; // Nếu không tìm thấy, trả về false
    }
    private void hienThiThongTinPhong(Phong p) {
        System.out.println(p.getMaPhong()+" ,Phi phong: " + p.getPhiPhong());
    }

    public ArrayList<Phong> getDSPhong() {
        return DSPhong;
    }

    public void setDSPhong(ArrayList<Phong> dSPhong) {
        DSPhong = dSPhong;
    }
}
