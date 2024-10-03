import java.util.*;
public class baiTap4 {
    static int [] M;
    static int N;
    static Scanner sc ;
    public static void main(String[] args) {
        int T;
        sc= new Scanner(System.in);
        System.out.println("nhap vao so phan tu mang :");
        N = sc.nextInt();
        M = new int[N];
        NHAP();
        XUAT();
        T=KTRA();
        System.out.println("so xuat hien nhieu nhat trong mang la "+T);
    }
    public static void NHAP()
    {
        for( int i=0;i<N;i++)
        {
            System.out.print("M["+i+"]=");
            M[i] = sc.nextInt();
        }
    }
    public static void XUAT()
    {
        int i;
        for(i=0;i<N;i++)
            System.out.println(M[i]);
    }
    public static int KTRA()
    {
        int i,j,dem,s,x;
        x=0;
        s=0;
        for(i=0;i<N;i++)
        {
            dem=0;
            for(j=i;j<N;j++)
                if(M[j]==M[i])
                    dem=dem+1;
            if(dem>s)
            {
                s=dem;
                x=M[i];
            }
        }
        return x;
    }
}