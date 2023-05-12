package com.datastructurs.project;

public class SumOfDigit {

	public static void main(String[] args) {
		int num = 444;
		int temp = num;
		int sum = 0;
		int a;
		
		while (num > 0) {
			a = num % 10;
			num = num / 10;
			sum = sum + a;
		}
		
		System.out.println(sum);
	}

}
