package tuan3;
import java.util.*;
public class baiTap3 {
    public static void  count(int A, int B, int C) {
        float X1, X2;
        int delta = B*B-4*A*C ;
        if(delta < 0)
        {
            System.out.println("phuong trinh vo nghiem");
        }
        else
        {
            if(delta == 0)
            {
                X1 =-1*B/(2*A);
                System.out.printf("phuong trinh co mot nghiem la: %f",X1);
            }
            else
            {
                X1 = (float) (-B+Math.sqrt(delta))/(2*A);
                X2 = (float) (-B-Math.sqrt(delta))/(2*A);
                System.out.printf("phuong trinh co hai ngiem \n X1 = %f \n X2 = %f",X1,X2);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.print("nhap vao hang so a, b, c:");
        int A = sr.nextInt();
        int B = sr.nextInt();
        int C = sr.nextInt();
        count(A,B,C);
    }
}
