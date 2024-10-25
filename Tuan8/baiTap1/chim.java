package TH.Tuan8.baiTap1;

public class chim extends dongVat {
    public chim() {
        super();  // Gọi constructor của lớp cha (dongVat)
    }

    @Override
    public void tiengKeu() {
        System.out.println("Chíp chíp");
    }
}
