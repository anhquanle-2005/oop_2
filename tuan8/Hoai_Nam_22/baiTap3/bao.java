package tuan8.Hoai_Nam_22.bai3;

public class bao extends taiLieu {
    protected String nhaXuatBan;
    public bao(){
        super();
        nhap();
    }
    public String getnhaXuatBan(){
        return this.nhaXuatBan;
    }
    public void nhap()
    {
        super.nhap();
        System.out.print("nhap vao nha xuat ban: ");
        this.nhaXuatBan = sc.nextLine();
        System.out.println("------------------------------------------------------------");
    }
    public String thuocTinh()
    {
        return getnhaXuatBan();
    }
}
