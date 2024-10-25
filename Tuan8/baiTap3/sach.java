package TH.Tuan8.baiTap3;
import java.util.Scanner;

public class sach extends taiLieu {
    private int soTrang;

    public sach() {
        super();
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số trang: ");
        this.soTrang = scanner.nextInt();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Số trang: " + soTrang);
    }
}
