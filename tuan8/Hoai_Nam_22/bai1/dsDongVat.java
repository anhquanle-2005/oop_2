package tuan8.Hoai_Nam_22.bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class dsDongVat {
    public static void main(String[] args) {
        int i,n,tuoi;
        String ten, loai = null;
        Scanner sc = new Scanner(System.in);
        ArrayList <dongVat> DONGVAT = new ArrayList<>();
        System.out.print("nhap vao bao nhieu con: ");
        n = sc.nextInt();
        sc.nextLine();
        for(i=1;i<=n;i++)
        {
            
            System.out.print("nhap vao loai dong vat: ");
            loai = sc.nextLine();
            System.out.print("nhap vao ten dong vat: ");
            ten = sc.nextLine();
            System.out.print("nhap vao tuoi cua dong vat: ");
            tuoi = sc.nextInt();
            sc.nextLine();
            if(loai.equals("meo"))
                DONGVAT.add(new meo(ten,tuoi));
            else
                if(loai.equals("cho"))
                    DONGVAT.add(new cho(ten,tuoi));
                else
                    DONGVAT.add(new chim(ten,tuoi));
        }
       
        for (dongVat dv : DONGVAT) {
            System.out.println(dv.ten+" - "+dv.tuoi+" - "+dv.tiengKeu());
        }
    }
}
