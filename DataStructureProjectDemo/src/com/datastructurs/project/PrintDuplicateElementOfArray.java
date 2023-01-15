package com.datastructurs.project;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class PrintDuplicateElementOfArray {

	public static void main(String[] args) {

		System.out.println("1. Brute Force Method ");
		int[] a = { 10, 30, 45, 56, 34, 56, 45, 190, 10 };

		System.out.print("Duplicate Number :- ");
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j] && i != j) {
					System.out.print(" " + a[i]);
				}
			}
		}

		System.out.println();
		System.out.println("2. Set Interface");
		int[] arr = { 10, 30, 45, 56, 34, 56, 45, 190, 10 };

		System.out.print("Duplicate Number :- ");
		Set<Integer> hs = new HashSet<>();
		for (Integer num : arr) {
			if (hs.add(num) == false) {
				System.out.print(" " + num);
			}
		}

		System.out.println();
		System.out.println("3. Using HashTable");
		int[] number = { 10, 30, 45, 56, 34, 56, 45, 190, 10 };
		System.out.print("Duplicate Number :- ");
		Map<Integer, Integer> map = new Hashtable<>();

		for (Integer num : number) {
			Integer count = map.get(num);

			if (count == null) {
				map.put(num, 1);
			} else {
				count = count + 1;
				map.put(num, count);
			}
		}

		Set<Map.Entry<Integer, Integer>> es = map.entrySet();

		for (Map.Entry<Integer, Integer> me : es) {
			if (me.getValue() > 1) {
				System.out.print(" " + me.getKey());
			}
		}

	}
}
