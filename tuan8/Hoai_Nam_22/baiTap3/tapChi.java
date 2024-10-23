package tuan8.Hoai_Nam_22.bai3;

public class tapChi extends taiLieu{
    protected String soPhatHanh;
    public tapChi(){
        super();
        nhap();
    }
    public String getsoPhatHanh()
    {
        return this.soPhatHanh;
    }
    public void nhap()
    {
        super.nhap();
        System.out.print("nhap vao so phat hanh: ");
        this.soPhatHanh = sc.nextLine();
        System.out.println("------------------------------------------------------------");
    }
    public String thuocTinh()
    {
        return getsoPhatHanh();
    }

}
