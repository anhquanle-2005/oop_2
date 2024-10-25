package tuan3;
import java.util.Scanner;

public class baiTap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào điểm trung bình của học sinh: ");
        double diemTrungBinh = scanner.nextDouble();
        
        if (diemTrungBinh >= 8.5) {
            System.out.println("Xếp loại: Giỏi");
        } else if (diemTrungBinh >= 6.5) {
            System.out.println("Xếp loại: Khá");
        } else if (diemTrungBinh >= 5.0) {
            System.out.println("Xếp loại: Trung bình");
        } else {
            System.out.println("Xếp loại: Yếu");
        }
        
        scanner.close();
    }
}
