package com.gfg.live.simple_maths;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class _01ReverseAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 5, 2, 8, 4 };
		reverseArray(array);
		System.out.println(Arrays.toString(array));
//		new ArrayList<>();

	}

	private static void reverseArray(int[] array) {
		int i = 0, j = array.length - 1;
		int temp;
		while (j > i) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			j--;
			i++;
		}

	}

}
