package tuan8.Hoai_Nam_22.baiTap3;

import java.util.ArrayList;
import java.util.Scanner;

public class dsTaiLieu {
    public static void main(String[] args) {
        ArrayList <taiLieu> TAILIEU = new ArrayList<>();
        int i,n;
        String k;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao so tai lieu: ");
        n = sc.nextInt();
        sc.nextLine();
        for(i=1;i<=n;i++)
        {
            System.out.println("nhap vao tai lieu thu "+i);
            System.out.print("nhap vao kieu tai lieu: ");
            k = sc.nextLine();
            switch (k) {
                case "sach" :
                    TAILIEU.add(new sach());
                    break;
                case "tap chi":
                    TAILIEU.add(new tapChi());
                    break;
                case "bao":
                    TAILIEU.add(new bao());
                    break;
                default:
                    System.out.println("nhap vao 1 trong 3 gia tri 'sach'|'tap chi'|'bao' ");
                    i--;
                    break;
            }
        }
        for (taiLieu TL : TAILIEU) {
            System.out.println(TL.maTL+" - "+TL.tenTL+" - "+TL.thuocTinh());
        }
    }
}
