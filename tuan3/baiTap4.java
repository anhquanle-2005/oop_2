package oop_2.tuan3;
import java.util.Scanner;

public class baiTap4 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();

        System.out.print("Nhập số c: ");
        int c = scanner.nextInt();


        int max = a;

        if (b > max) 
        {
            max = b; 
        }
        if (c > max) 
        {
            max = c;
        }

        System.out.println("Số lớn nhất trong 3 số là: " + max);

        scanner.close();

    }
}
