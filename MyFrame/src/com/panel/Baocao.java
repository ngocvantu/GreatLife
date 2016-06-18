package com.panel;

import javax.swing.JFileChooser;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.xml.crypto.Data;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hello.combobox;

public class Baocao extends JPanel implements ItemListener {
	JComboBox<String> comboBox = new JComboBox<String>();
	ResultSet rsTieuChi = Database.getAllTieuChi();
	JComboBox<String> comboBox_1 = new JComboBox<String>();

	/**
	 * Create the panel.
	 */
	public Baocao() {
		setBounds(233, 1, 1131, 713);
		setBackground(new Color(189, 183, 107));
		setLayout(null);
		
		JButton btnNewButton = new JButton("Xu\u1EA5t file excel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setName("chao.txt");
				fileChooser.setDialogTitle("Specify a file to save"); 
				fileChooser.setSelectedFile(new File("BaoCaoHoNgheo.xlsx"));
				 
				int userSelection = fileChooser.showSaveDialog(null);
				String excelFileName = null ;
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
				    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				    excelFileName  = fileToSave.getAbsolutePath();
				} 
				String sheetName = "Sheet1";//name of sheet
				
				// get data  
				ResultSet rs = Database.getHoNgheoByNam((String) comboBox_1.getSelectedItem());
				
				
				// write file
				XSSFWorkbook wb = new XSSFWorkbook();
				XSSFSheet sheet = wb.createSheet(sheetName) ; 
				XSSFCellStyle style = wb.createCellStyle();

				//iterating r number of rows
				int i = 1;
				try {
					while (rs.next())
					{
						XSSFRow row = sheet.createRow(i++);

						//iterating c number of columns
						for (int c=1;c <= rs.getMetaData().getColumnCount(); c++ )
						{
							XSSFCell cell = row.createCell(c);

							cell.setCellValue(rs.getString(c));
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		/**
		 * 
		 */
				FileOutputStream fileOut;
				try {
					fileOut = new FileOutputStream(excelFileName);
					//write this workbook to an Outputstream.
					wb.write(fileOut);
					fileOut.flush();
					fileOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(586, 297, 151, 30);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Huyện");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(85, 290, 60, 40);
		add(lblNewLabel);
		
		
		comboBox.setBounds(222, 298, 151, 30);
		add(comboBox);
		comboBox.addItemListener(this);
		
		
		comboBox_1.setBounds(222, 249, 151, 30);
		add(comboBox_1);
		comboBox_1.addItemListener(this);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setForeground(Color.BLACK);
		lblNm.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNm.setBounds(85, 249, 60, 40);
		add(lblNm);
		
		try {
			while (rsTieuChi.next()) {
				String nam = (String)rsTieuChi.getString(1);
				comboBox_1.addItem(nam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loadHuyen();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox<String> com = (JComboBox<String>) e.getSource();
		if(com==comboBox){
			System.out.println("comboselected");
			
			repaint();
		} else if(com == comboBox_1){
			repaint();
		}
	} 
	
	private void loadHuyen() { 
		ResultSet rs = Database.getAllHuyen();
		try {
			while (rs.next()) { 
				comboBox.addItem(rs.getString(1));
				repaint();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		 
		drawTinh(g);
		
		drawHuyen(g);
		
	}

	private void drawHuyen(Graphics g) { 
	
		int soHoNgheo = 0;
		int soHoKhongNgheo = 0;
		int soHoCanNgheo = 0;
		String nam = (String) comboBox_1.getSelectedItem();
		int tongSoHo = Database.getSoHoByHuyen((String)comboBox.getSelectedItem(), nam);
		
		ResultSet rs = Database.getAllxa((String)comboBox.getSelectedItem());
		try {
			while (rs.next()) {
				String xa = rs.getString(1);
				System.out.println("maxa" + xa);
				soHoNgheo = soHoNgheo + Database.getSoHo(1, nam,xa);
				soHoCanNgheo = soHoCanNgheo + Database.getSoHo(2, nam,xa);
				soHoKhongNgheo = tongSoHo - soHoCanNgheo - soHoNgheo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Graphics2D g1 = (Graphics2D) g;
		
		g1.setFont(new Font("TimesRoman", Font.BOLD, 14)); 
		int XTinh  = 650;
		int YTinh = 400; 
		
		System.out.println("tongsoho_byhuyen = " + tongSoHo);
		float phanTramNgheo = 0;
		float phanTramCanNgheo = 0;
		float phanTramKhongNgheo = 0;
		int toaDoNgheo = 0;
		int toaDoCanNgheo = 0;
		int toaDoKhongNgheo = 0 ;
		if(tongSoHo > 0) {
		  phanTramNgheo = (float)soHoNgheo/(float)tongSoHo;
		  phanTramCanNgheo = (float)soHoCanNgheo/(float)tongSoHo;
		  phanTramKhongNgheo = 1 - phanTramCanNgheo - phanTramNgheo;
		
		
		  toaDoNgheo = soHoNgheo*360/tongSoHo ;
		  toaDoCanNgheo = soHoCanNgheo*360/tongSoHo ;
		  toaDoKhongNgheo = 360 - toaDoNgheo - toaDoCanNgheo ;
		}  else {
			g1.setColor(Color.black);
			g1.setFont(new Font("TimesRoman", Font.BOLD, 18));  
			g1.drawString("Chưa có hộ nào!", XTinh + 10, YTinh + 140);
		
		}
		System.out.println("toadongheo = " + toaDoNgheo + " toadocanngheo = " + toaDoCanNgheo);
		
		System.out.println("So ho ngheo = " + soHoNgheo + " so ho can nghefo = " + soHoCanNgheo + "khong ngheo = " + soHoKhongNgheo);
		System.out.println("toa do khong ngheo = " + toaDoKhongNgheo);
		
		g1.setFont(new Font("TimesRoman", Font.BOLD, 14)); 
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
		g1.fillArc(XTinh, YTinh, 150, 150, toaDoCanNgheo + toaDoNgheo, toaDoKhongNgheo);		// Khong ngheo  
		g1.fillRect(XTinh + 170, YTinh + 80, 10, 10);
		g1.setColor(Color.black);
		g1.drawString(" Không nghèo: " + new DecimalFormat("##.##").format(phanTramKhongNgheo * 100) + "%" + " ("+ soHoKhongNgheo + " Hộ)", XTinh + 180, YTinh + 90);
		
		g1.setColor(Color.black);
		g1.setFont(new Font("TimesRoman", Font.BOLD, 18));  
		g1.drawString("Thống kê theo huyện: " + comboBox.getSelectedItem(), XTinh - 5, YTinh + 180);
		 
		
	}

	private void drawTinh(Graphics g) { 
		System.out.println("draw tinh");
		Graphics2D g1 = (Graphics2D) g;
		g1.setFont(new Font("TimesRoman", Font.BOLD, 14)); 
		int XTinh  = 150;
		int YTinh = 400;
		String nam = (String) comboBox_1.getSelectedItem();
		int tongSoHo = Database.getSoHoByHuyen(null, nam);
		int soHoNgheo = Database.getSoHo(1, nam);
		int soHoCanNgheo = Database.getSoHo(2, nam);
		int soHoKhongNgheo = tongSoHo - soHoNgheo - soHoCanNgheo;
		float phanTramNgheo = 0;
		float phanTramCanNgheo = 0;
		float phanTramKhongNgheo = 0;
		int toaDoNgheo = 0;
		int toaDoCanNgheo = 0;
		int toaDoKhongNgheo = 0 ;
		if(tongSoHo > 0) {
		  phanTramNgheo = (float)soHoNgheo/(float)tongSoHo;
		  phanTramCanNgheo = (float)soHoCanNgheo/(float)tongSoHo;
		  phanTramKhongNgheo = 1 - phanTramCanNgheo - phanTramNgheo;
		
		
		  toaDoNgheo = soHoNgheo*360/tongSoHo ;
		  toaDoCanNgheo = soHoCanNgheo*360/tongSoHo ;
		  toaDoKhongNgheo = 360 - toaDoNgheo - toaDoCanNgheo ;
			
//			System.out.println("toadongheo = " + toaDoNgheo + " toadocanngheo = " + toaDoCanNgheo);
			
//			System.out.println("So ho ngheo = " + soHoNgheo + " so ho can nghefo = " + soHoCanNgheo);
			
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
			g1.fillArc(XTinh, YTinh, 150, 150, toaDoCanNgheo + toaDoNgheo, toaDoKhongNgheo);		// Khong ngheo  
			g1.fillRect(XTinh + 170, YTinh + 80, 10, 10);
			g1.setColor(Color.black);
			g1.drawString(" Không nghèo: " + new DecimalFormat("##.##").format(phanTramKhongNgheo * 100) + "%" + " ("+ soHoKhongNgheo + " Hộ)", XTinh + 180, YTinh + 90);
			
			g1.setColor(Color.black);
			g1.setFont(new Font("TimesRoman", Font.BOLD, 18)); 
			g1.drawString("Thống kê toàn tỉnh", XTinh - 5, YTinh+180);
		}  else {
			System.out.println("chua co ho ngheo nao");
			System.out.println("chua co ho ngheo nao 2");
			g1.setColor(Color.black);
			g1.setFont(new Font("TimesRoman", Font.BOLD, 18));  
			g1.drawString("Chưa có hộ nào!", XTinh + 10, YTinh + 140);
		}

		
	}
}
