package TH.Tuan8.baiTap1;
import java.util.*;

class dongVat {
    protected String ten;
    protected int tuoi;

    public dongVat() {
        // Constructor mặc định
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        this.ten = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        this.tuoi = scanner.nextInt();
    }

    public void thongTin() {
        System.out.println("Tên: " + ten + ", Tuổi: " + tuoi);
    }

    public void tiengKeu() {
        // Lớp con sẽ ghi đè phương thức này ở các lớp con
    }
}
