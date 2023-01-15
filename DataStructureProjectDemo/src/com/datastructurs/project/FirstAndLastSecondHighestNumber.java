package com.datastructurs.project;

import java.util.Arrays;

public class FirstAndLastSecondHighestNumber {

	public static void main(String[] args) {
		int[] num = { 44, 66, 99, 77, 33, 22, 55, 100, 10, 5, 200 };
		int temp;
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(num));
		System.out.println("First Second Highest Number : " + num[1]);
		System.out.println("Last Second Highest Number : " + num[num.length - 2]);
		
		System.out.println("First Third Highest Number : " + num[2]);
		System.out.println("Last Third Highest Number : " + num[num.length - 3]);

	}
}
