package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Admin.DSPhong;
import NhanVien.DSnhanVien;
import NhanVien.nhanVien;

public class HienThiDanhSachNV extends JFrame {
    private DSPhong dsPhong;
    private DSnhanVien dsNhanVien; // Sửa thành dsNhanVien
    private JTable table;
    private DefaultTableModel model;  // Bảng hiển thị nhân viên

    public HienThiDanhSachNV() {
        this.dsPhong = new DSPhong();
        this.dsPhong.docfile();
        this.dsPhong.docfileMayTinh();
        this.dsNhanVien = new DSnhanVien();
        this.init();
    }

    private void init() {
        this.setTitle("Admin");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Tạo tiêu đề trắng với nền đỏ
        JLabel titleLabel = new JLabel("Quản lý quán Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.RED);
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Panel chứa tiêu đề và các nút
        JPanel containerPanel = new JPanel(new BorderLayout());

        // Panel cho các nút
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 20, 20));
        buttonPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        buttonPanel.setBackground(new Color(54, 54, 54));

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonTextColor = Color.WHITE;
        Color buttonBackgroundColor = new Color(0, 102, 204); // Màu xanh

        UIManager.put("Button.select", new Color(132, 112, 255));

        JButton themPhongMay = createStyledButton("Thêm phòng máy", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton themMayTinh = createStyledButton("Thêm máy tính vào phòng", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton themNhanVien = createStyledButton("Thêm nhân viên mới", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton xoaNhanVien = createStyledButton("Xóa nhân viên", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton xemDanhSachNhanVien = createStyledButton("Xem danh sách nhân viên", buttonFont, buttonTextColor, new Color(128, 0, 128));

        buttonPanel.add(themPhongMay);
        buttonPanel.add(themMayTinh);
        buttonPanel.add(themNhanVien);
        buttonPanel.add(xoaNhanVien);
        buttonPanel.add(xemDanhSachNhanVien);

        // Thêm tiêu đề và panel nút vào containerPanel
        containerPanel.add(titleLabel, BorderLayout.NORTH);
        containerPanel.add(buttonPanel, BorderLayout.CENTER);
        containerPanel.setBorder(new EmptyBorder(10, 10, 10, 30));

        // Tạo panel chứa các nút admin, nhân viên, user
        JPanel headerPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        headerPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        JButton adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Arial", Font.BOLD, 20));
        adminButton.setForeground(Color.WHITE);
        adminButton.setFocusPainted(false);
        adminButton.setBackground(new Color(235, 0, 0));

        JButton nhanVienButton = new JButton("Nhân viên");
        nhanVienButton.setFont(new Font("Arial", Font.BOLD, 20));
        nhanVienButton.setForeground(Color.WHITE);
        nhanVienButton.setBackground(new Color(0, 245, 255));

        JButton userButton = new JButton("User");
        userButton.setFont(new Font("Arial", Font.BOLD, 20));
        userButton.setForeground(Color.WHITE);
        userButton.setBackground(new Color(0, 102, 204));

        headerPanel.add(adminButton);
        headerPanel.add(nhanVienButton);
        headerPanel.add(userButton);

        // JPanel chứa "Man hinh dieu huong"
        JPanel main = new JPanel(new BorderLayout());
        JPanel cardPanel = new JPanel();
        JLabel cardLabel = new JLabel("Man hinh dieu huong");
        cardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cardLabel.setForeground(Color.BLACK);
        cardPanel.add(cardLabel);
        cardPanel.setBackground(Color.YELLOW);

        JPanel tablePanel = new JPanel(new BorderLayout());

        // Tạo bảng hiển thị nhân viên
        String[] columnNames = {"STK", "Tên Nhân Viên", "Số Điện Thoại", "Lương Cơ Bản", "Lương"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Thêm JScrollPane vào tablePanel
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        main.add(headerPanel, BorderLayout.NORTH);
        main.add(tablePanel, BorderLayout.CENTER);
        main.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(containerPanel, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        

        // Thêm ActionListener cho các nút
        themPhongMay.addActionListener(e -> {
            new ThemPhongFrame().setVisible(true);
            HienThiDanhSachNV.this.setVisible(false);
        });
//y la cai them nhan vien e chua lam cai hien thi nay no khong hien thi thong tin nhan vien o, hien thi danh sach nhan vine no khong co 
// da co dư lieu de hien thi chua, rooiif doc file noi o
        themNhanVien.addActionListener(e -> {
            new ThemNhanVien().setVisible(true);
            HienThiDanhSachNV.this.setVisible(false);
        });

        xoaNhanVien.addActionListener(e -> {
            new XoaNhanVien().setVisible(true);
            HienThiDanhSachNV.this.setVisible(false);
        });

        themMayTinh.addActionListener(e -> {
            new ThemMayTinh().setVisible(true);
            HienThiDanhSachNV.this.setVisible(false);
        });

        xemDanhSachNhanVien.addActionListener(e -> {
            System.out.println("Nút xem danh sách nhân viên được nhấn."); // Dòng debug
            model.setRowCount(0); 
            thongtinNV();  
        });

        adminButton.addActionListener(e ->{
            new AdminView();
            HienThiDanhSachNV.this.setVisible(false);
        });
        this.setVisible(true);
    }

    public void thongtinNV() {
        // dsNhanVien.docFile(); // Đọc lại dữ liệu từ file
        System.out.println("Doc thanh cong");
        System.out.println("Số lượng nhân viên: " + dsNhanVien.getNHANVIEN().size()); // In ra số lượng nhân viên
        if(dsNhanVien.getNHANVIEN().isEmpty()){
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
        for (nhanVien nv : dsNhanVien.getNHANVIEN()) {
            System.out.println("Đọc nhân viên: " + nv.getTenNV()); // In ra để kiểm tra
            Object[] row = {
                nv.getSTK(),
                nv.getTenNV(),
                nv.getSDT(),
                nv.getLuongCB(),
                nv.tinhLuong(),
            };
           
            model.addRow(row); // Thêm hàng mới vào bảng
        }
    }

    private JButton createStyledButton(String text, Font font, Color textColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(textColor);
        button.setBackground(backgroundColor);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HienThiDanhSachNV().setVisible(true));
    }
    
}
