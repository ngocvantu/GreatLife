package com.panel;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.object.TieuChi;

public class Tieuchi extends JPanel {
	private JTable table;
	private JTextField textCQBH;
	private JTextField textB1;
	private JTextField textB2;
	private JTextField textMakv;
	private JTextField textNamAD;
	private JTextField textLoaiHo;
	JButton btnNewButton = new JButton("Th\u00EAm");
	private JTextField textB12;
	private JTextField textB13;
	private JTextField textB22;
	private JTextField textB23;

	/**
	 * Create the panel.
	 */
	public Tieuchi() {
		setBounds(new Rectangle(233, 1, 1131, 713)); ///do chưa setBounds() 
		setBackground(new Color(189, 183, 107));
		setLayout(null);
		
		
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(417, 336, 89, 34);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("S\u1EEDa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = table.getSelectedRow();
			    int colIndex = table.getSelectedColumn();
			    
			    textCQBH.setText((String)table.getValueAt(rowIndex, 1));
			    textB1.setText((String)table.getValueAt(rowIndex, 2));
			    textB12.setText((String)table.getValueAt(rowIndex, 3));
			    textB13.setText((String)table.getValueAt(rowIndex, 4));
			    textB2.setText((String)table.getValueAt(rowIndex, 5));
			    textB22.setText((String)table.getValueAt(rowIndex, 6));
			    textB23.setText((String)table.getValueAt(rowIndex, 7));
			    textMakv.setText((String)table.getValueAt(rowIndex, 8));
			    textLoaiHo.setText((String)table.getValueAt(rowIndex, 9));
			    textNamAD.setText((String)table.getValueAt(rowIndex, 0));
			    
			    btnNewButton.setEnabled(false);
			    
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(579, 336, 89, 34);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("L\u01B0u");
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String NamAD = textNamAD.getText();
				String CQBH = textCQBH.getText();
				double DiemB1 = Double.valueOf(textB1.getText());
				double DiemB12 = Double.valueOf(textB12.getText());
				double DiemB13 = Double.valueOf(textB13.getText());
				
				double DiemB2 = Double.valueOf(textB2.getText());
				double DiemB22 = Double.valueOf(textB22.getText());
				double DiemB23 = Double.valueOf(textB23.getText());
				String MaKV  = textMakv.getText();
				String loaiho = textLoaiHo.getText();
				
				TieuChi tieuChi = new TieuChi(NamAD, CQBH, DiemB1,DiemB12,DiemB13, DiemB2,DiemB22,DiemB23, MaKV,loaiho);
				Database.updateTieuchi(tieuChi);
				loadData();
				resetForm();
				
			}

			
		});
		btnNewButton_2.setBounds(914, 336, 89, 34);
		add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 486, 1097, 215);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u0103m", "CQBH", "\u0110i\u1EC3m B1", "B12", "B13", "\u0110i\u1EC3m B2", "B22", "B23", "Khu v\u1EF1c", "Lo\u1EA1i h\u1ED9"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(74);
		
		JLabel lblCqbh = new JLabel("CQBH");
		lblCqbh.setForeground(new Color(0, 0, 0));
		lblCqbh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCqbh.setBounds(56, 47, 89, 28);
		add(lblCqbh);
		
		textCQBH = new JTextField();
		textCQBH.setBounds(190, 47, 140, 25);
		add(textCQBH);
		textCQBH.setColumns(10);
		
		JLabel lblB = new JLabel("B1");
		lblB.setForeground(new Color(0, 0, 0));
		lblB.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblB.setBounds(72, 104, 101, 28);
		add(lblB);
		
		textB1 = new JTextField();
		textB1.setColumns(10);
		textB1.setBounds(190, 104, 140, 26);
		add(textB1);
		
		JLabel lblB_1 = new JLabel("B2");
		lblB_1.setForeground(new Color(0, 0, 0));
		lblB_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblB_1.setBounds(72, 163, 101, 28);
		add(lblB_1);
		
		textB2 = new JTextField();
		textB2.setColumns(10);
		textB2.setBounds(190, 166, 140, 26);
		add(textB2);
		
		JLabel lblMakv = new JLabel("MaKV");
		lblMakv.setForeground(new Color(0, 0, 0));
		lblMakv.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMakv.setBounds(72, 283, 89, 28);
		add(lblMakv);
		
		textMakv = new JTextField();
		textMakv.setColumns(10);
		textMakv.setBounds(190, 285, 140, 28);
		add(textMakv);
		
		JLabel lblNamad = new JLabel("NamAD");
		lblNamad.setForeground(new Color(0, 0, 0));
		lblNamad.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNamad.setBounds(72, 338, 89, 28);
		add(lblNamad);
		
		textNamAD = new JTextField();
		textNamAD.setColumns(10);
		textNamAD.setBounds(190, 338, 140, 25);
		add(textNamAD);
		
		JLabel lblLoaiho = new JLabel("Loại hộ");
		lblLoaiho.setForeground(new Color(0, 0, 0));
		lblLoaiho.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLoaiho.setBounds(72, 226, 89, 28);
		add(lblLoaiho);
		
		textLoaiHo = new JTextField();
		textLoaiHo.setColumns(10);
		textLoaiHo.setBounds(190, 225, 140, 34);
		add(textLoaiHo);
		
		JButton buttonXoa = new JButton("Xóa");
		buttonXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
					
				    } else if (response == JOptionPane.YES_OPTION) {
				    	int rowIndex = table.getSelectedRow();
					    int colIndex = table.getSelectedColumn();
					    
					    String str  = (String)table.getValueAt(rowIndex, 0);
					    Database.delTieuChi(str);
					    loadData();
					    System.out.println("rowIndex = " + rowIndex + "colIndex = " + colIndex);
				    }
			}
		});
		buttonXoa.setForeground(Color.RED);
		buttonXoa.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonXoa.setBounds(752, 335, 89, 34);
		add(buttonXoa);
		
		JLabel lblB_2 = new JLabel("B12");
		lblB_2.setForeground(new Color(0, 0, 0));
		lblB_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblB_2.setBounds(395, 102, 50, 28);
		add(lblB_2);
		
		textB12 = new JTextField();
		textB12.setColumns(10);
		textB12.setBounds(469, 104, 129, 28);
		add(textB12);
		
		JLabel lblB_3 = new JLabel("B13");
		lblB_3.setBackground(new Color(240, 240, 240));
		lblB_3.setForeground(new Color(0, 0, 0));
		lblB_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblB_3.setBounds(669, 102, 50, 28);
		add(lblB_3);
		
		textB13 = new JTextField();
		textB13.setColumns(10);
		textB13.setBounds(752, 104, 129, 28);
		add(textB13);
		
		JLabel lblB_4 = new JLabel("B22");
		lblB_4.setBackground(new Color(240, 240, 240));
		lblB_4.setForeground(new Color(0, 0, 0));
		lblB_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblB_4.setBounds(395, 161, 50, 28);
		add(lblB_4);
		
		textB22 = new JTextField();
		textB22.setColumns(10);
		textB22.setBounds(469, 163, 129, 25);
		add(textB22);
		
		JLabel lblB_5 = new JLabel("B23");
		lblB_5.setForeground(new Color(0, 0, 0));
		lblB_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblB_5.setBounds(669, 161, 50, 28);
		add(lblB_5);
		
		textB23 = new JTextField();
		textB23.setColumns(10);
		textB23.setBounds(752, 163, 129, 28);
		add(textB23);
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String NamAD = textNamAD.getText();
				String CQBH = textCQBH.getText();
				double DiemB1 = Double.valueOf(textB1.getText());
				double DiemB12 = Double.valueOf(textB12.getText());
				double DiemB13 = Double.valueOf(textB13.getText());
				
				double DiemB2 = Double.valueOf(textB2.getText());
				double DiemB22 = Double.valueOf(textB22.getText());
				double DiemB23 = Double.valueOf(textB23.getText());
				String MaKV  = textMakv.getText();
				String loaiho = textLoaiHo.getText();
				
				TieuChi tieuChi = new TieuChi(NamAD, CQBH, DiemB1,DiemB12,DiemB13, DiemB2,DiemB22,DiemB23, MaKV,loaiho);
				Database.addTieuChi(tieuChi);
				loadData();
				resetForm();
			}
		});
		
		loadData();
		
		

	}
	
	public void loadData() {
		ResultSet rs = Database.getAllTieuChi2();
		int i = 0;
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
				for (int m = rowCount - 1; m >= 0; m--) {
				    dm.removeRow(m);
				}
				try {
					while (rs.next()) {
						dm.addRow(new Object[]{" ", " ", " "," ", " ", " ", " "," ", " ", " "});
						for (int j = 0; j < 10; j++) {
							table.getModel().setValueAt(rs.getString(j+1), i, j); 
						}
						i++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	private void resetForm() { 
		btnNewButton.setEnabled(true);
		textNamAD.setText("");
		textCQBH.setText("");
		textB1.setText("");
		textB12.setText("");
		textB13.setText("");
		textB2.setText("");
		textB22.setText("");
		textB23.setText("");
		textMakv.setText("");
		textLoaiHo.setText("");
		
	}
}
