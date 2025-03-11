package com.dsa.leetcode.arrays_numbers.slidingwindow;

import java.util.HashMap;
import java.util.Set;

public class _1358NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {

        String word = "abcabc";
        int res = numberOfSubstrings(word);
        System.out.println(res);


    }

    static public int numberOfSubstrings(String word) {
        Set<Character> abcSet = Set.of('a', 'b', 'c');


        HashMap<Character, Integer> abcCounter = new HashMap<>();

        int res = 0;

        int i = 0;
        for (int j = 0; j < word.length(); j++) {
            if (abcSet.contains(word.charAt(j))) {
                abcCounter.put(word.charAt(j), abcCounter.getOrDefault(word.charAt(j), 0) + 1);
            }
            while (abcCounter.size() == 3) {
                res += word.length() - j;//as once, we get the answer, al the additional to right are also answers

                if (abcSet.contains(word.charAt(i))) {// precursor work as we will increment i
                    abcCounter.put(word.charAt(i), abcCounter.getOrDefault(word.charAt(i), 0) - 1);
                }

                if (abcCounter.getOrDefault(word.charAt(i), 0) == 0) {//since we are using map len to compare
//                      we will remove the leftest i entry  if its value goes 0, to ensure loop works well
                    abcCounter.remove(word.charAt(i));
                }

                ++i;//shrinking the window from left
            }

        }

        return res;


    }


}
