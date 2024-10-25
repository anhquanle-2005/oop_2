package tuan7.Anh_Quan.baiTap2;
public class SinhVien {
    private String msv;
    private String hoTen;
    private Ngay ngaySinh;
    private double dtb;
    private Lop lopHoc;
    
    public SinhVien(String msv, String hoTen, Ngay ngaySinh, double dtb, Lop lopHoc) {
        this.msv = msv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.dtb = dtb;
        this.lopHoc = lopHoc;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Ngay getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Ngay ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(Float dtb) {
        this.dtb = dtb;
    }

    public Lop getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(Lop lopHoc) {
        this.lopHoc = lopHoc;
    }

     public String layTenKhoa()
    {
         return this.lopHoc.getTenKhoa();
    }

    public boolean thiDat()
    {
        return this.dtb>=5;
    }

    public boolean kiemTraNgaySinh(SinhVien sinhVienKhac)
    {
        return this.ngaySinh.equals(sinhVienKhac.ngaySinh);
    }

    public String xepLoai()
    {
        if(dtb>=8.5)
            return "Gioi";
        else    
            if(dtb>=6.5)
                return "Kha";
            else 
                if(dtb>=5)
                    return "Trung Binh";
                else 
                    return "Yeu";
    }
}
