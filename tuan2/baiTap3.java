package tuan2;
import java.util.Scanner;

public class baiTap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so thu nhat");
        int a = sc.nextInt();
        System.out.println("nhap vao so thu hai");
        int b = sc.nextInt();
        int tg = a+b;
        System.out.printf("tong cua 2 so: %d \n",tg);
        int t = a*b;
        System.out.printf("tich cua 2 so: %d \n",t);
        int h = a-b;
        System.out.printf("hieu cua 2 so: %d \n",h);
        float thg = (float)a/b;
        System.out.printf("thuong cua 2 so: %f \n",thg);
        int phd = a%b;
        System.out.printf("phan du cua 2 so: %d \n",phd);
    }
}