package com.hackerrank.algorithms.problemsolving.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/between-two-sets/problem
public class BetweenTwoSets {

	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//		int n = Integer.parseInt(firstMultipleInput[0]);
//		int m = Integer.parseInt(firstMultipleInput[1]);
//
//		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//				.map(Integer::parseInt).collect(toList());
//
//		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//				.map(Integer::parseInt).collect(toList());
//
//		int total = Result.getTotalX(arr, brr);
//
//		bufferedWriter.write(String.valueOf(total));
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(4);
		List<Integer> b = new ArrayList<Integer>();
		b.add(16);
		b.add(32);
		b.add(96);
		int total = Result.getTotalX(a, b);
		System.out.println(total);

	}

	static class Result {

		/*
		 * Complete the 'getTotalX' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts following
		 * parameters: 1. INTEGER_ARRAY a 2. INTEGER_ARRAY b
		 */

		public static int getTotalX(List<Integer> a, List<Integer> b) {
		
			// Write your code here
			
			return 0;
		}

	}
}
