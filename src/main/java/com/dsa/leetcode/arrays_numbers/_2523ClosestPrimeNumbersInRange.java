package com.dsa.leetcode.arrays_numbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _2523ClosestPrimeNumbersInRange {

    public static void main(String[] args) {

        int[] ints = closestPrime(1, 1000000);
        System.out.println(Arrays.toString(ints));

    }

    //1 using  Sieve of Eratosthenes
    static public int[] closestPrime(int left, int right) {

        List<Integer> list = findPrimesInRangeSieveOfEratosthenes(left, right);

        int[] result = new int[2];
        Arrays.fill(result, -1);
        int minDiff = Integer.MAX_VALUE;// alt value right-left+1

        if (list.size() < 2) {//Edge Case
            return result;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i + 1) - list.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = list.get(i);
                result[1] = list.get(i + 1);
            }
        }

        return result;

    }

    public static List<Integer> findPrimesInRangeSieveOfEratosthenes(int left, int right) {//Sieve of Eratosthenes


        boolean[] primes = new boolean[right + 1];

        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        long sqrt = (long) Math.sqrt(right);
        for (int i = 2; i <= sqrt; i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i * i; j <= right; j += i) {
                primes[j] = false;
            }
        }


        return IntStream.rangeClosed(left, right)
                .filter(i -> primes[i])
                .boxed()
                .toList();


    }

    public static List<Integer> findPrimesInRangeSieveOfEratosthenesGemini(int left, int right) {//Sieve of Eratosthenes
        if (left < 2) {
            left = 2; // Start from 2, as 0 and 1 are not prime
        }

        int rangeSize = right - left + 1;
        boolean[] isPrime = new boolean[rangeSize];
        Arrays.fill(isPrime, true); // Initially, assume all numbers are prime

        // Sieve of Eratosthenes for numbers up to sqrt(right)
        int sqrtRight = (int) Math.sqrt(right);
        for (int p = 2; p <= sqrtRight; p++) {
            // Find the starting point within the range for p
            int start = Math.max(p * p, (left + p - 1) / p * p); // Ensure start >= left and start is a multiple of p

            for (int i = start; i <= right; i += p) {
                isPrime[i - left] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i - left]) {
                primes.add(i);
            }
        }

        return primes;
    }


    //2 using 6k +- 1 rule
    public int[] closestPrimesBrute(int left, int right) {

        int num1 = -1, num2 = -1;
        ArrayList<Integer> list = new ArrayList<>();


        while (left <= right) {
            if (isPrimeOptimised(left)) {
                list.add(left);
            }
            left++;
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        Arrays.fill(result, -1);

        if (list.size() < 2) {//Edge Case
            return result;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i + 1) - list.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = list.get(i);
                result[1] = list.get(i + 1);
            }
        }

        return result;
    }


    private static boolean isPrimeOptimised(long sample) {


        if (sample <= 1)// 1 is not prime
            return false;

        if (sample == 2 || sample == 3 || sample == 5 || sample == 7)
            return true;
        if (sample % 2 == 0)
            return false;

        if (sample % 3 == 0)
            return false;
        int endLimit = (int) Math.sqrt(sample);
        int param1, param2;
        int k = 1;

        do {
            param1 = (6 * k) + 1;
            param2 = param1 - 2;
            if (sample % param1 == 0 || sample % param2 == 0)
                return false;
            k++;

        } while (param1 <= endLimit && param2 <= endLimit);

        return true;
    }


    public int[] closestPrimes6ms(int left, int right) {
        List<Integer> primeNumbers = new ArrayList<>();

        // Find all prime numbers in the given range
        for (int candidate = left; candidate <= right; candidate++) {
            if (candidate % 2 == 0 && candidate > 2) {
                continue;
            }
            if (isPrime(candidate)) {
                // If a twin prime (or [2, 3]) is found, return immediately
                if (
                        !primeNumbers.isEmpty() &&
                                candidate <= primeNumbers.get(primeNumbers.size() - 1) + 2
                ) {
                    return new int[] {
                            primeNumbers.get(primeNumbers.size() - 1),
                            candidate,
                    };
                }
                primeNumbers.add(candidate);
            }
        }

        // If fewer than 2 primes exist, return {-1, -1}
        if (primeNumbers.size() < 2) {
            return new int[] { -1, -1 };
        }

        // Find the closest prime pair
        int[] closestPair = new int[] { -1, -1 };
        int minDifference = 1000000;
        for (int index = 1; index < primeNumbers.size(); index++) {
            int difference =
                    primeNumbers.get(index) - primeNumbers.get(index - 1);
            if (difference < minDifference) {
                minDifference = difference;
                closestPair = new int[] {
                        primeNumbers.get(index - 1),
                        primeNumbers.get(index),
                };
            }
        }

        return closestPair;
    }

    // Function to check if a number is prime
    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int divisor = 2; divisor <= (int) Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

}
