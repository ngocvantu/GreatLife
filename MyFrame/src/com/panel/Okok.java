package com.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import com.hello.combobox;

public class Okok extends JPanel implements ItemListener {
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	JComboBox comboBox =new JComboBox() ;
	JComboBox comboBox_1 = new JComboBox();
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Okok() {
		setBackground(new Color(189, 183, 107));
		
		setBounds(233, 1, 1131, 713);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\NGOC HOANG\\Desktop\\timkiem3.jpg"));
		lblNewLabel_1.setBounds(819, 56, 312, 256);
		add(lblNewLabel_1);
		
		JButton btnTm = new JButton("T\u00ECm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			String txt= textField.getText();
			ResultSet rs = Database.gettimkiem(txt);
		int i = 0; 
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (int j = model.getRowCount()-1; j >= 0; j--) {
				model.removeRow(j);
			}
			
			try {
				while (rs.next()) {  
					
					model.addRow(new Object[]{" ", " ", " "," ", " ", " "," ", " ", " "," ", " ", " "," ", " ", " "});
					for (int j = 1; j < 16; j++) {
						
						table.getModel().setValueAt(rs.getString(j), i, j-1 ); 
					}
					
					
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			
		}
				
			 
		});
		
		
		btnTm.setForeground(Color.RED);
		btnTm.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTm.setBounds(310, 238, 123, 35);
		add(btnTm);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 341, -218, 91);
		add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 374, 1131, 316);
		add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, "", "", "", "", null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"X\u00E3", "M\u00E3 h\u1ED9", "Ch\u1EE7 h\u1ED9", "\u0110i\u1EC3m B1", "\u0110i\u1EC3m B2", "Khu v\u1EF1c", "L\u1ECDai h\u1ED9", "Thu nh\u1EADp", "TT nh\u00E0 \u1EDF", "Th\u00F4ng tin", "N\u01B0\u1EDBc sinh ho\u1EA1t", "TT H\u1ECDc v\u1EA5n", "Y t\u1EBF", "Ng\u00E0y nh\u1EADp", "TT C\u1EA5p th\u1EBB"
			}
		));
		table.getColumnModel().getColumn(10).setPreferredWidth(93);
		
		JButton btnNewButton = new JButton("S\u1EEDa");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(564, 25, 107, 35);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(564, 97, 107, 35);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("L\u01B0u");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(564, 199, 107, 35);
		add(btnNewButton_2);
		
		 
		comboBox.setBounds(158, 25, 157, 31);
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
		
		  
		comboBox_1.setBounds(158, 94, 157, 31);
		add(comboBox_1);
		comboBox_1.addItemListener(this);
		
		textField = new JTextField();
		textField.setBounds(35, 238, 230, 40);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Huyện");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(59, 25, 65, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Xã");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(59, 102, 65, 24);
		add(lblNewLabel_2);

	}

	@Override
	public void itemStateChanged(ItemEvent event) { 
		JComboBox cb = (JComboBox) event.getSource();
		if(cb==comboBox){
			comboBox_1.removeAllItems();
			ResultSet allxa= Database.getAllxa((String)comboBox.getSelectedItem());
			try {
				while (allxa.next()) {
					comboBox_1.addItem(allxa.getString("Maxa"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (cb == comboBox_1) {
			ResultSet rs = Database.getAllThongTin() ;
			int i = 0; 
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (int j = model.getRowCount()-1; j >= 0; j--) {
				model.removeRow(j);
			}
			try {
				while (rs.next()) {  
					
					model.addRow(new Object[]{" ", " ", " "," ", " ", " "," ", " ", " "," ", " ", " "," ", " ", " "});
					for (int j = 1; j < 16; j++) {
						
						table.getModel().setValueAt(rs.getString(j), i, j-1 ); 
					}
					
					
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
		}
		
	}
}
