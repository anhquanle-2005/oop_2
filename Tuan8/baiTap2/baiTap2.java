package TH.Tuan8.baiTap2;

import java.util.Scanner;

public class baiTap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hỏi người dùng muốn nhập bao nhiêu nhân viên
        System.out.print("Nhập số lượng nhân viên: ");
        int soLuongNhanVien = scanner.nextInt();
        scanner.nextLine();  // Xử lý dòng trống sau khi nhập số

        nhanVien[] danhSachNhanVien = new nhanVien[soLuongNhanVien];

        // Nhập thông tin cho từng nhân viên
        for (int i = 0; i < soLuongNhanVien; i++) {
            // Hiển thị thứ tự nhân viên
            System.out.println("Nhân viên thứ " + (i + 1) + ":");

            // Chọn loại nhân viên
            System.out.println("Chọn loại nhân viên (1 - Nhân viên sản xuất, 2 - Nhân viên văn phòng): ");
            int loaiNhanVien = scanner.nextInt();
            scanner.nextLine();  // Xử lý dòng trống sau khi nhập số

            // Tạo đối tượng nhân viên theo loại
            switch (loaiNhanVien) {
                case 1:
                    danhSachNhanVien[i] = new nhanVienSanXuat();
                    break;
                case 2:
                    danhSachNhanVien[i] = new nhanVienVanPhong();
                    break;
                default:
                    System.out.println("Loại không hợp lệ. Mặc định là Nhân viên văn phòng.");
                    danhSachNhanVien[i] = new nhanVienVanPhong();
                    break;
            }

            // Nhập thông tin cho nhân viên
            danhSachNhanVien[i].nhapThongTin();
        }

        // Hiển thị thông tin và lương cho từng nhân viên
        for (nhanVien nv : danhSachNhanVien) {
            nv.hienThiThongTin();
            System.out.println();  // Ngăn cách giữa các nhân viên
        }
    }
}
