package tuan3;
<<<<<<< HEAD

=======
>>>>>>> Anh_Quan
import java.util.Scanner;
public class bai5 
{
    public static void main(String[] args) 
    {
            int a,b,c;
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap vao canh a:");
            a=sc.nextInt();
            System.out.println("nhap vao canh b:");
            b=sc.nextInt();
            System.out.println("nhap vao canh c:");
            c=sc.nextInt();
            tamGiac(a, b, c);
    }
    public static void tamGiac (int a, int b, int c)
    {
        if( a+b>c && a+c>b && b+c>a)    
            if(a==b && b==c)
                System.out.println("tam giac deu");
            else    
                if(a==b || b==c)
                    System.out.println("tam giac can");
                else 
                    if(Math.pow(a,2)+Math.pow( b,2)==Math.pow(c,2) || Math.pow(a,2)+Math.pow( c,2)==Math.pow(b,2) || Math.pow(b,2)+Math.pow( c,2)==Math.pow(a,2))
                        System.out.println("tam giac vuong");
                    else    
                        System.out.println("tam giac thuong");
        else    
            System.out.println("khong the tao thanh tam giac");
    }
}
