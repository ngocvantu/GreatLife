package com.hello;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public  class combobox extends JFrame implements ActionListener{
 String [] messageStrings= {"1","2","3"};
JComboBox cmbmessageList= new JComboBox(messageStrings);
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
