package TH.Tuan8.baiTap1;
import java.util.Scanner;

public class baiTap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hỏi người dùng muốn nhập loại động vật nào
        System.out.println("Nhập số lượng động vật: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();  // Xử lý dòng trống sau khi nhập số

        dongVat[] danhSachDongVat = new dongVat[soLuong];

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Chọn loại động vật (1 - Mèo, 2 - Chó, 3 - Chim): ");
            int loai = scanner.nextInt();
            scanner.nextLine();  // Xử lý dòng trống sau khi nhập số

            switch (loai) {
                case 1:
                    danhSachDongVat[i] = new meo();
                    break;
                case 2:
                    danhSachDongVat[i] = new cho();
                    break;
                case 3:
                    danhSachDongVat[i] = new chim();
                    break;
            }

            // Nhập thông tin cho động vật
            danhSachDongVat[i].nhap();
        }

        // Hiển thị thông tin và gọi phương thức tiengKeu() cho từng đối tượng
        for (dongVat dv : danhSachDongVat) {
            dv.thongTin();
            dv.tiengKeu();
            System.out.println(); // Dòng trống để ngăn cách
        }
    }
}