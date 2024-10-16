package oop_2.tuan5.baitap7;
import java.util.*;
public class btap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,i;
        System.out.printf("so hoc sinh can nhap: ");
        n = sc.nextInt();
        student[] sv = new student[n];
        for(i=0;i<n;i++)
        {
          sv[i] = new student();
          System.out.println("nhap vao sinh vien thu "+(i+1));
          sv[i].nhap();
        }
        student.sapxep(sv);
        for(student diem : sv)
        {
          diem.xuat();
        }
    }
}
