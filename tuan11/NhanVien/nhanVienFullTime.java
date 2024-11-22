package NhanVien;


import java.time.LocalDate;

public class nhanVienFullTime extends  nhanVien{
    protected double phuCap;
    public nhanVienFullTime(){}

    public nhanVienFullTime(double phuCap, LocalDate NgayBD, String SDT, double luongCB, String maNV, String passWord, String tenNV) {
        super(NgayBD, SDT, luongCB, maNV, passWord, tenNV);
        this.phuCap = phuCap;
    }
    
    public double getPhuCap() {
        return phuCap;
    }
    public void setPhuCap() {

        int ngayht = LocalDate.now().getYear();
        int ngbd = NgayBD.getYear();
        if(ngayht-ngbd<3)
            this.phuCap =  1000000;
        else
            this.phuCap = 2000000;

    }
    public void nhapFT()
    {
        super.nhap();
        setPhuCap();
    }
    @Override
    public double tinhLuong() {
        return luongCB+phuCap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(STK).append(";");
        sb.append(tenNV).append(";");
        sb.append(getPassWord()).append(";");
        sb.append(NgayBD).append(";");
        sb.append(SDT).append(";");
        sb.append(luongCB).append(";");
        sb.append(sc).append(";");
        sb.append(phuCap).append(";");
        sb.append("null");
        return sb.toString();
    }
    
}
