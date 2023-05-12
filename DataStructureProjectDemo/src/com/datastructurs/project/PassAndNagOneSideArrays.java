package com.datastructurs.project;

import java.util.Arrays;

public class PassAndNagOneSideArrays {

	public static void main(String[] args) {
		int[] num = { 10, -10, 2, -4, -6, 30, 45, -45, -654, 322 };
		System.out.println("After Sorting : ");
		System.out.println(Arrays.toString(num));
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
		
		System.out.println("Before Sorting : ");
		System.out.println(Arrays.toString(num));
	}
}
