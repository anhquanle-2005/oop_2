package TH.BTN;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileManager {
    protected ArrayList<KhachHang> KHACHHANG;
    protected int s = -1;

    public FileManager() {
        KHACHHANG = new ArrayList<>();
        docFile();
    }

    private void docFile() {
        try {
            FileReader fr = new FileReader("Khachhang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(";");
                String maKH = txt[0];
                String tenKH = txt[1];
                String matKhau = txt[2];
                String tenTaiKhoan = txt[3];
                String sdt = txt[4];
                double soTien = Double.parseDouble(txt[5]);
                int diemThuong = Integer.parseInt(txt[8]);
    
                KhachHang kh;
                if (diemThuong > 250) {
                    kh = new KhachHangVIP(maKH, matKhau, tenTaiKhoan, tenKH, sdt, soTien, diemThuong);
                } else {
                    kh = new KhachHangBinhThuong(maKH, matKhau, tenTaiKhoan, tenKH, sdt, soTien, diemThuong);
                }
                KHACHHANG.add(kh);
            }
            
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    public void themKhachHang() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();
        System.out.print("Nhập tên tài khoản: ");
        String tenTaiKhoan = scanner.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String tenKH = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String sdt = scanner.nextLine();
        System.out.print("Nhập số tiền: ");
        double soTien = scanner.nextDouble();
        double diemThuong = soTien / 10000; // Tính điểm thưởng từ số tiền nạp
    
        KhachHang kh;
        if (diemThuong > 250) {
            kh = new KhachHangVIP(matKhau, matKhau, tenTaiKhoan, tenKH, sdt, soTien, s);
        } else {
            kh = new KhachHangBinhThuong(matKhau, matKhau, tenTaiKhoan, tenKH, sdt, soTien, s);
        }
        KHACHHANG.add(kh);
        ghiFile(kh);
    }

    private void ghiFile(KhachHang kh) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("khachhang.txt", true))) {
            bw.write(kh.toString());
            bw.newLine();
            bw.write("--------------------------------------------------");
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void xoaKhachHang(String maKH) {
        KHACHHANG.removeIf(khachHang -> maKH.equals(khachHang.getMaKH()));
        System.out.println("Cập nhật thành công!");
    }

    public void dangNhap(String tenTaiKhoan, String password) {
        for (int i = 0; i < KHACHHANG.size(); i++) {
            if (tenTaiKhoan.equals(KHACHHANG.get(i).getTenTaiKhoan()) && password.equals(KHACHHANG.get(i).getMatKhau())) {
                s = i;
                System.out.println("Đăng nhập thành công!");
                return;
            }
        }
        System.out.println("Đăng nhập thất bại!");
    }

    public void thongTinChiTiet() {
        if (s >= 0) {
            KhachHang kh = KHACHHANG.get(s);
            System.out.println("Mã KH: " + kh.getMaKH());
            System.out.println("Tên tài khoản: " + kh.getTenTaiKhoan());
            System.out.println("Tên khách hàng: " + kh.getTenKH());
            System.out.println("Số điện thoại: " + kh.getSDT());
            System.out.println("Số tiền hiện có: " + kh.getSoTien());
            System.out.println("Thời gian chơi: " + kh.getThoiGianChoi());
        } else {
            System.out.println("Chưa có khách hàng nào được chọn.");
        }
    }

    public void ghiLaiThongTin(KhachHang kh) {
        String fileName = kh instanceof KhachHangVIP ? "khachhang_vip.txt" : "khachhang_binhthuong.txt";
        try {
            List<String> lines = new ArrayList<>();
            for (KhachHang k : KHACHHANG) {
                lines.add(k.toString());
            }
            Files.write(Paths.get(fileName), lines);
            System.out.println("Thông tin đã được cập nhật!");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi lại file: " + e.getMessage());
        }
    }
}