

package oop_2.tuan5;

import java.util.Scanner;

public class baiTap4 
{
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
        soLap();
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
    static void soLap() {   
        int maxcount = 0;
        int lapMax =8;

        for (int i = 0; i < N; i++) 
        {
            int count = 1; 
            for (int j = i + 1; j < N; j++) 
            {
                if (M[i] == M[j])
                    count++;
            }

            if (count > maxcount) 
            {
                maxcount = count;
                lapMax = M[i];
            }
        }        
        System.out.println("so " + lapMax + " xuat hien nhieu nhat voi " + maxcount + " lan.");
    }
}

