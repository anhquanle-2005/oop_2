import java.util.*;

public class baiTap4 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so tien goc:");
        long a=sc.nextLong();
        System.out.println("nhap lai cua ngan hang:");
        float b=sc.nextFloat();
        System.out.println("nhap so thang gui:");
        int c=sc.nextInt();

        double soTienlai=0;
        double soTientong=0;

        soTientong= sum(a, b, c);
        System.out.println("so tien tong ="+soTientong);
        soTienlai=soTientong-a;
        System.out.println("so tien lai ="+soTienlai);
    }

    public static double sum(long tienGoc, float lai, int thang ) 
    {
        double tong_tien=0;
        //ép kiểu tường minh cho tiền gốc vì nó là long
        tong_tien =((double)tienGoc * Math.pow((1 + lai), thang));
        return tong_tien;
    }
}
