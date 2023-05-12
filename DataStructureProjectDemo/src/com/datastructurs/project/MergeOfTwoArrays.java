package com.datastructurs.project;

import java.util.Arrays;

public class MergeOfTwoArrays {

	public static void main(String[] args) {

		int[] first_arr = { 34, 25, 75, 45 };
		int[] second_arr = { 234, 45, 56, 87 };
		int[] merge_arr = new int[(first_arr.length+second_arr.length)];
		int index = 0;
		
		
		System.out.println("Merge of Two Array : ");
		for(int i=0;i<first_arr.length;i++) {
			merge_arr[index] = first_arr[i];
			index++;
		}
		
		for(int i=0;i<second_arr.length;i++) {
			merge_arr[index] = second_arr[i];
			index++;
		}
		
		System.out.println(Arrays.toString(merge_arr));
	}
}
