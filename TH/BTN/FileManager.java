package TH.BTN;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void writeAccount(TaiKhoanKhachHang taiKhoan) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(taiKhoan.toString());
            writer.newLine();
            System.out.println("Đã ghi tài khoản: " + taiKhoan.getTenTaiKhoan());
        } catch (IOException e) {
            System.err.println("Lỗi ghi tệp: " + e.getMessage());
        }
    }

    public List<TaiKhoanKhachHang> readAccounts() {
        List<TaiKhoanKhachHang> accounts = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String tenTaiKhoan = data[0];
                    double soDu = Double.parseDouble(data[1]);
                    int thoiGianSuDung = Integer.parseInt(data[2]);
                    String matKhau = data[3];
                    TaiKhoanKhachHang taiKhoan = new TaiKhoanKhachHang(tenTaiKhoan, soDu, matKhau);
                    taiKhoan.tangThoiGianSuDung(thoiGianSuDung);
                    accounts.add(taiKhoan);
                } else {
                    System.err.println("Dòng không hợp lệ: " + line); // In ra dòng không hợp lệ
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc tệp: " + e.getMessage());
        }
        return accounts;
    }

    public void deleteAccount(String tenTaiKhoan) {
        File file = new File(filePath);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(tenTaiKhoan + ",")) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true;
                }
            }
            if (found) {
                System.out.println("Xóa tài khoản thành công: " + tenTaiKhoan);
            } else {
                System.out.println("Không tìm thấy tài khoản: " + tenTaiKhoan);
            }
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }

        file.delete();
        tempFile.renameTo(file);
    }
}