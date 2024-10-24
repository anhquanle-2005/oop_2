package TH.Tuan8.baiTap1;

public class meo extends dongVat {
    // Constructor không tham số (mặc định)
    public meo() {
        super();  // Gọi constructor của lớp cha (dongVat)
    }

    @Override
    public void tiengKeu() {
        System.out.println("Meo meo");
    }
}
