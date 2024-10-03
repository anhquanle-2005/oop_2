package tuan6.Hoai_Nam_22.baiTap2;
import java.util.*;

public class sinhVien {
    private int msv;
    private String hoTen;
    private String ngaySinh;
    private float diemTB; 
    public int getmsv()
    {
        return this.msv;
    }
    public String gethoTen()
    {
        return this.hoTen;
    }
    public String getngaySinh()
    {
        return this.ngaySinh;
    }
    public float getdiemTB()
    {
        return this.diemTB;
    }
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao ma sinh vien: ");
        this.msv = sc.nextInt();
        this.hoTen = sc.nextLine();
        System.out.print("nhap vao ten sinh vien: ");
        this.hoTen = sc.nextLine();
        System.out.print("nhap vao ngay sinh: ");
        this.ngaySinh = sc.nextLine();
        System.out.print("nhap vao diem: ");
        this.diemTB = sc.nextFloat();
    }
    public void xuat(){
        System.out.println(this.msv+"-"+this.hoTen+"-"+this.ngaySinh+"-"+this.diemTB);
    }
    public static  void sapxep(sinhVien[] sv)
    {
        Arrays.sort(sv,(diem1,diem2) -> Double.compare(diem2.getdiemTB(), diem1.getdiemTB()));
    }
    
}
