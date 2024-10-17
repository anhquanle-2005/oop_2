package tuan8.Hoai_Nam_22.bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class dsNhanVien {
    public static void main(String[] args) {
        int n,i;
        String loaiNV;
        Scanner sc = new Scanner(System.in);
        ArrayList <nhanVien> NHANVIEN = new ArrayList<>();
        System.out.print("nhap vao so nhan vien: ");
        n = sc.nextInt();
        sc.nextLine();
        for(i=1;i<=n;i++)
        {
            System.out.println("nhap vao nhan vien thu "+i);
            System.out.print("nhap vao loai nhan vien: ");
            loaiNV = sc.nextLine();
            if(loaiNV.equals("sx"))
                NHANVIEN.add(new nhanVienSanXuat());
            else
                if(loaiNV.equals("vp"))
                    NHANVIEN.add(new nhanVienVanPhong());
                else
                    throw new IllegalArgumentException("nhap vao 1 trong 2 gia tri 'sx'or'vp'");
        }
        for (nhanVien nv : NHANVIEN) {
            System.out.println(nv.maNV+" - "+nv.tenNV +" - "+nv.tinhLuong());
        }
    }
}
