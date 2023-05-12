package com.datastructurs.project;

import java.util.ArrayList;
import java.util.Arrays;

public class OddAndEvenOfArray {

	public static void main(String[] args) {

//		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

//		int left = 0;
//		int right = num.length - 1;
//
//		for (int i = 0; i < num.length; i++) {
//			
//			while (num[left] % 2 == 0) {
//				left++;
//			}
//			
//			while (num[right] % 2 == 1) {
//				right--;
//			}
//
//			if (left < right) {
//				int temp = num[left];
//				num[left] = num[right];
//				num[right] = temp;
//			}
//		}
//		
//		System.out.println(Arrays.toString(num));

		int a[] = { 1, 2, 5, 6, 3, 2, 0, 7, 8, 9 };
		ArrayList<Integer> list = new ArrayList<>();
		int[] num = new int[a.length];
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				System.out.print(" " + a[i]);
				list.add(a[i]);
				num[index] = a[i];
				index++;
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				System.out.print(" " + a[i]);
				list.add(a[i]);
				num[index] = a[i];
				index++;
			}
		}

		System.out.println();
		System.out.println(list);
		System.out.println(Arrays.toString(num));

	}
}
