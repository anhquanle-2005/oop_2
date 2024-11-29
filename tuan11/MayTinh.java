package tuan11;

import java.util.Scanner;

public class MayTinh {
    private String maMay;
    private String cpu;
    private String ram;
    private String gpu; 
    private String loaiMay;
    private String trangThai;
    private Double giaGio;
    public MayTinh() {
    }
   
    
    public MayTinh(String maMay, String cpu, String ram, String gpu, String loaiMay, String trangThai, Double giaGio) {
        this.maMay = maMay;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.loaiMay = loaiMay;
        this.trangThai = trangThai;
        this.giaGio = giaGio;
    }

    public String getMaMay() {
        return maMay;
    }
    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }
   
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getLoaiMay() {
        return loaiMay;
    }
    public void setLoaiMay(String loaiMay) {
        this.loaiMay = loaiMay;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Double getGiaGio() {
        return giaGio;
    }
    public void setGiaGio(Double giaGio) {
        this.giaGio = giaGio;
    }
    public void Nhap()
    {
        Scanner sc= new Scanner(System.in);
        Boolean giaTri=false;
        Boolean valid=false;
        System.out.println("Nhap vao ma may: ");
        this.maMay=sc.nextLine();
        System.out.println("Nhap vao thong tin ve cpu: ");
        this.cpu=sc.nextLine();
        System.out.println("Nhap vao thong tin Card do hoa: ");
        this.gpu=sc.nextLine();
        System.out.println("Nhap vao thong tin ve Ram: ");
        this.ram=sc.nextLine();
        do
        {
            System.out.println("May la loai nao (Pho thong || Trung cap || Cao cap): ");
            this.loaiMay=sc.nextLine();
            switch (this.loaiMay) {
                case "Pho thong":
                    this.giaGio=15.00;
                    giaTri=true;
                    break;    
                case "Trung cap":
                    this.giaGio=20.00;
                    giaTri=true;
                    break;
                case "Cao cap":
                    this.giaGio=30.00;
                    giaTri=true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, hay chon lai");
                    sc.nextLine();
                    break;
            }
        }
        while(!giaTri);  
        do { 
            System.out.println("Nhap vao trang thai cua may (Da dat || Bao tri || Chua dat):"); 
            try { 
                this.trangThai = sc.nextLine(); 
                if (this.trangThai.equals("Da dat") || this.trangThai.equals("Bao tri") || this.trangThai.equals("Chua dat")) 
                    valid = true;
                else 
                    throw new IllegalArgumentException("Lua chon khong hop le"); 
                }
                 catch (IllegalArgumentException e) { 
                    System.out.println(e.getMessage() + ", hay nhap lai."); 
                } 
        } while (!valid); 
    }
    @Override
    public String toString() {
        return maMay + "," + cpu + "," + ram + "," + gpu + "," + loaiMay
                + "," + trangThai + "," + giaGio;
    }
}

