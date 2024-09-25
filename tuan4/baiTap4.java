
import java.util.*;
public class baiTap4_T4 
{
   public static void main(String[] args) 
    {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao mot so nguyen:");
        a = sc.nextInt();
        KtraSoNguyenTo(a);
    } 
    public static void KtraSoNguyenTo(int x)
    {
        int i,s;
        s=0;
        if(x==1)
        s=1;
        else
        for(i=1;i<=x;i++)
            if(x%i==0)
                s=s+1;
        if(s==2)
        System.out.println(x+" la so nguyen to");
        else
        System.out.println(x+" khong phai la so nguyen to");
    }
}
