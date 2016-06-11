package com.tictactoe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private int n = 16;
	private int m = 4;
	private int board[][] = new int[n][n];
	public static final int EMP_TY = 0;
	public static final int X = 1;
	public static final int O = -1;
	private int player ;
	private int width = 30;
	Main main;
	
	public TicTacToe(Main main) { 
		this.main = main;
		main.setSize(800, 600);
		addMouseListener(this);
		setSize(165, 165);
		setLocation(100, 200);
		clearBoard();
	}
	
	public TicTacToe( ) { 
		addMouseListener(this);
		setSize(165, 165);
		setLocation(100, 200);
		clearBoard();
	}
	
	public void clearBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
		player = X;
	}
	
	public void play(int i, int j) {
		if((i<0)||(i>n-1)||(j<0)||(j>n-1)){
//			throw new IllegalArgumentException("invalid board position");
			System.out.println("invalid board position");
			return;
		}
		if (board[i][j] != EMP_TY){
//			throw new IllegalArgumentException("board position accupied");
			System.out.println("board position accupied");
			return;
		}
		board[i][j] = player;
		repaint();
		if(isWin(player,i,j)){
			JOptionPane.showMessageDialog(null, player +" thang");
		}
		player = - player;
	}
	
	private boolean isWin(int player, int i, int j) {
		 
			// truc x
			for (int i2 = 0; i2 < n - 4; i2++) {
				if(board[i2][j] == player && board[i2+1][j] == player && board[i2+2][j] == player
						&& board[i2+3][j] == player && board[i2+4][j] == player  ){
					return true;
				}
			}
			// truc y
			for (int j2 = 0; j2 < n-4; j2++) {
				if(board[i][j2] == player && board[i][j2+1] == player && board[i][j2+2] == player
						&& board[i][j2+3] == player && board[i][j2+4] == player  ){
					return true;
				}
			}
			// cheo phai \
			if(j-i<n-4 && j-i >=0){
				for (int j2 = j-i; j2 < n-4; j2++) {
					if(board[j2-(j-i)][j2] == player && board[j2-(j-i) +1][j2+1] == player
							&& board[j2-(j-i)+2][j2+2] == player && board[j2-(j-i)+3][j2+3] == player && board[j2-(j-i)+4][j2+4] == player){
						return true;
					}
				}
			} else if(i-j < n-4 && i-j >=0){
				for (int i2 = i-j; i2 < n-3; i2++) {
					if(board[i2][i2-(i-j)] == player && board[i2+1][i2-(i-j)+1] == player 
							&& board[i2+2][i2-(i-j)+2] == player && board[i2+3][i2-(i-j)+3] == player && board[i2+4][i2-(i-j)+4] == player){
						return true;
					}
				}
			}
			
			if(i+j < n && i+j >3){
				for (int j2 = 0; j2 < i+j-3; j2++) {
					if(board[i+j-j2][j2] == player && board[i+j-j2-1][j2+1] == player 
							&& board[i+j-j2-2][j2+2] == player && board[i+j-j2-3][j2+3] == player && board[i+j-j2-4][j2+4] == player  ){
						return true;
					}
				}
			} else if(i+j >= n && i+j < 2*(n-1)-3){
				for (int i2 = n-1; i2 > i+j-(n-3); i2--) {
					System.out.println();
					if(board[i2][i+j-i2] == player 
							&& board[i2-1][i+j-i2+1] == player 
							&& board[i2-2][i+j-i2+2] == player
							&& board[i2-3][i+j-i2+3] == player && board[i2-4][i+j-i2+4] == player  ){
						return true;
					}
				}
			}
	 
		return false;
	}

	public String toString() { 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (board[i][j]) {
				case X:
					sb.append("X");
					break;
				case O:
					sb.append("O");
					break;
				case EMP_TY:
					sb.append(" ");
					break;
				default:
					break;
				}
				if(j<n-1)
				sb.append("|");
			}
			if(i<n-1)
			sb.append("\n-------\n");
		}
		return sb.toString();
	}
	
	

	public static void main(String[] args) { 
		TicTacToe game = new TicTacToe();
		game.play(1, 2);
		game.play(0, 1);
		game.play(1, 0);
		game.play(1, 1);
		game.play(0, 0);
		game.play(2, 0);
		game.play(0, 2);
		game.play(2, 2);
		game.play(2, 1);
		
		game.play(1, 3);
		game.play(2, 3);
		game.play(0, 3);
		
		game.play(3, 2);
		game.play(3, 1);
		game.play(3, 0);
		game.play(3, 3);
		System.out.println(game.toString());
		
		 
	}
	
	public class MainBoard extends JFrame{
		TicTacToe gameView = new TicTacToe();
		public MainBoard() { 
			getContentPane().add(gameView);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
		for (int i = 0; i < n; i++) {
			g2d.setColor(Color.blue);
			g2d.drawLine(0, i*width + i, width*n + n, i*width + i);
			g2d.drawLine(i*width + i, 0, i*width + i, width*n + n); 
			
			
			for (int j = 0; j < n; j++) {
				switch (board[i][j]) {
				case X:
					g2d.setColor(Color.red);
					g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
					g2d.drawString("X", j*width + width/2 + j - 5, i*width + width/2 + i + 6);
					break;
				case O:
					g2d.setColor(Color.black);
					g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
					g2d.drawString("O", j*width + width/2 + j - 5, i*width + width/2 + i + 6);
					break;
				case EMP_TY:
					 
					break;

				default:
					break;
				}
			}
		}
		
		g2d.setColor(Color.blue);
		g2d.drawLine(0, n*width + n, width*n + n, n*width + n);
		g2d.drawLine(n*width + n, 0, n*width + n, width*n + n); 
		
	}
	
	public boolean isColision(int i, int j, int y, int x){
		if((x > i*width + i) && (y > j*width + j) && (x < (i+1)*width + (i+1)) && (y < (j+1)*width + (j+1))){
			return true;
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) { 
		if(e.getButton() == MouseEvent.BUTTON1){
		 for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isColision(i, j, e.getX(), e.getY())) {
					System.out.println(" [" + i + "][" + j + "]");
					play(i, j);
					
				}
			}
		}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {  
//		System.out.println("X = " +e.getX() );
//		System.out.println("Y = " +e.getY() );
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
