package KhachHang;

public class KhachHangVIP extends KhachHang {

    protected  int diemThuong;

    public KhachHangVIP(int diemThuong, String tenKH, String maKH, String matKhau, String sdt, double soTien, int soGioChoi, String loaiKhachHang) {
        super(tenKH, maKH, matKhau, sdt, soTien, soGioChoi, loaiKhachHang);
        this.diemThuong = diemThuong;
    }
    public int getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(int diemThuong) {
        this.diemThuong = diemThuong;
    }
    public void  quyDoiDiem()
    {
        String lc;
        do { 
            System.out.println("-----------MENU------------");
            System.out.println("| 1. Doi 1 gio choi (10đ) |");
            System.out.println("| 2. Doi 2 gio choi (17đ) |");
            System.out.println("| 3. Doi 3 gio choi (25đ) |");
            System.out.println("| 4. Doi 4 gio choi (32đ) |");
            System.out.println("| 5. Doi 5 gio choi (40đ) |");
            System.out.println("-----------MENU------------");
            System.out.print("Xin moi lua chon: ");
            lc = sc.nextLine();
            switch (lc) {
                case "1":
                    if(diemThuong>=10)
                    {
                        this.soGioChoi +=1;
                        this.diemThuong -= 10;
                    }else
                        System.out.println("Diem thuong cua ban khong du !");
                    break;
                case "2":
                    if(diemThuong>=17)
                    {
                        this.soGioChoi +=2;
                        this.diemThuong -= 17;
                    }
                    else
                        System.out.println("Diem thuong cua ban khong du !");
                    break;
                case "3":
                    if(diemThuong>=25)
                    {
                        this.soGioChoi +=3;
                        this.diemThuong -= 25;
                    }
                    else
                        System.out.println("Diem thuong cua ban khong du !");
                    break;
                case "4":
                    if(diemThuong>=32)
                    {
                        this.soGioChoi +=4;
                        this.diemThuong -= 32;
                    }
                    else
                        System.out.println("Diem thuong cua ban khong du !");
                    break;
                case "5":
                    if(diemThuong>=40)
                    {
                        this.soGioChoi +=5;
                        this.diemThuong -= 40;
                    }
                    else
                        System.out.println("Diem thuong cua ban khong du !");
                    break;
                case "0":
                    System.out.println("Thoat !");
                    break;
                default:
                    System.out.println("lua chon khong hop le !");
            }
        } while (!lc.equals("0"));
        
    }
    @Override
    public String toString() {
        return tenKH + "," + maKH + ","+getMatKhau()+","+ sdt
                + "," + soTien + "," + soGioChoi+","+loaiKhachHang+","+diemThuong ;
    }
    
    // @Override
    // public void menu() {
    //     System.out.println("Menu khách hàng bình thường");
    //     Scanner scanner = new Scanner(System.in);
    //     int choice;
    //     do {
    //         System.out.println("----------------------------------");
    //         System.out.println("Chọn chức năng của Khách hàng VIP:");
    //         System.out.println("1. Đăng nhập");
    //         System.out.println("2. Nạp tiền");
    //         System.out.println("3. Chơi game");
    //         System.out.println("4. Xem điểm thưởng");
    //         System.out.println("5. Quy đổi điểm thưởng");
    //         System.out.println("6. Đăng xuất");
    //         System.out.println("7. Thoát");
    //         System.out.print("Nhập lựa chọn của bạn: ");
    //         choice = scanner.nextInt();
    //         scanner.nextLine(); // Đọc dòng còn lại

    //         switch (choice) {
    //             case 1:
    //                 dangNhap(fileManager);
    //                 break;
    //             case 2:
    //                 System.out.print("Nhập số tiền muốn nạp: ");
    //                 double soTienNap = scanner.nextDouble();
    //                 this.napTien(soTienNap);
    //                 break;
    //             case 3:
    //                 choiGame();
    //                 break;
    //             case 4:
    //                 System.out.println("Điểm thưởng hiện tại: " + getDiemThuong());
    //                 break;
    //             case 5:
    //                 System.out.print("Nhập số điểm muốn quy đổi: ");
    //                 int diemQuyDoi = scanner.nextInt();
    //                 this.quyDoiDiem(diemQuyDoi);
    //                 break;
    //             case 6:
    //                 dangXuat(fileManager);
    //                 break;
    //             case 7:
    //                 System.out.println("Thoát chương trình.");
    //                 break;
    //             default:
    //                 System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
    //         }
    //     } while (choice != 7);
    // }

    // private void dangNhap() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Nhập tên tài khoản: "); // Sử dụng tên tài khoản
    //     String tenTaiKhoan = scanner.nextLine();
    //     System.out.print("Nhập mật khẩu: ");
    //     String password = scanner.nextLine();
    //     fileManager.dangNhap(tenTaiKhoan, password);
    // }

    // private void choiGame() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Nhập số giờ bạn muốn chơi: ");
    //     int gioChoi = scanner.nextInt();
    //     System.out.print("Nhập số phút bạn muốn chơi: ");
    //     int phutChoi = scanner.nextInt();

    //     if (gioChoi < 0 || phutChoi < 0) {
    //         System.out.println("Số giờ và phút chơi không hợp lệ.");
    //         return;
    //     }

    //     double chiPhi = (gioChoi + phutChoi / 60.0) * 5;
    //     if (this.soTien >= chiPhi) {
    //         this.soTien -= chiPhi;
    //         this.themThoiGianChoi(gioChoi, phutChoi);
    //         this.tangDiemThuong(gioChoi + phutChoi / 60); // Tăng điểm thưởng
    //         System.out.println("Bạn đã chơi " + gioChoi + " giờ và " + phutChoi + " phút. Tổng thời gian chơi hiện tại: " + this.getThoiGianChoi());
    //         System.out.println("Số tiền còn lại: " + this.soTien);
    //         System.out.println("Điểm thưởng hiện tại: " + getDiemThuong());
    //     } else {
    //         System.out.println("Bạn không đủ tiền để chơi " + gioChoi + " giờ và " + phutChoi + " phút.");
    //     }
    // }


 
}