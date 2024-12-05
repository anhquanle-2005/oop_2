package View;

import javax.swing.*;

import Admin.DSPhong;
import Admin.MayTinh;
import Admin.Phong;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemMayTinhFrame extends JFrame {
    private DSPhong dsPhong;
    private Phong phong;
    private JTextField txtMaMay, txtCpu, txtRam, txtGpu, txtLoaiMay, txtGiaGio;
    private JComboBox<String> cbTrangThai;
    private JComboBox<String> cbLoaiMay;

    public ThemMayTinhFrame(Phong phong, DSPhong dsPhong) {
        this.dsPhong=dsPhong;
        this.phong = phong;
        initUI();
    }

    private void initUI() {
        setTitle("Thêm Máy Tính");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 4));

        // Tạo các trường nhập dữ liệu
        add(new JLabel("Mã Máy:"));
        txtMaMay = new JTextField();
        add(txtMaMay);

        add(new JLabel("CPU:"));
        txtCpu = new JTextField();
        add(txtCpu);

        add(new JLabel("RAM:"));
        txtRam = new JTextField();
        add(txtRam);

        add(new JLabel("GPU:"));
        txtGpu = new JTextField();
        add(txtGpu);

        add(new JLabel("Loại Máy:"));
        cbLoaiMay = new JComboBox<>(new String[]{"Pho thong", "Trung cap", "Cao cap"});
        cbLoaiMay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGiaGio();
            }
        });
        add(cbLoaiMay);

        add(new JLabel("Giá Giờ:"));
        txtGiaGio = new JTextField();
        txtGiaGio.setEditable(false);  // Không cho phép người dùng nhập thủ công
        add(txtGiaGio);

        add(new JLabel("Trạng Thái:"));
        cbTrangThai = new JComboBox<>(new String[]{"Chua", "Da dat", "Bao tri"});
        add(cbTrangThai);

        JButton btnAdd = new JButton("Thêm Máy Tính");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themMayTinh();
                
            }
        });
        add(btnAdd);
    }

    private void setGiaGio() {
        String loaiMay = cbLoaiMay.getSelectedItem().toString();
        double giaGio;
        switch (loaiMay) {
            case "Pho thong":
                giaGio = 15.00;
                break;
            case "Trung cap":
                giaGio = 20.00;
                break;
            case "Cao cap":
                giaGio = 30.00;
                break;
            default:
                giaGio = 0.0;
                break;
        }
        txtGiaGio.setText(String.valueOf(giaGio));
    }

    private void themMayTinh() {
        String maMay = txtMaMay.getText();
        // Kiểm tra xem mã máy đã tồn tại hay chưa
        for (MayTinh mt : phong.getDSMAYTINH()) {
            if (mt.getMaMay().equals(maMay)) {
                JOptionPane.showMessageDialog(this, "Mã máy đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String cpu = txtCpu.getText();
        String ram = txtRam.getText();
        String gpu = txtGpu.getText();
        String loaiMay = cbLoaiMay.getSelectedItem().toString();
        String trangThai = cbTrangThai.getSelectedItem().toString();
        double giaGio;

        try {
            giaGio = Double.parseDouble(txtGiaGio.getText());
            MayTinh mt = new MayTinh(maMay, cpu, ram, gpu, loaiMay, trangThai, giaGio);
            phong.getDSMAYTINH().add(mt);
            phong.ghiFileMayTinh(mt);
            dsPhong.capNhatfile();
            JOptionPane.showMessageDialog(this, "Thêm máy tính thành công!");
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá giờ phải là một số hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}