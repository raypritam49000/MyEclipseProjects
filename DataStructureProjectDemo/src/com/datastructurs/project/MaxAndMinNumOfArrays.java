package com.datastructurs.project;

public class MaxAndMinNumOfArrays {

	public static void main(String[] args) {

		int[] num = { 10, 5, 23, 652, 2, 90, 34, 80 };
		int max = 0;
		int min = num[0];

		for (int i = 0; i < num.length; i++) {
			if (max < num[i]) {
				max = num[i];
			}

			if (min > num[i]) {
				min = num[i];
			}
		}

		System.out.println("Maximum Number : " + max);
		System.out.println("Minimum Number : " + min);
	}
}
