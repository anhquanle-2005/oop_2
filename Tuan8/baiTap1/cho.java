package TH.Tuan8.baiTap1;

public class cho extends dongVat {
    public cho() {
        super();  // Gọi constructor của lớp cha (dongVat)
    }

    @Override
    public void tiengKeu() {
        System.out.println("Gâu gâu");
    }
}

