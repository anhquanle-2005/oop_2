package tuan3;
<<<<<<< HEAD

=======
>>>>>>> Anh_Quan
import java.util.Scanner;

public class bai6 
{
    public static void main(String[] args) 
    {   
            int a,b;
            char dau;
            Scanner sc= new Scanner(System.in);
            System.out.println("nhap vao a: ");
            a=sc.nextInt();
            System.out.println("nhap vao b:");
            b=sc.nextInt();
            System.out.println("nhap dau vao:");
            dau = sc.next().charAt(0);
            switch (dau) 
            {
                case '+':
                    int tong;
                    tong=a+b;
                    System.out.println(a+" + "+b +" = "+tong);
                    break;
                case '-':
                    int hieu;
                    hieu=a-b;
                    System.out.println(a+" - "+b +" = "+hieu);
                    break;
                case '*':
                    int tich;
                    tich=a*b;
                    System.out.println(a+" * "+b +" = "+tich);
                    break;
                case '/':
                if(b!=0)
                    {
                        float thuong;
                        thuong= (float)a/b;
                        System.out.println(a+" / "+b +" = "+thuong);
                    }
                else 
                    System.out.println("khong tinh duoc ");
                default:
                    System.out.println("nhap sai");
            }
            
    }    
}
