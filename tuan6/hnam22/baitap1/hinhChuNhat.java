package tuan6.hnam22.baitap1;
import  java.util.*;

public class hinhChuNhat {
    private int chDai;
    private int chRong;
    public int getchDai()
    {
        return this.chDai;
    }
    public int getchRong()
    {
        return this.chRong;
    }
    public int chuVi()
    {
        return (this.chDai+this.chRong)*2;
    }
    public int dienTich(){
        return this.chDai*this.chRong;
    }
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao chieu dai: ");
        this.chDai = sc.nextInt(); 
        System.out.print("nhap vao chieu rong: ");
        this.chRong = sc.nextInt();
    }
    public void xuat()
    {
        System.out.println("chu vi cua hinh chu nhat c="+chuVi());
        System.out.println("dien tich cua hinh chu nhat s="+dienTich());

    }
}
