package tuan3;

import java.util.*;
public class bai1 {
       public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao mot so : ");
        a = sc.nextInt();
        KTRA(a);
    }
    public static void KTRA(int x)
    {
        if(x==0)
            System.out.println("so "+x+" la so 0");
        else
            if(x>0)
                System.out.println("so "+x+" la so duong");
            else
                System.out.println("so "+x+" la so am");
    }

    
}
