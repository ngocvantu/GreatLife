package com.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Baocao extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Baocao() {
		setBounds(233, 1, 1131, 713);
		setBackground(new Color(32, 178, 170));
		setLayout(null);
		
		JButton btnNewButton = new JButton("Xu\u1EA5t file excel");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(172, 502, 132, 40);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("X\u00E3");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(739, 502, 60, 40);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(817, 502, 151, 30);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 554, 1131, 159);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 HN", "T\u00EAn ch\u1EE7 h\u1ED9", "Nguy\u1EC7n v\u1ECDng", "M\u00E3 HCN", "T\u00EAn ch\u1EE7 h\u1ED9", "Nguy\u1EC7n v\u1ECDng"
			}
		));
		scrollPane.setViewportView(table);

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawTinh(g);
		
		drawHuyen(g);
		
	}

	private void drawHuyen(Graphics g) { 
		
		Graphics2D g1 = (Graphics2D) g;
		g1.setFont(new Font("TimesRoman", Font.BOLD, 14)); 
		int XTinh  = 650;
		int YTinh = 300;
		int soHoNgheo = Database.getSoHo(1, "2016");
		int soHoKhongNgheo = Database.getSoHo(0, "2016");
		int soHoCanNgheo = Database.getSoHo(2, "2016");
		
		int tongSoHo = soHoCanNgheo + soHoKhongNgheo + soHoNgheo;
		
		float phanTramNgheo = (float)soHoNgheo/(float)tongSoHo;
		float phanTramCanNgheo = (float)soHoCanNgheo/(float)tongSoHo;
		float phanTramKhongNgheo = 1 - phanTramCanNgheo - phanTramNgheo;
		
		int toaDoNgheo = soHoNgheo*360/tongSoHo ;
		int toaDoCanNgheo = soHoCanNgheo*360/tongSoHo ;
		int toaDoKhongNgheo = soHoKhongNgheo*360/tongSoHo ;
		
		System.out.println("toadongheo = " + toaDoNgheo + " toadocanngheo = " + toaDoCanNgheo);
		
		System.out.println("So ho ngheo = " + soHoNgheo + " so ho can nghefo = " + soHoCanNgheo);
		
		g1.setColor(Color.black);
		g1.fillArc(XTinh, YTinh, 150, 150, 0, toaDoNgheo);		// Ngheo
		g1.fillRect(XTinh + 170, YTinh + 20, 10, 10);
		g1.drawString(" Nghèo: " + new DecimalFormat("##.##").format(phanTramNgheo * 100) + "%" + " ("+ soHoNgheo + " Hộ)", XTinh + 180, YTinh + 30);
		g1.setColor(Color.red);
		g1.fillArc(XTinh, YTinh, 150, 150, toaDoNgheo, toaDoCanNgheo);		// Can Ngheo
		g1.fillRect(XTinh + 170, YTinh + 50, 10, 10);
		g1.setColor(Color.black);
		g1.drawString(" Cận nghèo: " + new DecimalFormat("##.##").format(phanTramCanNgheo * 100) + "%" + " ("+ soHoCanNgheo + " Hộ)", XTinh + 180, YTinh + 60);
		g1.setColor(Color.yellow);
		g1.fillArc(XTinh, YTinh, 150, 150, toaDoCanNgheo, toaDoKhongNgheo);		// Khong ngheo  
		g1.fillRect(XTinh + 170, YTinh + 80, 10, 10);
		g1.setColor(Color.black);
		g1.drawString(" Không nghèo: " + new DecimalFormat("##.##").format(phanTramKhongNgheo * 100) + "%" + " ("+ soHoKhongNgheo + " Hộ)", XTinh + 180, YTinh + 90);
		
		g1.setColor(Color.black);
		g1.setFont(new Font("TimesRoman", Font.BOLD, 18)); 
		g1.drawString("Thống kê theo huyện", XTinh - 5, YTinh + 180);
		
	}

	private void drawTinh(Graphics g) { 
		Graphics2D g1 = (Graphics2D) g;
		g1.setFont(new Font("TimesRoman", Font.BOLD, 14)); 
		int XTinh  = 650;
		int YTinh = 20;
		int soHoNgheo = Database.getSoHo(1, "2016");
		int soHoKhongNgheo = Database.getSoHo(0, "2016");
		int soHoCanNgheo = Database.getSoHo(2, "2016");
		
		int tongSoHo = soHoCanNgheo + soHoKhongNgheo + soHoNgheo;
		
		float phanTramNgheo = (float)soHoNgheo/(float)tongSoHo;
		float phanTramCanNgheo = (float)soHoCanNgheo/(float)tongSoHo;
		float phanTramKhongNgheo = 1 - phanTramCanNgheo - phanTramNgheo;
		
		int toaDoNgheo = soHoNgheo*360/tongSoHo ;
		int toaDoCanNgheo = soHoCanNgheo*360/tongSoHo ;
		int toaDoKhongNgheo = soHoKhongNgheo*360/tongSoHo ;
		
		System.out.println("toadongheo = " + toaDoNgheo + " toadocanngheo = " + toaDoCanNgheo);
		
		System.out.println("So ho ngheo = " + soHoNgheo + " so ho can nghefo = " + soHoCanNgheo);
		
		g1.setColor(Color.black);
		g1.fillArc(XTinh, YTinh, 150, 150, 0, toaDoNgheo);		// Ngheo
		g1.fillRect(XTinh + 170, YTinh + 20, 10, 10);
		g1.drawString(" Nghèo: " + new DecimalFormat("##.##").format(phanTramNgheo * 100) + "%" + " ("+ soHoNgheo + " Hộ)", XTinh + 180, YTinh + 30);
		g1.setColor(Color.red);
		g1.fillArc(XTinh, YTinh, 150, 150, toaDoNgheo, toaDoCanNgheo);		// Can Ngheo
		g1.fillRect(XTinh + 170, YTinh + 50, 10, 10);
		g1.setColor(Color.black);
		g1.drawString(" Cận nghèo: " + new DecimalFormat("##.##").format(phanTramCanNgheo * 100) + "%" + " ("+ soHoCanNgheo + " Hộ)", XTinh + 180, YTinh + 60);
		g1.setColor(Color.yellow);
		g1.fillArc(XTinh, YTinh, 150, 150, toaDoCanNgheo, toaDoKhongNgheo);		// Khong ngheo  
		g1.fillRect(XTinh + 170, YTinh + 80, 10, 10);
		g1.setColor(Color.black);
		g1.drawString(" Không nghèo: " + new DecimalFormat("##.##").format(phanTramKhongNgheo * 100) + "%" + " ("+ soHoKhongNgheo + " Hộ)", XTinh + 180, YTinh + 90);
		
		g1.setColor(Color.black);
		g1.setFont(new Font("TimesRoman", Font.BOLD, 18)); 
		g1.drawString("Thống kê toàn tỉnh", XTinh - 5, 200);
	} 

}
