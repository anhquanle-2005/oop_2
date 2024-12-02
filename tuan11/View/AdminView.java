package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Admin.DSPhong;
import NhanVien.DSnhanVien;

public class AdminView extends JFrame {
    private DSPhong dsPhong;
    private DSnhanVien nv;

    public AdminView() {
        this.dsPhong = new DSPhong();
        this.dsPhong.docfile();
        this.dsPhong.docfileMayTinh();
        nv = new DSnhanVien();
        this.init();
    }

    private void init() {
        this.setTitle("Admin");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Tạo tiêu đề trắng với nền đỏ
        JLabel titleLabel = new JLabel("Quan ly quan Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE); // Chữ trắng
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.RED); // Nền đỏ
        // Thêm khoảng trống phía dưới
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Panel chứa tiêu đề và các nút
        JPanel containerPanel = new JPanel(new BorderLayout());

        // Panel cho các nút
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 20, 20)); // Khoảng cách 20px giữa các nút
        buttonPanel.setBorder(new EmptyBorder(20, 10, 10, 10)); // Thêm khoảng cách phía trên

        // Thiết lập màu nền cho buttonPanel
        buttonPanel.setBackground(new Color(54, 54, 54));

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonTextColor = Color.WHITE;
        Color buttonBackgroundColor = new Color(0, 102, 204); // Màu xanh đậm

        // Thiết lập UIManager để điều chỉnh màu nhấn của nút
        UIManager.put("Button.select", new Color(132, 112, 255));

        JButton themPhongMay = createStyledButton("Them phong may", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton themMayTinh = createStyledButton("Them may tinh vao phong", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton themNhanVien = createStyledButton("Them nhan vien moi", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton xoaNhanVien = createStyledButton("Xoa nhan vien", buttonFont, buttonTextColor, buttonBackgroundColor);
        JButton xemDanhSachNhanVien = createStyledButton("Xem danh sach nhan vien", buttonFont, buttonTextColor, buttonBackgroundColor);

        buttonPanel.add(themPhongMay);
        buttonPanel.add(themMayTinh);
        buttonPanel.add(themNhanVien);
        buttonPanel.add(xoaNhanVien);
        buttonPanel.add(xemDanhSachNhanVien);

        // Thêm tiêu đề và panel nút vào containerPanel
        containerPanel.add(titleLabel, BorderLayout.NORTH);
        containerPanel.add(buttonPanel, BorderLayout.CENTER);
        containerPanel.setBorder(new EmptyBorder(10,10,10,30));
        
        // Tạo panel chứa các nút admin, nhân viên, user
        JPanel headerPanel = new JPanel(new GridLayout(1, 3, 20, 0)); // Bố cục ngang với khoảng cách 20px giữa các nút
        headerPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Thêm khoảng cách phía trên headerPanel

        JButton adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Arial", Font.BOLD, 20)); // Kích thước to hơn
        adminButton.setForeground(Color.WHITE);
        adminButton.setFocusPainted(false);
        adminButton.setBackground(new Color(235, 0, 0)); // Màu đậm hơn

    
        JButton nhanVienButton = new JButton("Nhân viên");
        nhanVienButton.setFont(new Font("Arial", Font.BOLD, 20)); // Kích thước to hơn
        nhanVienButton.setForeground(Color.WHITE);
        nhanVienButton.setBackground(new Color(0, 245, 255)); // Màu xanh đậm

        JButton userButton = new JButton("User");
        userButton.setFont(new Font("Arial", Font.BOLD, 20)); // Kích thước to hơn
        userButton.setForeground(Color.WHITE);
        userButton.setBackground(new Color(0, 102, 204)); // Màu xanh đậm

        headerPanel.add(adminButton);
        headerPanel.add(nhanVienButton);
        headerPanel.add(userButton);

        // JPanel chứa "Man hinh dieu huong"
        JPanel main = new JPanel(new BorderLayout());
        JPanel cardPanel = new JPanel();
        JLabel cardLabel = new JLabel("Man hinh dieu huong");
        cardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cardLabel.setForeground(Color.BLACK); // Màu chữ đen
        cardPanel.add(cardLabel);

        main.add(headerPanel, BorderLayout.NORTH); // Thêm headerPanel vào phía trên
        main.add(cardPanel, BorderLayout.CENTER);

        this.add(containerPanel, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        this.setVisible(true);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // UIManager.put("Button.select", new Color(235, 0, 0));
                adminButton.setBackground(new Color(235, 0, 0)); // Giữ màu đỏ
            }
        });
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
        SwingUtilities.invokeLater(() -> new AdminView().setVisible(true));
    }
}
