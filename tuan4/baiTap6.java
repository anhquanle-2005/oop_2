package oop_2.tuan4;
import java.util.Scanner;

public class baiTap6 
{
    static int n;
    static Scanner sc;
    public static void main(String[] args) 
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("nhap vao so n = ");
        n=sc.nextInt();
        doiXung();
    }

    static void doiXung()
    {
        int a=n, dao=0;
        while (n!=0) 
        {
            int tong=n%10;
            dao=dao*10+tong;
            n=n/10;   
        }
        if (dao==a) 
            System.out.println("so nay doi xung");
        else 
            System.out.println("so nay khong doi xung");

    }
}
