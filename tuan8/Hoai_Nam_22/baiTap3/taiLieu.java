package tuan8.Hoai_Nam_22.baiTap3;

import java.util.Scanner;

public class taiLieu {
    protected String maTL;
    protected String tenTL;
    protected String namXuatBan;
    public Scanner sc;
    public taiLieu(){}
    public String getmaTL()
    {
        return this.maTL;
    }
    public String gettenTL(){
        return this.tenTL;
    }
    public String getnamXuatBan()
    {
        return this.namXuatBan;
    }
    public void nhap()
    {
        sc = new Scanner(System.in);
        System.out.print("nhap vao ma tai lieu: ");
        this.maTL = sc.nextLine();
        System.out.print("nhap vao ten tai lieu: ");
        this.tenTL = sc.nextLine();
        System.out.print("nhap vao nam san xuat: ");
        this.namXuatBan = sc.nextLine();
    }
    public String thuocTinh()
    {
        return "";
    }

}
