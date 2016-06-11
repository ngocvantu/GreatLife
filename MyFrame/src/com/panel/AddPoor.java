package com.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class AddPoor extends JPanel {
	private JTable table = new JTable();
	Object data[][]  = new Object[][] {
			{null},
			{null},
			{null},
			{null},
			{null},
			{null},
			{null},
			{null},
			{null},
			
			
		};;
	Statement stm;

	/**
	 * Create the panel.
	 */
	public AddPoor() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		setBounds(233, 1, 1131, 713);
		setVisible(true);
		setLayout(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setLocation(new Point(100, 200));
		table.setMaximumSize(new Dimension(1000, 2000));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setLayout(null);
		scrollPane.setBounds(2, 1, 477, 496);
		add(scrollPane);
		
//		stm = Database.conn.createStatement();
//		ResultSet rs =  stm.executeQuery("SELECT * FROM `hnt_quanhe`  ");
		int i = 0;
		int j = 0;
//		while (rs.next()) {
//			table.getModel().setValueAt(rs.getString("tenQuanHe"), i, j);
//			i++;
//		}
		
		
//		table.setBounds(20, 20, 54, 54);

	}
}

