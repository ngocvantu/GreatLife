package com.panel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.object.DiaPhuong;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JTextField;

public class Diaphuong<ttcoban> extends JPanel implements ItemListener {
//	private JTable table = new JTable();
	private JTextField textstt;
	private JTextField texthuyen;
	private JTextField textxa;
	private JTextField textTenChuHo;
	private JTextField textMaHo;
	private JTextField textTTCapThe;
	private JTextField textNgayNhap;
	private JTable table;
	JButton btnthem = new JButton("Th\u00EAm");
	

	/**
	 * Create the panel.
	 */
	public Diaphuong() {
//		table.getColumnModel().getColumn(1).setPreferredWidth(64);
//	table.getColumnModel().getColumn(2).setPreferredWidth(68);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 433, 1140, 324);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Huy\u1EC7n", "X\u00E3", "Ch\u1EE7 h\u1ED9", "M\u00E3 h\u1ED9", "TT c\u1EA5p th\u1EBB", "Ng\u00E0y nh\u1EADp"
			}
		));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		JFrame frame = new JFrame();
		 
		Object[] columns= {"STT","Huyện","Xã","Chủ hộ ","Mã hộ","TTCapthe","Ngaynhap"};
		DefaultTableModel model= new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		table.setRowHeight(30);
		// dang lam
		
		setBounds(new Rectangle(233, 1, 1131, 713));
		setBackground(new Color(189, 183, 107));
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(434, 39, 148, 31);
		comboBox.addItemListener(this);
		add(comboBox);
		ResultSet ttx= Database.getAllHuyen();
		try {
			while (ttx.next()) {
				comboBox.addItem(ttx.getString("Huyen"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hoa L\u1ED9c", "Ph\u00FA L\u1ED9c", "Quang L\u1ED9c", "Minh L\u1ED9c"}));
		comboBox_1.setBackground(new Color(245, 255, 250));
		comboBox_1.setBounds(434, 124, 148, 31);
		add(comboBox_1);
		comboBox_1.addItemListener(this);
		
		
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				com.object.ttcoban ttcoban = new com.object.ttcoban(Integer.valueOf(textstt.getText()), texthuyen.getText(), textxa.getText(),
						textTenChuHo.getText(), textMaHo.getText(), Integer.valueOf(textTTCapThe.getText()), formatter.format(new Date()));
				Database.addttcoban(ttcoban);
				loadData();
				resetform();
			}
		});
		btnthem.setIcon(null);
		//Object []row = new Object [7];
		//btnthem.addActionListener(new ActionListener() {

		btnthem.setFont(new Font("Arial", Font.PLAIN, 15));
		btnthem.setForeground(new Color(255, 0, 0));
		btnthem.setBounds(387, 359, 89, 28);
		add(btnthem);
		
		JButton btnsua = new JButton("S\u1EEDa");
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
			    int colIndex = table.getSelectedColumn();  
			    
			    textstt.setText((String)table.getValueAt(rowIndex, 0));
			    texthuyen.setText((String)table.getValueAt(rowIndex, 1));
			    textxa.setText((String)table.getValueAt(rowIndex, 2));
			    textTenChuHo.setText((String)table.getValueAt(rowIndex, 3));
			    textMaHo.setText((String)table.getValueAt(rowIndex, 4));
			    textTTCapThe.setText((String)table.getValueAt(rowIndex, 5));
			    textNgayNhap.setText((String)table.getValueAt(rowIndex, 6));
			    
			    btnthem.setEnabled(false);
//			    Database.delttcoban(str);
			    System.out.println("rowIndex = " + rowIndex + "colIndex = " + colIndex);
			}
		});
		btnsua.setFont(new Font("Arial", Font.PLAIN, 15));
		btnsua.setForeground(new Color(255, 0, 0));
		btnsua.setBounds(588, 356, 89, 35);
		add(btnsua);
		
		JButton btnNewButton_2 = new JButton("L\u01B0u");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Format formatter = new SimpleDateFormat("yyyy");
				com.object.ttcoban ttcoban = new com.object.ttcoban(Integer.valueOf(textstt.getText()), texthuyen.getText(), textxa.getText(),
						textTenChuHo.getText(), textMaHo.getText(), Integer.valueOf(textTTCapThe.getText()), formatter.format(new Date()));
				
				Database.updatettcoban(ttcoban);
				loadData();
				resetform();
			}

			
		});
		
		
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(660, 136, 89, 35);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("B\u00E1o c\u00E1o");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_3.setBounds(808, 136, 89, 35);
		add(btnNewButton_3);
		
		
		
	

		JButton btnLyThngTin = new JButton("Lấy thông tin các hộ dân");
		btnLyThngTin.addActionListener(new ActionListener() {
			// e viết thêm, load file excel mới
		 
			
			public void actionPerformed(ActionEvent arg0) {
					JFileChooser fileChooser = new JFileChooser();
					int result = fileChooser.showOpenDialog(new JFrame());
					if (result == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						System.out.println("File đã chọn: " + selectedFile.getName());
						
						
						try {
							InputStream ExcelFileToRead = new FileInputStream(selectedFile);
							System.out.println("tạo input stream");
							
							XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
							
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
								//stt
								cell = (XSSFCell) cells.next(); 
								int stt = (int)cell.getNumericCellValue();
								System.out.print("  STT: " + stt);

								
								// huyen
								cell = (XSSFCell) cells.next(); 
								String huyen = cell.getStringCellValue();
								System.out.print(" huyen: " + huyen);
								
								//lay ten xa
								cell = (XSSFCell) cells.next(); 
								String xa = cell.getStringCellValue();
								System.out.print("  xa: " + xa);
								
								//lay ten chu ho
								
								cell = (XSSFCell) cells.next(); 
								String chuho = cell.getStringCellValue();
								System.out.print("  chuho: " + chuho);
								// lay ma ho ngheo
								cell = (XSSFCell) cells.next(); 
								String mahongheo = cell.getStringCellValue();
								System.out.print("ma ho ngheo: " + mahongheo);
								
								// tt cấp thẻ
								
								cell = (XSSFCell) cells.next(); 
								int  ttcapthe = (int)cell.getNumericCellValue();
								System.out.print("  ttcapthe: " + ttcapthe);
								
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
								com.object.ttcoban thongtincoban= new com.object.ttcoban( stt, huyen,  xa,  chuho, mahongheo,  ttcapthe,  sdf.format(new Date()));
								
								Database.addttcoban(thongtincoban);
								loadData();
							}
							
					
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  } } ;
						

						
						
		
              });
		
	
	
		btnLyThngTin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnLyThngTin.setForeground(new Color(0, 0, 0));
		btnLyThngTin.setBounds(660, 35, 208, 35);
		add(btnLyThngTin);
		// load thong tin co ban
		
		
		ResultSet rs = Database.getAllttcoban() ;
		int i = 0; 
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		for (int j = model1.getRowCount()-1; j >= 0; j--) {
			model1.removeRow(j);
		}
		try {
			while (rs.next()) {  
				
				model1.addRow(new Object[]{" ", " ", " "," ", " ", " "," ", " "," "," "});
				for (int j = 1; j < 8; j++) {
					
					table.getModel().setValueAt(rs.getString(j), i, j-1 ); 
				}
				
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet ttx1= Database.getAllHuyen();
		try {
			while (ttx1.next()) {
				comboBox_1.addItem(ttx1.getString("Huyen"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
					
				    } else if (response == JOptionPane.YES_OPTION) {
				    	int rowIndex = table.getSelectedRow();
					    int colIndex = table.getSelectedColumn();
					    
					    String str  = (String)table.getValueAt(rowIndex, 4);
					    Database.delttcoban(str);
					    loadData();
					    System.out.println("rowIndex = " + rowIndex + "colIndex = " + colIndex);
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				      System.out.println("JOptionPane closed");
				    }
				
			}
		});
		btnxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnxoa.setForeground(Color.RED);
		btnxoa.setBounds(756, 358, 89, 28);
		add(btnxoa);
		
		
		
		JLabel lblNewLabel = new JLabel("STT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 31, 60, 17);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Huyện");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(40, 75, 60, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Xã");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(40, 124, 60, 33);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên chủ hộ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setToolTipText("Tên chủ hộ");
		lblNewLabel_3.setBounds(40, 174, 95, 31);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hộ ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setToolTipText("Mã hộ");
		lblNewLabel_4.setBounds(40, 235, 75, 31);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TTcấp thẻ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setToolTipText("TT Cấp thẻ");
		lblNewLabel_5.setBounds(39, 302, 76, 30);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày nhập");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setToolTipText("Ngày nhập");
		lblNewLabel_6.setBounds(40, 364, 95, 20);
		add(lblNewLabel_6);
		
		textstt = new JTextField();
		textstt.setBounds(145, 28, 129, 31);
		add(textstt);
		textstt.setColumns(10);
		
		texthuyen = new JTextField();
		texthuyen.setBounds(145, 72, 129, 31);
		add(texthuyen);
		texthuyen.setColumns(10);
		
		textxa = new JTextField();
		textxa.setBounds(145, 121, 129, 36);
		add(textxa);
		textxa.setColumns(10);
		
		textTenChuHo = new JTextField();
		textTenChuHo.setBounds(145, 174, 129, 31);
		add(textTenChuHo);
		textTenChuHo.setColumns(10);
		
		textMaHo = new JTextField();
		textMaHo.setBounds(145, 235, 129, 31);
		add(textMaHo);
		textMaHo.setColumns(10);
		
		textTTCapThe = new JTextField();
		textTTCapThe.setBounds(145, 302, 129, 31);
		add(textTTCapThe);
		textTTCapThe.setColumns(10);
		
		textNgayNhap = new JTextField();
		textNgayNhap.setEditable(false);
		textNgayNhap.setBounds(145, 364, 129, 28);
		add(textNgayNhap);
		textNgayNhap.setColumns(10);
		
		JLabel lblHuyn = new JLabel("Huyện");
		lblHuyn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHuyn.setBounds(343, 39, 67, 22);
		add(lblHuyn);
		
		JLabel lblX = new JLabel("Xã");
		lblX.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblX.setBounds(343, 123, 67, 35);
		add(lblX);
		
		
		loadData();
	}
	
	public void loadData() {
		ResultSet rs = Database.getAllTTCoBan();
		int i = 0;
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int m = rowCount - 1; m >= 0; m--) {
		    dm.removeRow(m);
		}
		try {
			while (rs.next()) {
				dm.addRow(new Object[]{" ", " ", " "," ", " ", " "," "});
				for (int j = 0; j < 7; j++) {
					table.getModel().setValueAt(rs.getString(j+1), i, j); 
				}
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resetform() { 
		btnthem.setEnabled(true);
		texthuyen.setText("");
		textMaHo.setText("");
		textNgayNhap.setText("");
		textstt.setText("");
		
		textTenChuHo.setText("");
		textTTCapThe.setText("");
		textxa.setText("");
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}

		
					
				
