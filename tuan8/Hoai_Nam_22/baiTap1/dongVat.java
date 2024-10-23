package tuan8.Hoai_Nam_22.bai1;

public class dongVat {
    protected String ten;
    protected int tuoi;
    public dongVat (String ten, int tuoi){
        this.ten = ten;
        this.tuoi = tuoi;
    }
    public String getten(){
        return this.ten;
    }
    public int gettuoi(){
        return this.tuoi;
    }
    public String tiengKeu() {
        return ""; // Phương thức này sẽ được ghi đè trong các lớp con
    }
}
