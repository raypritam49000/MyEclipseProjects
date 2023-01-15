package com.datastructurs.project;

import java.util.HashSet;
import java.util.Set;

public class UnioneAndIntsectionProject {

	public static void main(String[] args) {
		Set<Integer> unione = new HashSet<Integer>();
		int[] num1 = { 10, 30, 40, 50, 34, 23, 46 };
		int[] num2 = { 200, 430, 450, 510, 34, 23, 46 };

		for (int i = 0; i < num1.length; i++) {
			unione.add(num1[i]);
		}
		System.out.println(unione);

		for (int j = 0; j < num2.length; j++) {
			unione.add(num2[j]);
		}

		System.out.println("Unione : "+unione);

		Set<Integer> intsec = new HashSet<Integer>();

		for (int i = 0; i < num1.length; i++) {
			intsec.add(num1[i]);
		}

		System.out.print("InterSections : ");
		for (int j = 0; j < num2.length; j++) {
			if (intsec.contains(num2[j])) {
				System.out.print(" "+num2[j]);
			}
		}
		
	}

}
