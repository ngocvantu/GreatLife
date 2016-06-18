package com.hello;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;









import com.panel.AddPoor;
import com.panel.Baocao;
import com.panel.Database;
import com.panel.Diaphuong;
import com.panel.Okok;
import com.panel.Tieuchi;
import com.panel.phanloaihongheo;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Rectangle;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class HelloSwing {

	public JFrame frame;
	AddPoor addPoor;
	private JTextField textFieldTen;
	  JPanel panel_1 = new JPanel();
	  JPanel panel = new JPanel();
	  JButton btnThmHNgho = new JButton("Ph\u00E2n lo\u1EA1i h\u1ED9 ngh\u00E8o");
	  Database database = new Database();
	  JPanel panel_3 = null;
	  String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloSwing window = new HelloSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HelloSwing() {
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public HelloSwing(String username) {
		this.username = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addPoor = new AddPoor();
		
		
		frame = new JFrame();
		frame.setBackground(new Color(135, 206, 250));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NGOC HOANG\\Desktop\\dangnhap.PNG"));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(233, 150, 122));
//		frame.setUndecorated(true);
		
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(1, 1, 231, 713);
		frame.getContentPane().add(panel);
		
		
		
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(232, 1, 1132, 713);
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1);
		btnThmHNgho.setFont(new Font("Arial", Font.PLAIN, 15));
		
		  
		btnThmHNgho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThmHNgho.setBackground(new Color(225, 225, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnThmHNgho.setBackground(new Color(211, 211, 211));
			}
		});
		btnThmHNgho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThmHNgho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phanloaihongheo  plhn = new phanloaihongheo();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.getContentPane().add(plhn);
				plhn.setVisible(true);
				frame.getContentPane().repaint();
			}
		});
		btnThmHNgho.setToolTipText("kkkk");
		btnThmHNgho.setForeground(new Color(0, 0, 255));
		btnThmHNgho.setFocusPainted(false);
		btnThmHNgho.setBorderPainted(false);
		btnThmHNgho.setBackground(new Color(211, 211, 211));
		
		JButton btnThot = new JButton("Tho\u00E1t \u0111\u0103ng nh\u1EADp");
		btnThot.setForeground(Color.RED);
		btnThot.setFont(new Font("Arial", Font.PLAIN, 15));
		btnThot.setFocusPainted(false);
		btnThot.setBorderPainted(false);
		btnThot.setBackground(new Color(216, 191, 216));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		final JButton btndiaphuong = new JButton("\u0110\u1ECBa ph\u01B0\u01A1ng");
		btndiaphuong.setFont(new Font("Arial", Font.PLAIN, 15));
		btndiaphuong.setForeground(new Color(0, 0, 255));
		btndiaphuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Diaphuong diaphuong = new Diaphuong();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.getContentPane().add(diaphuong);
				diaphuong.setVisible(true);
				frame.getContentPane().repaint();
				
			}
			
		});
		JButton btnTiKhon = new JButton("Th\u00F4ng tin \u0111\u0103ng nh\u1EADp");
		btnTiKhon.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(	panel);
				frame.getContentPane().add(panel_3);
				panel_3.setLocation(233, 1);
				panel_3.setVisible(true);
				frame.getContentPane().repaint();
			}
		});
		btnTiKhon.setForeground(Color.BLUE);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton.setFont(new Font("Arusernameial", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Okok okok = new Okok();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.getContentPane().add(okok);
				okok.setVisible(true);
				frame.getContentPane().repaint();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		
		JButton btnNewButton_1 = new JButton("Ti\u00EAu ch\u00ED");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tieuchi tieuchi = new Tieuchi();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				tieuchi.setLocation(233, 1);
				frame.getContentPane().add(tieuchi);
				tieuchi.setVisible(true);
				frame.getContentPane().repaint();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		
		JButton btnNewButton_2 = new JButton("B\u00E1o c\u00E1o");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baocao baocao = new Baocao();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				baocao.setLocation(233, 1);
				frame.getContentPane().add(baocao);
				baocao.setVisible(true);
				frame.getContentPane().repaint();
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTiKhon, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btndiaphuong, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(btnThmHNgho, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(67, Short.MAX_VALUE)
					.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(btnTiKhon, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btndiaphuong, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(btnThmHNgho, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
					.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
		);
		panel.setLayout(gl_panel);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(new Color(46, 139, 87));
		tabbedPane_1.setBounds(0, 0, 1130, 710);
		panel_1.add(tabbedPane_1);
		
		  panel_3 = new JPanel(){
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.fillArc(1000, 200, 50, 50, 0, 150);
				g.setColor(Color.red);
				g.fillArc(1000, 200, 50, 50, 150, 210);
				
			}
			
		};
		  panel_3.setForeground(new Color(0, 0, 0));
		  panel_3.setBackground(new Color(189, 183, 107));
		  panel_3.setLocation(233, 1);
		  tabbedPane_1.addTab("New tab", null, panel_3, null);
		  panel_3.setLayout(null);
		  
		  textFieldTen = new JTextField();
		  textFieldTen.setSize(173, 29);
		  textFieldTen.setLocation(538, 31);
		  panel_3.add(textFieldTen);
		  textFieldTen.setColumns(10);
		  
		  JButton btnBtn = new JButton("btn3");
		  panel_3.add(btnBtn);
		  
		  JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		  lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		  lblNewLabel.setForeground(new Color(0, 0, 0));
		  lblNewLabel.setBounds(333, 46, 173, 14);
		  panel_3.add(lblNewLabel);
		  
		  JLabel lblChcV = new JLabel("Mật khẩu");
		  lblChcV.setFont(new Font("Arial", Font.BOLD, 15));
		  lblChcV.setForeground(new Color(0, 0, 0));
		  lblChcV.setBounds(370, 101, 136, 14);
		  panel_3.add(lblChcV);
		  
		  ResultSet rs = Database.gettaikhoan(username);
		  try {
			while (rs.next()) { 
				textFieldTen.setText(rs.getString(1));
				textFieldPass.setText(rs.getString(2));
			  }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  JButton btnSa = new JButton("Xóa");
		  btnSa.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		Database.deleteTaiKhoan(textFieldTen.getText(), textFieldPass.getText());
		  	}
		  });
		  btnSa.setFont(new Font("Arial", Font.PLAIN, 15));
		  btnSa.setForeground(new Color(255, 0, 0));
		  btnSa.setBounds(473, 429, 103, 32);
		  panel_3.add(btnSa);
		  
		  JLabel lblNewLabel_1 = new JLabel("New label");
		  lblNewLabel_1.setBackground(new Color(0, 128, 128));
		  lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\NGOC HOANG\\Desktop\\nguoi-dung.png"));
		  lblNewLabel_1.setBounds(41, 46, 257, 253);
		  panel_3.add(lblNewLabel_1);
		  
		  textFieldPass = new JTextField();
		  textFieldPass.setBounds(538, 90, 173, 29);
		  panel_3.add(textFieldPass);
		  textFieldPass.setColumns(10);
		  
		  JButton btnThmTiKhon = new JButton("Thêm tài khoản");
		  btnThmTiKhon.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		if(textFieldTen.getText().length() > 0 && textFieldPass.getText().length() > 0){
		  			Database.themTaiKhoan(textFieldTen.getText(), textFieldPass.getText());
		  		}
		  	}
		  });
		  btnThmTiKhon.setForeground(new Color(255, 0, 0));
		  btnThmTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		  btnThmTiKhon.setBounds(211, 429, 161, 29);
		  panel_3.add(btnThmTiKhon);
		  
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(0, 506, 587, 177);
		  panel_3.add(scrollPane);
		frame.setBounds(0, 0, 1366, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textFieldPass;
}
