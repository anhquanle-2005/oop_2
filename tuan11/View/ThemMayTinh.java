package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Admin.DSPhong;
import Admin.Phong;
import NhanVien.DSnhanVien;

public class ThemMayTinh extends JFrame {
    private DSPhong dsPhong;
    private DSnhanVien nv;
    private JTextField txtMaPhong; // Thêm JTextField cho mã phòng
    private JButton btnXacNhan; // Thêm nút xác nhận mã phòng

    public ThemMayTinh() {
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
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.RED);
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Panel chứa tiêu đề và các nút
        JPanel containerPanel = new JPanel(new BorderLayout());

          // Thêm panel để nhập mã phòng
        Font font= new Font("Arial", Font.BOLD, 20);
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel lblMaPhong = new JLabel("Nhập mã phòng:");
        lblMaPhong.setFont(font);
        txtMaPhong = new JTextField(15); // JTextField để nhập mã phòng
        btnXacNhan = new JButton("Xác Nhận");
        btnXacNhan.setFocusPainted(false);
        inputPanel.add(lblMaPhong);
        inputPanel.add(txtMaPhong);
        inputPanel.add(btnXacNhan);

        // Panel cho các nút
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 20, 20));
        buttonPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        buttonPanel.setBackground(new Color(54, 54, 54));

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonTextColor = Color.WHITE;
        Color buttonBackgroundColor = new Color(0, 102, 204); // Màu xanh

        UIManager.put("Button.select", new Color(132, 112, 255));

        JButton themPhongMay = createStyledButton("Them phong may", buttonFont, buttonTextColor, buttonBackgroundColor); // Màu tím
        JButton themMayTinh = createStyledButton("Them may tinh vao phong", buttonFont, buttonTextColor, new Color(128, 0, 128));
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
        containerPanel.add(inputPanel, BorderLayout.CENTER);
        containerPanel.add(buttonPanel, BorderLayout.CENTER);
        containerPanel.setBorder(new EmptyBorder(10,10,10,30));

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

        main.add(headerPanel, BorderLayout.NORTH);
        main.add(cardPanel, BorderLayout.CENTER);
        main.setBorder(new EmptyBorder(10,10,10,10));
        main.add(inputPanel,BorderLayout.CENTER);
        this.add(containerPanel, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        this.setVisible(true);

        btnXacNhan.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String maPhong = txtMaPhong.getText();
            Admin.Phong phong = dsPhong.timPhong(maPhong);
            if (phong != null) {
                JOptionPane.showMessageDialog(null, "Mã phòng hợp lệ!");
                new ThemMayTinhFrame(phong,dsPhong).setVisible(true); // Mở cửa sổ thêm máy tính
            } else {
                JOptionPane.showMessageDialog(null, "Mã phòng không hợp lệ. Vui lòng kiểm tra lại.");
            }
        }
        });
        themPhongMay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThemPhongFrame().setVisible(true);
                ThemMayTinh.this.setVisible(false);
            }
        });       
        xemDanhSachNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                HienThiDanhSachNV n1=new HienThiDanhSachNV();
                System.out.println("Nut hien thi danh sach nhan vien da duoc bam");
                n1.setVisible(true);
                n1.thongtinNV();
                ThemMayTinh.this.setVisible(false);
            }
        });

        themNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ThemNhanVien().setVisible(true);
                ThemMayTinh.this.setVisible(false);
            }
        });

        xoaNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new XoaNhanVien().setVisible(true);
                ThemMayTinh.this.setVisible(false);
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminButton.setBackground(new Color(235, 0, 0));
                new AdminView().setVisible(true);
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
        SwingUtilities.invokeLater(() -> new ThemMayTinh().setVisible(true));
    }
}
