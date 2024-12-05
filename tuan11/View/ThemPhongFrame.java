package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class ThemPhongFrame extends JFrame {
    private DSPhong dsPhong;
    private DSnhanVien nv;

    private JTextField txtSoPhong;
    private JTextField txtLoaiPhong;

    public ThemPhongFrame() {
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

        // Panel cho các nút
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 20, 20));
        buttonPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        buttonPanel.setBackground(new Color(54, 54, 54));

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonTextColor = Color.WHITE;
        Color buttonBackgroundColor = new Color(0, 102, 204);

        UIManager.put("Button.select", new Color(132, 112, 255));

        JButton themPhongMay = createStyledButton("Them phong may", buttonFont, buttonTextColor, new Color(128, 0, 128));
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
        // Tạo panel chứa thông tin nhập
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 30, 10));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Trên phần khởi tạo inputPanel
        Font f1 = new Font("Arial", Font.BOLD, 20);
        JLabel lblSoPhong = new JLabel("Nhap so phong:");
        lblSoPhong.setFont(f1);
        txtSoPhong = new JTextField(20);
        txtSoPhong.setFont(f1);
        JPanel soPhongPanel = new JPanel();
    //    soPhongPanel.add(txtSoPhong);
        //soPhongPanel.setPreferredSize(new Dimension(10, 10)); // Chiều cao 30
        inputPanel.add(lblSoPhong);
        inputPanel.add(txtSoPhong);

        JLabel lblLoaiPhong = new JLabel("Nhap loai phong");
        lblLoaiPhong.setFont(f1);
        txtLoaiPhong = new JTextField(20);
        txtLoaiPhong.setFont(f1);
        inputPanel.add(lblLoaiPhong);
        inputPanel.add(txtLoaiPhong);
        
        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Arial", Font.BOLD, 20));
        btnThem.setBackground(new Color(0, 102, 204));
        btnThem.setForeground(Color.WHITE);

        // Tạo panel cho nút "Thêm" và thêm nó vào main
        JPanel butonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Căn phải
        butonPanel.add(btnThem);
        main.add(butonPanel, BorderLayout.SOUTH);
        


        // Thêm inputPanel vào containerPanel
        main.add(inputPanel,BorderLayout.CENTER);
        this.add(containerPanel, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        this.setVisible(true);

        // Thêm ActionListener cho nút "Thêm"
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị từ các JTextField
                String soPhong = txtSoPhong.getText();
                String loaiPhong = txtLoaiPhong.getText();
                
                // Kiểm tra xem các trường nhập có hợp lệ không
                if (!soPhong.isEmpty() && !loaiPhong.isEmpty()) {
                    // Tạo một đối tượng Phong
                    Phong phong = new Phong();
                    
                    // Kiểm tra mã phòng
                    if (!phong.kiemTraSoPhong(soPhong)) {
                        JOptionPane.showMessageDialog(null, "Mã phòng không hợp lệ.");
                        return; // Kết thúc hàm nếu mã phòng không hợp lệ
                    }
                    phong.setMaPhong(soPhong);
                    
                    // Kiểm tra loại phòng
                    boolean loaiPhongHopLe = true;
                    switch (loaiPhong) {
                        case "phong Don":
                            phong.setMaPhong("P"+soPhong);
                            phong.setPhiPhong(5000.0);
                            break;
                        case "phong Doi":
                            phong.setMaPhong("PD"+soPhong);
                            phong.setPhiPhong(10000.0);
                            break;
                        case "phong Vip":
                            phong.setMaPhong("PV"+soPhong);
                            phong.setPhiPhong(12000.0);
                            break;
                        case "phong Thi Dau":
                            phong.setMaPhong("PX"+soPhong);
                            phong.setPhiPhong(20000.0);
                            break;
                        default:
                            loaiPhongHopLe = false; // Đánh dấu loại phòng không hợp lệ
                            break;
                    }
                    
                    if (!loaiPhongHopLe) {
                        JOptionPane.showMessageDialog(null, "Loại phòng không hợp lệ.");
                        return; // Kết thúc hàm nếu loại phòng không hợp lệ
                    }
                    phong.setLoaiPhong(loaiPhong);
                    
                    // Kiểm tra xem mã phòng đã tồn tại chưa
                    if (dsPhong.kiemTraMaPhong(phong.getMaPhong())) {
                        JOptionPane.showMessageDialog(null, "Đã có mã phòng. Vui lòng nhập mã phòng khác.");
                        return; // Kết thúc hàm nếu phòng đã tồn tại
                    }
                    
                    // Thêm phòng vào danh sách (giả sử bạn đã có phương thức này trong dsPhong)
                    dsPhong.themPhong(phong);
                    
                    // Hiển thị thông báo thành công
                    JOptionPane.showMessageDialog(null, "Thêm phòng thành công: " + phong.toString());
                    
                    // Xóa các trường nhập sau khi thêm
                    txtSoPhong.setText("");
                    txtLoaiPhong.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                }
            }
        });    
        xemDanhSachNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new HienThiDanhSachNV().setVisible(true);
                ThemPhongFrame.this.setVisible(false);
            }
        });
        themNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ThemNhanVien().setVisible(true);
                ThemPhongFrame.this.setVisible(false);
            }
        });        xoaNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new XoaNhanVien().setVisible(true);
                ThemPhongFrame.this.setVisible(false);
            }
        });       themMayTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ThemMayTinh().setVisible(true);
                ThemPhongFrame.this.setVisible(false);
            }
        });      adminButton.addActionListener(new ActionListener() {
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
        SwingUtilities.invokeLater(() -> new ThemPhongFrame().setVisible(true));
    }
}