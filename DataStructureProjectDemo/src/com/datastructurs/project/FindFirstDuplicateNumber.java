package com.datastructurs.project;

import java.util.HashSet;
import java.util.Set;

public class FindFirstDuplicateNumber {

	public static void main(String[] args) {

		System.out.println("First Way Find First Duplicate Number : ");
		int[] a = { 6, 5, 3, 2, 5, 1, 2, 4 };

		for (int i = 0; i < a.length - 1; i++) {

			int temp = 0;

			for (int j = i + 1; j < a.length; j++) {

				if (a[i] == a[j] && i != j) {
					System.out.println("First Duplicate element is " + a[i]);
					temp = temp + 1;
					break;
				}

			}

			if (temp > 0) {
				break;
			}
		}

		System.out.println("Second Way Find First Duplicate Number : ");
		int[] arr = { 6, 5, 3, 2, 5, 1, 2, 4, 4 };
		Set<Integer> hs = new HashSet<>();
		int temp = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (hs.contains(arr[i])) {
				temp = i;
			} else {
				hs.add(arr[i]);
			}
		}

		if (temp != -1) {
			System.out.println("First Duplicate element is " + a[temp]);
		}
		else {
			System.out.println("Not Duplicate element in The List ");
		}
	}
}
