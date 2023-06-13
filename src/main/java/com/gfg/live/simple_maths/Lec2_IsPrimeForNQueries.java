package com.gfg.live.simple_maths;

import java.util.Arrays;

public class Lec2_IsPrimeForNQueries {

    //    Say we have n = 10^6 queries to check for primes, and the maximum number one can query is also n
//    Here if we check for every prime it will take  10^6 * 10^3 queries as via simple approach its 10^3
    public static void main(String[] args) {

//        Sieve Of Eratosthenes - Mark out all the multiples of prime as non-prime
        boolean[] wholeNumberToCheckForPrime = new boolean[100000000];
        int numberToCheck = 96097;

        primeAnalysisForArrayTweaked(wholeNumberToCheckForPrime);

//        System.out.println(Arrays.toString(wholeNumberToCheckForPrime));
        System.out.println(numberToCheck + "==> " + wholeNumberToCheckForPrime[numberToCheck]);


    }

    //Drawback: Say we are iterating multiples of 2  4,6,8,20....
    // then why to iterate over multiples of 4 as they are already covered through multiples of 2,
    // So repetitive calculation is happening


    private static void primeAnalysisForArray(boolean[] wholeNumberToCheckForPrime) {
//        O(n) = 1 will run  n times + 2* n/2   3* n/3 . i*  n/i ...n times =  n + n/2 +n/3 ..n/n =
//        = n(1/2 + 1/3 +1/4 + 1/n) = n (log n) tightest upper bound
        long startTime = System.nanoTime();
        Arrays.fill(wholeNumberToCheckForPrime, true);//Assuming all numbers from indices 0 - 1000000 are prime
        wholeNumberToCheckForPrime[0] = false;
        wholeNumberToCheckForPrime[1] = false;
        wholeNumberToCheckForPrime[2] = true;
        for (int i = 2; i < wholeNumberToCheckForPrime.length; i++) {//starting with i=2 as i=1 will mark all the numbers as false
//            iterating over all the multiples of i
            for (int j = 2 * i; j < wholeNumberToCheckForPrime.length; j += i) {//if i = 2 j = 4,6,8...
                wholeNumberToCheckForPrime[j] = false;//as these are factors so they are not prime
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Delta ==> " + (endTime - startTime));
    }

    private static void primeAnalysisForArrayTweaked(boolean[] wholeNumberToCheckForPrime) {
//        O(n) = 1 will run  n times + 2* n/2   3* n/3 . i*  n/i ...n times =  n + n/2 +n/3 ..n/n =
//        = n(1/2 + 1/3 +1/4 + 1/n) = n (log n) tightest upper bound
        long startTime = System.nanoTime();
        Arrays.fill(wholeNumberToCheckForPrime, true);//Assuming all numbers from indices 0 - 1000000 are prime
        wholeNumberToCheckForPrime[0] = false;
        wholeNumberToCheckForPrime[1] = false;
        wholeNumberToCheckForPrime[2] = true;
        for (int i = 2; i < wholeNumberToCheckForPrime.length; i++) {//starting with i=2 as i=1 will mark all the numbers as false
//            iterating over all the multiples of i
            if (wholeNumberToCheckForPrime[i])//will only check for multiples of prime which will *reduce repetitions
                for (int j = 2 * i; j < wholeNumberToCheckForPrime.length; j += i) {//if i = 2 j = 4,6,8...
                    wholeNumberToCheckForPrime[j] = false;//as these are factors so they are not prime
                }
        }

        long endTime = System.nanoTime();
        System.out.println("Delta ==> " + (endTime - startTime));
    }

}
