package oop_2.tuan4;
import java.util.Scanner;
public class baiTap3 
{
    static int n, giaiThua=1;
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so nguyen duong vao de tinh giai thua cua no: ");
        n = sc.nextInt();
        giaiThua =S();
        System.out.println("giai thua cua " +n +" bang "+giaiThua);
    }   
    static int S ()
    {
        for(int i=1;i<=n;i++)
            giaiThua=i*giaiThua;
        return giaiThua;
    }
}
