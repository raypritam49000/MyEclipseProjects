package com.datastructurs.project;

public class SwappingNumber {

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		int temp;

		System.out.println("After Wapping :- ");
		System.out.println("Value of X : " + x);
		System.out.println("Value of y : " + y);

		temp = x;
		x = y;
		y = temp;

		System.out.println("Before swapping :- ");
		System.out.println("Value of X : " + x);
		System.out.println("Value of y : " + y);

		int a = 10;
		int b = 20;

		System.out.println("After Wapping :- ");
		System.out.println("Value of a : " + a);
		System.out.println("Value of b : " + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("Before swapping :- ");
		System.out.println("Value of a : " + a);
		System.out.println("Value of b : " + b);

	}
}
