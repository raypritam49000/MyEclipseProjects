package com.datastructurs.project;

public class PrimeNumber {

	public static void main(String[] args) {
		int num = 2;
		Boolean isPrimeNumber = true;

		if (num == 0 || num == 1) {
			System.out.println("This is not prime number");
		}

		for (int i = 2; i < num - 1; i++) {
			if (num % i == 0) {
				isPrimeNumber = false;
			}
		}

		if (isPrimeNumber) {
			System.out.println("This is Prime Number");
		} else {
			System.out.println("This is not prime number");
		}

	}
}
