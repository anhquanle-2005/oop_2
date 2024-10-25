package tuan8.Anh_Quan.baiTap1;

public class Animal {   
    protected String ten;
    protected int tuoi;

    public Animal(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return ten + ", tuoi=" + tuoi ;
    }
    
    
    
}
