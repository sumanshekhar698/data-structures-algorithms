package com.dsa.leetcode.arrays_numbers.slidingwindow;

import java.util.HashMap;
import java.util.Set;

public class _3306_M_CountOfSubstringsContainingEveryVowelAndKConsonants {

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }

    static public long countOfSubstrings(String word, int k) {

        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');


        class Helper {
            long atLeastK(int k) {
                HashMap<Character, Integer> vowelCountMap = new HashMap<>();
                int consonantsCount = 0;
                long res = 0L;
                int i = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (vowelsSet.contains(word.charAt(j))) {
                        vowelCountMap.put(word.charAt(j), vowelCountMap.getOrDefault(word.charAt(j), 0) + 1);
                    } else {
                        consonantsCount++;
                    }
                    while (vowelCountMap.size() == 5 && consonantsCount >= k) {
                        res += word.length() - j;//as once, we get the answer, al the additional to right are also answers

                        if (vowelsSet.contains(word.charAt(i))) {// precursor work as we will increment i
                            vowelCountMap.put(word.charAt(i), vowelCountMap.getOrDefault(word.charAt(i), 0) - 1);
                        } else {
                            consonantsCount--;
                        }

                        if (vowelCountMap.getOrDefault(word.charAt(i), 0) == 0) {//since we are using map len to compare
//                      we will remove the leftest i entry  if its value goes 0, to ensure loop works well
                            vowelCountMap.remove(word.charAt(i));
                        }

                        ++i;//shrinking the window from left
                    }

                }

                return res;

            }

        }

        Helper helper = new Helper();
        long atLeastK = helper.atLeastK(k);// this will be larger than k+1 as atLeastK is inclusive of atLeastKPlus1
        long atLeastKPlus1 = helper.atLeastK(k + 1);

        return atLeastK - atLeastKPlus1;

    }
}
