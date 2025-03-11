package com.dsa.leetcode.arrays_numbers.slidingwindow;

import java.util.HashSet;

public class _3LongestSubstringWithoutRepeatingCharacters {
//    https://leetcode.com/problems/longest-substring-without-repeating-characters
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);
    }


    static public int lengthOfLongestSubstring(String s) {

        int i = 0;
        int len = 0, maxLen = 0, result = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet();


        for (int j = 0; j < s.length(); j++) {//this loop wil kep on extending the right side of a window in the hope we find a larger window size
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                ++len;
            } else {
                while (i < s.length()) {//remove the elements  from start ith posn until it becomes a unique sub-string

                    if (s.charAt(i) == ch) {//if a duplicate element found change i and len
                        ++i;
                        --len;
                        break;
                    }
                    set.remove(s.charAt(i));//remove until the latest duplicate found
                    ++i;
                    --len;
                }
//                set.add(ch);//no need to add as we are a not removing in the if part
                ++len;//incrementing length to make it for adding the latest ch
            }
            maxLen = Integer.max(len, maxLen);
        }
        return maxLen;
    }


    public int lengthOfLongestSubstringCleanCode(String s) {
        int n = s.length();
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));//removing till  it becomes s again a unique substring
                    left++;
                }
                charSet.add(s.charAt(right));//adding the current characher at the end.
            }
        }

        return maxLength;
    }

}
