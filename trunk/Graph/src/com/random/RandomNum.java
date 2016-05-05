package com.random;

import java.util.Arrays;
import java.util.Random;

public class RandomNum {
	
	

	public static void main(String[] args) { 
		int[] data = new int[10];
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
		int[] orga = Arrays.copyOf(data, data.length);
		System.out.println("Arrays equal before sort: " + Arrays.equals(data, orga));
		System.out.println("data[] = " + Arrays.toString(data));
		System.out.println("orga[] = " + Arrays.toString(orga));
		Arrays.sort(data);
		System.out.println("Arrays equal after sort: " + Arrays.equals(data, orga));
		System.out.println("data[] = " + Arrays.toString(data));
		System.out.println("orga[] = " + Arrays.toString(orga));
	}

}
