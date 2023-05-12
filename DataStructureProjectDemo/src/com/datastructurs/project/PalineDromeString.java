package com.datastructurs.project;

public class PalineDromeString {
	
	public static void main(String[] args) {
		String str = "AAAAAAAAA";
		String rev = "";
		
		for (int i = str.length() - 1; i >= 0; i--) {
           rev = rev+str.charAt(i);
		}
		
		if(rev.equals(str)) {
			System.out.println("PalineDrom Number");
		}
		else {
			System.out.println("NOT PalineDrom Number");
		}
	}
}
