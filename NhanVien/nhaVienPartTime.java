package NhanVien;
import java.time.LocalDate;
import java.util.Scanner;

public class nhaVienPartTime extends nhanVien{
    protected int caLam;
    protected int gio ;
    public nhaVienPartTime(){}
    public nhaVienPartTime(int caLam, LocalDate NgayBD, String SDT, double luongCB, String maNV, String passWord, String tenNV) {
        super(NgayBD, SDT, luongCB, maNV, passWord, tenNV);
        this.caLam = caLam;
    }
    public int getCaLam() {
        return caLam;
    }
    public int getGio() {
        return gio;
    }
    public int giolam(int lc){
        if(lc ==5)
            gio = gio + 4;
        else
            gio = gio + 5;
        return gio;
    }
    public void nhappt(){
        super.nhap();
        gio = 0;
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.println("Danh sach ca lam : ");
            System.out.println("1. Ca 1 (6:30-11:30)");
            System.out.println("2. Ca 2 (11:30-16:30)");
            System.out.println("3. Ca 3 (16:30 -21:30)");
            System.out.println("4. Ca 4 (21:30-2:30)");
            System.out.println("5. Ca 4 (2:30-6:30)");
            System.out.println("0. Thoat");
            System.out.print("xin moi lua chon: ");
            caLam = sc.nextInt();
            sc.nextLine();
        } while (caLam!=0);
        
    }
    @Override
    public double tinhLuong() {
        return luongCB*gio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(STK).append(";");
        sb.append(tenNV).append(";");
        sb.append(getPassWord()).append(";");
        sb.append(NgayBD).append(";");
        sb.append(SDT).append(";");
        sb.append(luongCB).append(";");
        sb.append(sc).append(";");
        sb.append("null").append(";");
        sb.append(gio);
        return sb.toString();
    }

}
