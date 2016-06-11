package com.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JScrollPane;

import org.apache.log4j.TTCCLayout;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.object.HoNgheo;

public class phanloaihongheo extends JPanel implements ItemListener {
	private JTable table = new JTable();
	JComboBox<String> comboBox = new JComboBox<String>();
	JComboBox<String> comboBox_1 = new JComboBox<String>(); // chuyển khai báo lên đây để sử dụng trên toàn bộ chương trình (biến global)
	ResultSet rsTieuChi = Database.getAllTieuChi();
	JComboBox<String> comboNamApDung = new JComboBox<String>();
//  ??
	/**
	 * Create the panel.
	 */
	public phanloaihongheo() {
		setBackground(new Color(32, 178, 170));
		setBounds(233, 1, 1131, 713);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Huyện");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(59, 43, 95, 45);
		add(lblNewLabel);
		
		comboBox.setBounds(181, 50, 179, 36);
		add(comboBox);
		comboBox.addItemListener(this);

		ResultSet ttx1= Database.getAllHuyen();
		try {
			while (ttx1.next()) {
				
				comboBox.addItem(ttx1.getString("Huyen"));// đây là cho phép nạp tên xã phải k
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		comboBox_1.setBounds(583, 46, 179, 45);
		comboBox_1.addItemListener(this); // lắng nghe sự kiện chọn item
		add(comboBox_1);
		
		JButton btnNewButton = new JButton("L\u1EA5y th\u00F4ng tin h\u1ED9");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs = Database.getAllTieuchi((String)comboNamApDung.getSelectedItem());
				double BThanhThi11 = 0;
				double BThanhThi12 = 0;
				double BThanhThi13 = 0;
				
				double BThanhThi21 = 0;
				double BThanhThi22 = 0;
				double BThanhThi23 = 0;
				
				double BNongThon11 = 0;
				double BNongThon12 = 0;
				double BNongThon13 = 0;
				
				double BNongThon21 = 0;
				double BNongThon22 = 0;
				double BNongThon23 = 0;
				
				
				try {
					while (rs.next()) {
						if(rs.getString("MaKV").equals("0")){
							BThanhThi11 = rs.getDouble("DiemB1");
							BThanhThi12 = rs.getDouble("DiemB12");
							BThanhThi13 = rs.getDouble("DiemB13");
							
							BThanhThi21 = rs.getDouble("DiemB2");
							BThanhThi22 = rs.getDouble("DiemB22");
							BThanhThi23 = rs.getDouble("DiemB23");
							
							System.out.println("BThanhThi21 = " +BThanhThi21);
						} else if(rs.getString("MaKV").equals("1")){
							BNongThon11 = rs.getDouble("DiemB1");
							BNongThon12 = rs.getDouble("DiemB12");
							BNongThon13 = rs.getDouble("DiemB13");
							
							BNongThon21 = rs.getDouble("DiemB2");
							BNongThon22 = rs.getDouble("DiemB22");
							BNongThon23 = rs.getDouble("DiemB23");
						}
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(new JFrame());
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println("File đã chọn: "
							+ selectedFile.getName());
					try {
						InputStream ExcelFileToRead = new FileInputStream(
								selectedFile);
						System.out.println("tạo input stream");
						XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
						XSSFWorkbook test = new XSSFWorkbook();
						XSSFSheet sheet = wb.getSheetAt(0);
						XSSFRow row;
						XSSFCell cell;
						Iterator rows = sheet.rowIterator();
						int i = 0;
						rows.next();
						while (rows.hasNext()) {
							row = (XSSFRow) rows.next();
							Iterator cells = row.cellIterator();
							// lay ma ho ngheo
							cell = (XSSFCell) cells.next();
							String mahongheo = cell.getStringCellValue();
							System.out.print("ma ho ngheo: " + mahongheo);
							// Xã
							cell = (XSSFCell) cells.next();
							String maxa = cell.getStringCellValue();
							System.out.print("  xa: " + maxa);
							// lay ten chu ho
							cell = (XSSFCell) cells.next();
							String chuho = cell.getStringCellValue();
							System.out.print("  chuho: " + chuho);
							// lay thu nhap
							cell = (XSSFCell) cells.next();
							float thunhap = (float) cell.getNumericCellValue();
							System.out.print("  thunhap: " + thunhap);
							//
							cell = (XSSFCell) cells.next();
							int khuvuc = (int) cell.getNumericCellValue();
							System.out.print("  khuvuc: " + khuvuc);
							//
							cell = (XSSFCell) cells.next();
							int ttnhao = (int) cell.getNumericCellValue();
							System.out.print("  ttnhao: " + ttnhao);
							//
							cell = (XSSFCell) cells.next();
							int nuocSH = (int) cell.getNumericCellValue();
							System.out.print(" nuocSH: " + nuocSH);
							//
							cell = (XSSFCell) cells.next();
							int thongtin = (int) cell.getNumericCellValue();
							System.out.print("  thongtin: " + thongtin);
							//
							cell = (XSSFCell) cells.next();
							int yte = (int) cell.getNumericCellValue();
							System.out.print("  yte: " + yte);

							// nguyện vọng
							cell = (XSSFCell) cells.next();
							String nguyenvong = cell.getStringCellValue() + "";
							System.out.print("nguyenvong: " + nguyenvong);

							//
							cell = (XSSFCell) cells.next();
							int nhankhau = (int) cell.getNumericCellValue();
							System.out.print("  nhankhau: " + nhankhau);

							cell = (XSSFCell) cells.next();
							int hocvan = (int) cell.getNumericCellValue();
							System.out.print("  hocvan: " + hocvan);

							// mã loại hộ
							// cell = (XSSFCell) cells.next();
							// int maloaiho = (int)cell.getNumericCellValue();
							// System.out.print("nguyenvong: " + maloaiho);
							// có cần đây k

							int B1 = 0, B2;

							// tính b1, b2
							// B1

							if (thunhap <= 700 && khuvuc == 1) {
								B1 = 120;
							} else if (thunhap <= 900 && khuvuc == 0) {
								B1 = 140;
							} else if (thunhap <= 1000 && khuvuc == 1) {
								B1 = 150;
							} else if (thunhap <= 1300 && khuvuc == 0) {
								B1 = 170;
							}

							int nhankhau1 = 0;
							if (nhankhau == 1) {
								nhankhau1 = 75;
							} else if (nhankhau == 2) {
								nhankhau1 = 60;
							} else if (nhankhau == 3) {
								nhankhau1 = 40;
							} else if (nhankhau == 4) {
								nhankhau1 = 30;
							} else if (nhankhau == 5) {
								nhankhau1 = 20;
							} else if (nhankhau == 3) {
								nhankhau1 = 15;
							}
							int ttnhao1;
							if (ttnhao == 1) {
								ttnhao1 = 10;
							} else
								ttnhao1 = 15;

							int nuocSH1 = 0;
							if (nuocSH == 0) {
								nuocSH1 = 15;
							} else if (nuocSH == 1 || nuocSH == 2)
								nhankhau1 = 10;

							int thongtin1 = 0;
							if (thongtin == 0) {
								thongtin1 = 10;
							} else if (thongtin == 1) {
								thongtin1 = 15;
							}

							int yte1 = 0;
							if (yte == 0) {
								yte1 = 0;
							} else if (yte == 1 || yte == 2)
								yte1 = 10;

							int hocvan1 = 0;
							if (hocvan == 0) {
								nuocSH1 = 15;

							} else if (hocvan == 10 || hocvan == 10)
								nhankhau1 = 10;
							B2 = nhankhau1 + hocvan1 + yte1 + thongtin1
									+ nuocSH1;
							// đây
							int maLoaiHo = 2;
							
							
							if ((B1 < BThanhThi12 && khuvuc == 0) || (B1 < BNongThon11 && khuvuc == 1)) {
								maLoaiHo = 1;
							} else if ((BNongThon11 <= B1 && B1 <= BNongThon12 && B2 > BNongThon21 && khuvuc == 1) || (BThanhThi12 <= B1 && B1 <= BThanhThi13 && B2 > BThanhThi21 && khuvuc == 0)) {
								maLoaiHo = 1; //
							} else if ((BNongThon11 < B1 && B1 < BNongThon12 && B2 < BNongThon21 && khuvuc == 1) || (BThanhThi12 < B1 && B1 <= BThanhThi13 && B2 < BThanhThi21 && khuvuc == 0)) {
								maLoaiHo = 0; //
							} else if ((B1 > BThanhThi11 && khuvuc == 0) || (B1 > BNongThon13 && khuvuc == 1)) {
								maLoaiHo = 2;
							}
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy");
							 
								//
								HoNgheo hongheo = new HoNgheo(mahongheo, chuho,
										thongtin1, ttnhao1, thunhap, khuvuc,
										nuocSH1, maLoaiHo, nhankhau1, sdf
												.format(new Date()) + "",
										hocvan, maxa, yte1, B1, B2);
								Database.nhapHoNgheo(hongheo);
							 
						}
						JOptionPane.showMessageDialog(null,
								"Nhập data từ cel vào db thành công");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(257, 204, 179, 45);
		add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("L\u01B0u th\u00F4ng tin");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(509, 204, 179, 45);
		add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 275, 1121, 427);
		add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, "", "", null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "X\u00E3", "M\u00E3 h\u1ED9", "Ch\u1EE7 h\u1ED9", "Khu v\u1EF1c", "B1", "B2", "Thu nh\u1EADp", "Lo\u1EA1i h\u1ED9"
			}
		));
		

		
		
		
		JLabel lblX = new JLabel("Xã");
		lblX.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblX.setBounds(503, 59, 46, 14);
		add(lblX);
		
		
		comboNamApDung.setBounds(181, 103, 179, 36);
		add(comboNamApDung);
		
		try {
			while (rsTieuChi.next()) {
				String nam = (String)rsTieuChi.getString(1);
				comboNamApDung.addItem(nam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		
		JLabel lblNamApDung = new JLabel("namAD");
		lblNamApDung.setForeground(Color.RED);
		lblNamApDung.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNamApDung.setBounds(59, 94, 95, 45);
		add(lblNamApDung);
	}
		
		
	@Override
	public void itemStateChanged(ItemEvent event) { 
		// khi chọn combobox
		JComboBox cb = (JComboBox) event.getSource();
		// Lấy giá trị xã trong combobox
		
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		System.out.println("chao");
		if(cb==comboBox){
			System.out.println("hhh");
			comboBox_1.removeAllItems();
			
			String tenHuyen = (String) comboBox.getSelectedItem();
			
			ResultSet set = Database.getAllxa(tenHuyen);
			try {
				while (set.next()) {
					 	 
						comboBox_1.addItem(set.getString("Maxa"));

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  
		} else if(cb==comboBox_1){ 
			if(comboBox_1.getItemCount() >= 1){
			String maXA = "";
									maXA = (String)comboBox_1.getSelectedItem(); 
									System.out.println("maxa: " + maXA);
									
									// Bước 2: Gọi phương thức để lấy toàn bộ hộ nghèo
									ResultSet rs = Database.getAllHoNgheo( ); // truyền mã xã để lấy xã
																					// phù hợp
									int i = 0;
			
									// Bước 3: duyệt toàn bộ kết quả và cho vào table
									try {
										while (rs.next()) { // duyệt kết quả (1 hàng) 
											if (maXA.equals(rs.getString("Maxa"))) {
											System.out.println("true");
											dm.addRow(new Object[]{" ", " ", " "," ", " ", " "," ", " "," "," "});
											// bây giờ duyệt từng cột của 1 hàng
											table.getModel().setValueAt(i+1, i, 0);
											
												// xa
												String str  = rs.getString("Maxa") ;
												table.getModel().setValueAt(str, i, 1); 
												
												// ma ho
												String mahn  = rs.getString("MaHN") ;
												table.getModel().setValueAt(mahn, i, 2);
												
												// 
												String chuho  = rs.getString("Chuho") ;
												table.getModel().setValueAt(chuho, i, 3);
												
												//  
												String khuvuc  = rs.getString("MaKV") ;
												if(khuvuc.equals("1")) khuvuc = "nông thôn" ;
												else khuvuc ="thành thị";
												table.getModel().setValueAt(khuvuc, i, 4);
												
											//  
												String b1  = rs.getString("B1") ;
												table.getModel().setValueAt(b1, i, 5);
												
												
											//  
												String b2  = rs.getString("B2") ;
												table.getModel().setValueAt(b2, i, 6);
												
											//  
												String thunhap  = rs.getString("Thunhap") ;
												table.getModel().setValueAt(thunhap, i, 7);
												
											//  
												String loaiho  = rs.getString("Maloaiho") ;
												if(loaiho.equals("1")) loaiho = "hộ cận nghèo" ;
												else if (loaiho.equals("2")) loaiho = "hộ nghèo" ;
												else loaiho =" ";
												table.getModel().setValueAt(loaiho, i, 8);
											i++;
										}
										}
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
		}
			
		}
		
	}
}

















