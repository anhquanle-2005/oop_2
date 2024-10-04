
import java.util.*;

public class hinhchunhat {

    private double chieuDai;
    private double chieuRong;
    static Scanner D;

    public hinhchunhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    public void Nhap(){
         D = new Scanner(System.in);
        System.out.println("Nhập chiều dài hình chữ nhật: ");
        this.chieuDai= D.nextDouble();
        System.out.println("Nhập chiều rộng hình chữ nhật: ");
        this.chieuRong= D.nextDouble();
    }

    public void Xuat() {
        System.out.println("Diện tích: " + tinhDienTich());
        System.out.println("Chu vi: " + tinhChuVi());
    }

    
    
        
}
