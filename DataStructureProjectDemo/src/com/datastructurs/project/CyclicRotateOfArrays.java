package com.datastructurs.project;

import java.util.Arrays;

public class CyclicRotateOfArrays {

	public static void main(String[] args) {
		int[] num = { 10, 20, 56, 23, 76, 354, 866 };
		int temp = num[num.length - 1];
		System.out.println(Arrays.toString(num));

		for (int i = num.length - 1; i > 0; i--) {
			num[i] = num[i - 1];
		}

		System.out.println(Arrays.toString(num));
        num[0] = temp;
    	System.out.println(Arrays.toString(num));
	}
}
