package tuan5.baitap7;                      
import java.util.*;
public class student {
    private int msv;
    private String Hoten;
    private float diem; 
    public int getmsv()
    {
        return this.msv;
    }
    public String getHoten()
    {
        return this.Hoten;
    }
    public float getdiem()
    {
        return this.diem;
    }
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao ma sinh vien: ");
        this.msv = sc.nextInt();
        this.Hoten = sc.nextLine();
        System.out.print("nhap vao ten sinh vien: ");
        this.Hoten = sc.nextLine();
        System.out.print("nhap vao diem: ");
        this.diem = sc.nextFloat();

    }
    public void xuat(){
        System.out.println(this.msv+"-"+this.Hoten+"-"+this.diem);
    }
    public static  void sapxep(student[] sv)
    {
        Arrays.sort(sv,(diem1,diem2) -> Double.compare(diem2.getdiem(), diem1.getdiem()));
    }

}
