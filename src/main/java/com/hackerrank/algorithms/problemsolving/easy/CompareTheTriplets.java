package com.hackerrank.algorithms.problemsolving.easy;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
//https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true
public class CompareTheTriplets {

	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
//				.collect(toList());
//
//		List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
//				.collect(toList());
//
//		List<Integer> result = Result.compareTriplets(a, b);
//
//		bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");
//
//		bufferedReader.close();
//		bufferedWriter.close();
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		List<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(2);
		b.add(1);
		List<Integer> result = Result.compareTriplets(a, b);
		System.out.println(result);// [1, 1]

	}

	static class Result {

		/*
		 * Complete the 'compareTriplets' function below.
		 *
		 * The function is expected to return an INTEGER_ARRAY. The function accepts
		 * following parameters: 1. INTEGER_ARRAY a 2. INTEGER_ARRAY b
		 */

		public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

			// Write your code here
			int alice = 0;
			int bob = 0;
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) == b.get(i))
					continue;
				else if (a.get(i) >= b.get(i))
					alice++;
				else
					bob++;
			}
			List<Integer> list = new ArrayList<Integer>();
			list.add(alice);
			list.add(bob);
			return list;
		}
	}

}

/*
 * PYTHON SOLUTIONS
 */
// 1
//def compareTriplets(a, b):
//    a_score, b_score = 0, 0
//    for i in range(3):
//        a_score += a[i] > b[i]
//        b_score += b[i] > a[i]
//    return [a_score, b_score]

//2
//for a, b in zip(alice, bob):
//    score[0] += a > b
//    score[1] += a < b

//3
//def solve(a, b):
//    alice = []
//    bob = []
//    for _ in range(len(a)):
//        if(a[_] > b[_]): alice.append(1)
//        elif(a[_] < b[_]): bob.append(1)
//    return sum(alice), sum(bob)
