package com.panel;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.ImageIcon;

import com.hello.HelloSwing;


public class dangnhap extends JFrame {
	Database db = new Database();

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap frame = new dangnhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dangnhap() {
		 
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NGOC HOANG\\Desktop\\dangnhap.PNG"));
		setTitle("\u0110\u0103ng nh\u1EADp");
		setForeground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 0, 0);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);
		
		JButton btnngNhp = new JButton("\u0110\u0103ng nh\u1EADp");
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Khi người dùng nhập và nhấn nút "Đăng nhập"
				// LẤy dang nhap và mat khau ma nguoi dung da nhap
				String username = textField.getText();
				String pass = passwordField.getText();
				// in ra thử
				System.out.println("uname = " + username + ";  pass = " + pass);  // ok
				// check xem ten dang nhap va mat khau co ton tai trong csdl hay la khong
				// bay gio can phai viet 1 phuong thuc check tai khoan dang nhap trong lop database, dau vao laf ten dang nhap va passs
				if(Database.dangnhapok(username, pass)){
					HelloSwing window = new HelloSwing();
					window.frame.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "xxxx sai dang nhap");
				}
			}
		});
		btnngNhp.setBackground(new Color(255, 0, 0));
		btnngNhp.setBounds(166, 169, 130, 23);
		contentPane.add(btnngNhp);
		
		JLabel label = new JLabel("");
		label.setBounds(226, 95, 46, 14);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(125, 70, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(125, 109, 115, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(262, 64, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u0110\u0103ng xu\u1EA5t");
		button.setBackground(new Color(255, 0, 0));
		button.setForeground(new Color(0, 0, 0));
		button.setBounds(312, 169, 112, 23);
		contentPane.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(262, 95, 162, 23);
		contentPane.add(passwordField);
		
		JLabel lblngNhp = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblngNhp.setForeground(Color.RED);
		lblngNhp.setFont(new Font("Arial", Font.PLAIN, 30));
		lblngNhp.setBounds(151, 11, 201, 51);
		contentPane.add(lblngNhp);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NGOC HOANG\\Desktop\\key.jpg"));
		lblNewLabel_3.setBounds(10, 11, 105, 134);
		contentPane.add(lblNewLabel_3);
	}
}
