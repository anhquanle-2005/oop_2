<<<<<<< HEAD

=======
package tuan5;
>>>>>>> Anh_Quan

import java.util.Scanner;

public class baiTap6 {
    static int [] M;
    static int X,N;
    static Scanner sc;
    public static void main(String[] args) 
    {
        sc= new Scanner(System.in);
        System.out.println("nhap so phan tu vao:");
        N=sc.nextInt();
        M=new int[N];
        Nhap();
        Xuat();
        Xoa(X);
    }    
    static void Nhap()
    {
        for(int i=0;i<N;i++)
        {
            System.out.println("M["+i +"]");
            M[i]=sc.nextInt();
        }
    }//end nhap

    static void Xuat()
    {
        for(int i=0;i<N;i++)
            System.out.println("M["+i +"]="+M[i]);
    }//end xuat
    static int Tim(int X)
    {
        int viTri=0;
        System.out.println("nhap X:");
        X=sc.nextInt();
        boolean found=false;
        for(int i=0;i<N && !found;i++)
        {
            if (M[i]==X) 
                {
                    found=true;
                    viTri=i;
                }
        }
        if (found)  
            System.out.println("tim thay x trong mang m");
        else    
            System.out.println("khong tim thay x trong mang");

        return viTri;
    }//end tim
    static void Xoa(int X)
    {
        int K=Tim(X);
        for(int j=K;j<N-1;j++)
           {
             M[j]=M[j+1];
            //  System.out.println(M[j]);
           }
        M[N-1]=0;
        N--;
        Xuat();
    }
}
