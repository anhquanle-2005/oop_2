package tuan11;

public class Main {
    public static void main(String[] args) {
        DSPhong dsPhong = new DSPhong();

        // Thêm một vài phòng để thử nghiệm
        System.out.println("Thêm phòng:");
        dsPhong.themPhong();  // Nhập thông tin phòng từ bàn phím
        dsPhong.themPhong();  // Nhập thêm phòng khác

        // Ghi danh sách phòng ra file
        String fileName = "dsphong.txt";
        dsPhong.ghiDSPhong(fileName);
        // Tạo một đối tượng DSPhong mới để kiểm tra đọc từ file
        DSPhong dsPhongMoi = new DSPhong();

        // Đọc danh sách phòng từ file
        dsPhongMoi.docDSPhong("D:\\k23-2-1-2024\\dsphong.txt");

        // Hiển thị danh sách phòng đã đọc
        System.out.println("Danh sách phòng đã đọc từ file:");
        dsPhongMoi.hienThiDSPhong();
    }
}
