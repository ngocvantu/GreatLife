package com.tictactoe;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public Main() { 
//		setSize(800, 800);
		setLocation(200, 100);
		TicTacToe game = new TicTacToe(this);
		getContentPane().add(game);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) { 
		Main main = new Main();
		main.setVisible(true);
	}

}
