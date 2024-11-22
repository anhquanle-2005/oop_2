package tuan10;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;



import java.io.ObjectOutputStream;
import java.io.OutputStream;
public class BankServer {
    private ArrayList<TaiKhoan> DanhSach;
    private Scanner sc;
    public BankServer(){
        this.DanhSach = new ArrayList<TaiKhoan>();
        this.sc = new Scanner(System.in);
    }

    public BankServer(ArrayList<TaiKhoan> DanhSach) {
        this.DanhSach = DanhSach;
    }
    public void ThemTaiKhoan(TaiKhoan tk) {
        this.DanhSach.add(tk);
        ghiThongTinTaiKhoan(new File("D:\\OOP\\thongTinTaiKhoan.txt")); // Ghi toàn bộ danh sách tài khoản khi thêm mới
    }

    public TaiKhoan dangNhapVoiKiemTra() {
        System.out.println("Nhap vao so tai khoan: ");
        String soTaiKhoan = sc.nextLine();
        TaiKhoan tk = timTaiKhoan(soTaiKhoan);
        
        if (tk == null) {
            System.out.println("Tai khoan khong ton tai.");
            return null;
        }
    
        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Nhap mat khau: ");
            String matKhauNhap = sc.nextLine();
            
            if (tk.kiemTraMatKhau(matKhauNhap)) 
                return tk;
            else {
                attempts++;
                System.out.println("Mat khau sai. Ban con " + (3 - attempts) + " lan thu.");
            }
        }
    
        System.out.println("Ban da nhap sai qua 3 lan. Ban quen mat khau, co muon lam lai ? (Y/N)");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            quenMatKhau(tk);
        }
        return null;
    }
    private void quenMatKhau(TaiKhoan tk) {
        System.out.println("Xac thuc CCCD: ");
        String cccdNhap = sc.nextLine();
        System.out.println("Xac thuc SDT: ");
        int sdtNhap = Integer.parseInt(sc.nextLine());
        System.out.println("Xac thuc EMAIL: ");
        String emailNhap = sc.nextLine();
        
        if (cccdNhap.equals(tk.getCccd()) && sdtNhap == tk.getSDT() &&
            emailNhap.equals(tk.getEMAIL())) {
    
            System.out.println("Xac thuc thanh cong! Vui long nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            while (!tk.kiemTraDoManhMatKhau(matKhauMoi) || matKhauMoi.equals(tk.getMatKhau()) ) {
                System.out.println("Mat khau khong du manh va khong duoc giong mat khau gan nhat. Vui long nhap lai: ");
                matKhauMoi = sc.nextLine();
            }
            tk.setMatKhau(matKhauMoi);
            capNhatThongTinTaiKhoan(tk);
            System.out.println("Dat lai mat khau thanh cong!");
        } else {
            System.out.println("Thong tin xac thuc khong chinh xac.");
        }
    }

    public boolean xoaTaiKhoan(TaiKhoan taiKhoan, int soDienThoai, String cccd, int maPin, String matKhau, String email) {
        // Kiểm tra thông tin đầu vào
        if (taiKhoan.getSDT() == soDienThoai && // So sánh số điện thoại
            taiKhoan.getCccd().equals(cccd) &&
            taiKhoan.getPin() == maPin &&
            taiKhoan.getMatKhau().equals(matKhau) &&
            taiKhoan.getEMAIL().equals(email)) {
            
            // Xác nhận thêm bước cuối
            System.out.println("Ban chac chan muon xoa tai khoan? (1: Co | 0: Khong)");
            Scanner sc = new Scanner(System.in);
            int confirm = sc.nextInt();
            sc.nextLine();
            
            if (confirm == 1) {
                DanhSach.remove(taiKhoan); // Sử dụng phương thức remove để xóa tài khoản
                ghiThongTinTaiKhoan(new File("D:\\OOP\\thongTinTaiKhoan.txt")); 
                return true;
            } else {
                System.out.println("Hanh dong xoa tai khoan da bi huy.");
            }
        } else {
            System.out.println("Thong tin xac thuc khong chinh xac.");
        }
        return false; // Trả về false nếu không xóa được
    }

    public TaiKhoan timTaiKhoan(String soTaiKhoan) {
        for (TaiKhoan tk : DanhSach) {
            if (tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return tk;
            }
        }
        return null;
    }



    public void ghiThongTinTaiKhoan(File file) {
        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            for (TaiKhoan tk : DanhSach) {
                oos.writeObject(tk); // Ghi toàn bộ đối tượng TaiKhoan
            }
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void DocThongTin(File file) {
        try (InputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            while (true) {
                try {
                    TaiKhoan tk = (TaiKhoan) ois.readObject();
                    this.DanhSach.add(tk); // Thêm tài khoản vào danh sách
                } catch (EOFException e) {
                    break; // Kết thúc khi đã đọc hết file
                } catch (ClassNotFoundException e) {
                    System.out.println("Lỗi: Không tìm thấy lớp TaiKhoan.");
                    e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ghiLichSuChuyenTien(String soTaiKhoanGui, String soTaiKhoanNhan, double soTien, String noiDung) { 
        Calendar cal = Calendar.getInstance();
        try (PrintWriter writer = new PrintWriter(new FileWriter("lichSuChuyenTien.txt", true))) { 
            writer.println("Thoi gian chuyen tien");
            writer.println(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
            writer.println("So tai khoan gui: " + soTaiKhoanGui); 
            writer.println("So tai khoan nhan: " + soTaiKhoanNhan); 
            writer.println("So tien: " + soTien); 
            writer.println("Noi dung chuyen tien: " + noiDung);
            writer.println("===================================");
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }


    public void capNhatThongTinTaiKhoan(TaiKhoan tk) {
        ghiThongTinTaiKhoan(new File("D:\\OOP\\thongTinTaiKhoan.txt")); 
    }

    public void DocThongTin(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DocThongTin'");
    }
}
