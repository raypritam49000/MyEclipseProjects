package com.datastructurs.project;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateElementInArray {

	public static void main(String[] args) {

		// Sorted Array
		int[] a = { 19, 19, 23, 34, 34, 65, 346, 346, 456, 456, 876, 9796 };
		int[] temp = new int[a.length];
		int index = 0;

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] != a[i + 1]) {
				temp[index] = a[i];
				index++;
			}
		}

		temp[index] = a[a.length - 1];

		System.out.println(Arrays.toString(temp));

		// Unsorted Array
		int[] arr = new int[] { 56, 64, 23, 354, 75, 56, 68, 64, 354, 10, 40, 20, 40 };
		System.out.println(Arrays.toString(arr));
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			hs.add(arr[i]);
		}
		
		System.out.println(hs);

		for(Integer no : hs) {
			System.out.print(" "+no);
		}
	}

}
