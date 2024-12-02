package tuan10.giaoDien;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.*;
public class Login extends JFrame  {
	// public Login()
	{
		this.setTitle("Lua_chon");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		// set layout
		// FlowLayout FlowLayout= new FlowLayout();
		// FlowLayout FlowLayout_1= new FlowLayout(FlowLayout.RIGHT,50,50);
		// FlowLayout FlowLayout_2= new FlowLayout();
		//grid layout
		// GridLayout gridLayout= new GridLayout();
		// GridLayout gridLayout_1= new GridLayout(3,3);
		// GridLayout gridLayout_2= new GridLayout(3,3,25,100);

		// this.setLayout(gridLayout_2);

		// for (int i = 0; i < 10; i++) {
		// 	JButton jButton= new JButton(i+"");
		// 	this.add(jButton);
		// }
		// JButton jButton_1= new JButton("1");
		// JButton jButton_2= new JButton("2");
		// JButton jButton_3= new JButton("3");

		// add thanh phan
		// this.add(jButton_1);
		// this.add(jButton_2);
		// this.add(jButton_3);

// BorderLayout borderLayout = new BorderLayout();
// BorderLayout borderLayout_2 = new BorderLayout(15, 15);

// this.setLayout(borderLayout_2);

// JButton jButton_1 = new JButton("1");
// JButton jButton_2 = new JButton("2");
// JButton jButton_3 = new JButton("3");
// JButton jButton_4 = new JButton("4");
// JButton jButton_5 = new JButton("5");

// // add thành phần
// this.add(jButton_1, BorderLayout.NORTH);
// this.add(jButton_2, BorderLayout.SOUTH);
// this.add(jButton_3, BorderLayout.WEST);
// this.add(jButton_4, BorderLayout.EAST);
// this.add(jButton_5, BorderLayout.CENTER);
// 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		this.setVisible(true);
	}
	public Login() {
		this.setTitle("My Calculator");

		this.setSize(300, 300);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField jTextField = new JTextField(50);
		JPanel jPanel_head = new JPanel();
		jPanel_head.setLayout(new BorderLayout());
		jPanel_head.add(jTextField, BorderLayout.CENTER);

		JButton jButton_0 = new JButton("0");
		JButton jButton_1 = new JButton("1");
		JButton jButton_2 = new JButton("2");
		JButton jButton_3 = new JButton("3");
		JButton jButton_4 = new JButton("4");
		JButton jButton_5 = new JButton("5");
		JButton jButton_6 = new JButton("6");
		JButton jButton_7 = new JButton("7");
		JButton jButton_8 = new JButton("8");
		JButton jButton_9 = new JButton("9");
		JButton jButton_cong = new JButton("+");
		JButton jButton_tru = new JButton("-");
		JButton jButton_nhan = new JButton("*");
		JButton jButton_chia = new JButton("/");
		JButton jButton_bang = new JButton("=");
		JPanel jPanel_buttons = new JPanel();
		jPanel_buttons.setLayout(new GridLayout(5, 3));
		jPanel_buttons.add(jButton_0);
		jPanel_buttons.add(jButton_1);
		jPanel_buttons.add(jButton_2);
		jPanel_buttons.add(jButton_3);
		jPanel_buttons.add(jButton_4);
		jPanel_buttons.add(jButton_5);
		jPanel_buttons.add(jButton_6);
		jPanel_buttons.add(jButton_7);
		jPanel_buttons.add(jButton_8);
		jPanel_buttons.add(jButton_9);
		jPanel_buttons.add(jButton_cong);
		jPanel_buttons.add(jButton_tru);
		jPanel_buttons.add(jButton_nhan);
		jPanel_buttons.add(jButton_chia);
		jPanel_buttons.add(jButton_bang);

		this.setLayout(new BorderLayout());
		this.add(jPanel_head, BorderLayout.NORTH);
		this.add(jPanel_buttons, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
//			com.sun.java.swing.plaf.gtk.GTKLookAndFeel
//			com.sun.java.swing.plaf.motif.MotifLookAndFeel
//			com.sun.java.swing.plaf.windows.WindowsLookAndFeel

			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Login();
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
// 		JFrame jf = new JFrame();
// 		// Gắn tên
// 		jf.setTitle("Vi Du JFrame");
// 		// Gán kích cỡ
// 		jf.setSize(1000, 1000);
		
// //		while(true) {
// //			System.out.println("Chương trình đang chạy!");
// //		}
		
// 		// Gán vị trí hiển thị
// 		jf.setLocation(500, 0);
		
// 		// Thoát ra khỏi chương trình khi đóng cửa sổ JFrame
// 		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
// 		// Cho phép hiển thị
// 		jf.setVisible(true);
// 	}
		// new Login();






}
