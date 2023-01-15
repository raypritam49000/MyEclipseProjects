package com.datastructurs.project;

public class FabinaciSeries {

	public static void main(String[] args) {
		int number1 = 0, number2 = 1, number3, count = 5;
		System.out.print(number1 + " " + number2);

		for (int i = 2; i < count; i++) {
			number3 = number1 + number2;
			System.out.print(" " + number3);
			number1 = number2;
			number2 = number3;
		}
	}

}
