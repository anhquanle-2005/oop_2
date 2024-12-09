package View;

import javax.swing.*;

import NhanVien.DSnhanVien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ThemNhanVienForm extends JFrame {
    private JTextField txtSTK, txtTen, txtSDT, txtLuongCB, txtMK,txtDate;
    private JButton btnSubmit;
    private DSnhanVien ds=new DSnhanVien();
    private JComboBox<String> cmbType;

    public ThemNhanVienForm() {
        setTitle("Thêm Nhân Viên");
        setSize(400, 350); // Tăng kích thước để chứa thêm trường nhập
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2)); // Cập nhật số hàng

        // Các trường nhập liệu
        add(new JLabel("Số Tài Khoản:"));
        txtSTK = new JTextField();
        add(txtSTK);

        add(new JLabel("Tên Nhân Viên:"));
        txtTen = new JTextField();
        add(txtTen);

        add(new JLabel("Mật khẩu"));
        txtMK=new JTextField();
        add(txtMK);

        add(new JLabel("Số Điện Thoại:"));
        txtSDT = new JTextField();
        add(txtSDT);

        add(new JLabel("Lương Cơ Bản:"));
        txtLuongCB = new JTextField();
        add(txtLuongCB);
        
        // Trường nhập ngày bắt đầu làm
        add(new JLabel("Ngày Bắt Đầu (yyyy-MM-dd):"));
        txtDate = new JTextField();
        add(txtDate);

        // ComboBox để chọn loại nhân viên
        add(new JLabel("Loại Nhân Viên:"));
        cmbType = new JComboBox<>(new String[]{"Full-time", "Part-time"});
        add(cmbType);

        // Nút Submit
        btnSubmit = new JButton("Thêm Nhân Viên");
        add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin và thêm nhân viên
                String stk = txtSTK.getText();
                String ten = txtTen.getText();
                String sdt = txtSDT.getText();
                String mk = txtMK.getText(); // Lấy mật khẩu từ trường nhập
                double luongCB;
        
                // Kiểm tra điều kiện mật khẩu
                if (!isValidPassword(mk)) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 6 ký tự, bao gồm chữ cái, số và ký tự đặc biệt!");
                    return; // Không thực hiện nếu mật khẩu không hợp lệ
                }
        
                try {
                    luongCB = Double.parseDouble(txtLuongCB.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Lương cơ bản không hợp lệ!");
                    return; // Không thực hiện nếu lương không hợp lệ
                }
        
                LocalDate ngayBD = null;
                String dateStr = txtDate.getText(); // Lấy ngày từ trường nhập
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    ngayBD = LocalDate.parse(dateStr, formatter); // Phân tích ngày
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ngày không hợp lệ! Vui lòng nhập theo định dạng yyyy-MM-dd.");
                    return; // Nếu ngày không hợp lệ, không thực hiện thêm nhân viên
                }
        
                // Gọi phương thức thêm nhân viên với thông tin đã nhập
                if (cmbType.getSelectedItem().equals("Full-time")) {
                    ds.themNhanVienFullT(stk,ten,sdt,mk,luongCB,ngayBD);
                  
                    // Thêm nhân viên full-time
                } 
                else {
                    ds.themNhanVienPartT(stk,ten,sdt,mk,luongCB, ngayBD);
                  
                }
                
                dispose();
            }
        });
    }
        private boolean isValidPassword(String password) {
            return password.length() >= 6 &&
            password.matches(".*[a-zA-Z]+.*") && // Có ít nhất một chữ cái
            password.matches(".*[0-9]+.*") && // Có ít nhất một chữ số
            password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*"); // Có ít nhất một ký tự đặc biệt
    }

}