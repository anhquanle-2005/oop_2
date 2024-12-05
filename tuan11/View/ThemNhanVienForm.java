package View;

import javax.swing.*;

import NhanVien.DSnhanVien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ThemNhanVienForm extends JFrame {
    private JTextField txtSTK, txtTen, txtSDT, txtLuongCB, txtDate;
    private JButton btnSubmit;
    private DSnhanVien ds=new DSnhanVien();
    private JComboBox<String> cmbType;

    public ThemNhanVienForm() {
        setTitle("Thêm Nhân Viên");
        setSize(400, 350); // Tăng kích thước để chứa thêm trường nhập
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2)); // Cập nhật số hàng

        // Các trường nhập liệu
        add(new JLabel("Số Tài Khoản:"));
        txtSTK = new JTextField();
        add(txtSTK);

        add(new JLabel("Tên Nhân Viên:"));
        txtTen = new JTextField();
        add(txtTen);

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
                double luongCB;
        
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
                    ds.themNhanVienFT(); // Thêm nhân viên full-time
                } else {
                    ds.themNhanVienPT(); // Thêm nhân viên part-time
                }
        
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
                // Đóng cửa sổ
                dispose();
            }
        });
    }
}