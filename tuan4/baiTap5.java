package oop_2.tuan4;
import java.util.*;
public class baiTap5 {

    public static void main(String[] args) 
    {
        int a,b,uc,bc;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao hai so:");
        a = sc.nextInt();
        b = sc.nextInt();
        uc=ucln(a, b);
        bc=bcnn(a, b);
        System.out.println("uoc chung lon nhat cua "+a+" va "+b+" la "+uc);
        System.out.println("boi chung nho nhat cua "+a+" va "+b+" la "+bc);

    }
    public static int ucln(int x, int y)
    {
        do {
            if(x>y)
                x=x-y;
            else
                y=y-x;
        } while (x!=y);
        return x;
    }
    public static int bcnn(int x, int y)
    {
        int s= ucln(x, y);
        return x*y/s;
    }
}