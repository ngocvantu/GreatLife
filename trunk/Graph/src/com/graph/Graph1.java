package com.graph;

public class Graph1 {
	
	static int[][] matran = {	{0,1,1,1},
						{1,0,0,1},
						{1,0,0,0},
						{1,1,0,0}
	} ;
	
	public void print(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) { 
		Graph1 graph1 = new Graph1();
		graph1.print(matran);
		
		System.out.println("Những cạnh mà đỉnh 2 có thể tới: ");
		for (int i = 0; i < matran[1].length; i++) {
			if (matran[1][i] == 1) {
				System.out.println((i+1));
			}
		}
	}

}
