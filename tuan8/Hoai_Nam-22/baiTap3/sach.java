package tuan8.Hoai_Nam_22.bai3;
import java.util.*;
public class sach extends taiLieu {
    protected String soTrang;
    public sach(){
        super();
        nhap();
    }
    public String getsoTrang()
    {
        return this.soTrang;
    }
    public void nhap(){
        super.nhap();
        sc = new Scanner(System.in);
        System.out.print("nhap vao so trang cua sach: ");
        this.soTrang = sc.nextLine();
        System.out.println("------------------------------------------------------------");
    }
    public String thuocTinh()
    {
       return  getsoTrang();
    }
}
