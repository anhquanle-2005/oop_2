package TH.Tuan7.baiTap3;
import java.util.Scanner;
public class TaiKhoan {
    private long STK;
    private String tenTK;
    private long soDu;
    private String passWork;
    public TaiKhoan (long STK, String tenTK, long soDu, String passWork)
    {
        this.STK = STK;
        this.tenTK = tenTK;
        this.soDu =soDu;
        setPassWork(passWork);
    }
    public long getSTK(){
        return this.STK;
    }
    public String gettenTK(){
        return this.tenTK;
    }
    public long getSoDu(){
        return this.soDu;
    }
    public void setPassWork(String passWork)
    {
        if(passWork.length()>=6)
            this.passWork = passWork;
        else
            throw new IllegalArgumentException("Mật khẩu phải dài từ 6 ký tự trở lên");
    }
    public static TaiKhoan Nhap(){
        long STK, soDu;
        Scanner sc = new Scanner(System.in);
        String tenTK,passWork;
        System.out.print("Nhập số tài khoản: ");
        STK = sc.nextLong();
        tenTK = sc.nextLine();
        System.out.print("Nhập tên tài khoản: ");
        tenTK = sc.nextLine();
        System.out.print("Nhập số dư: ");
        soDu = sc.nextLong();
        passWork = sc.nextLine();
        System.out.print("Tạo mật khẩu: ");
        passWork = sc.nextLine();
        return new TaiKhoan(STK, tenTK, soDu, passWork);
    }
    public void Xuat(){
        System.out.println("Số tài khoản: " + this.STK);
        System.out.println("Tên tài khoản: " + this.tenTK);
        System.out.println("Số dư: " + this.soDu);
        System.out.println("Mật khẩu: ***** (đã được thiết lập)");
    }
    public void doiPass(String matKhauCu, String matKhauMoi)
    {
        if(matKhauCu.equals(this.passWork))
            setPassWork(matKhauMoi);
        else
           throw new IllegalArgumentException("Mật khẩu cũ không đúng");
    }
    public void NhapPassDoi(){
        System.out.print("Bạn có muốn đổi mật khẩu không? (Có:1|Không:0): ");
        int n;
        String passcu, passmoi;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        if(n==1)
        {
            System.out.print("Nhập mật khẩu cũ: ");
            passcu = sc.nextLine();
            System.out.print("Nhập mật khẩu mới: ");
            passmoi = sc.nextLine();
            doiPass(passcu, passmoi);
        }
    }
}
    