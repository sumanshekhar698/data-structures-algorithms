package com.dsa.leetcode.strings.basics;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*Pangram: In a sentence containing every letter in the English alphabet.
 Given a string, find all characters that are missing from the string, i.e.,
 the characters that can make string a Pangram. We need to print output in alphabetic order.
 if its already a panagram , then print true .

Examples:
Input : The quick brown fox jumps
Output : adglvyz

Input: The quick brown fox jumps over the lazy dog
OutPut: true*/
public class Panagram {

    public static void main(String[] args) {

        Set<Character> set = new LinkedHashSet<>() {{
            add('a');
            add('b');
            add('c');
            add('d');
            add('e');
            add('f');
            add('g');
            add('h');
            add('i');
            add('j');
            add('k');
            add('l');
            add('m');
            add('n');
            add('o');
            add('p');
            add('q');
            add('r');
            add('s');
            add('t');
            add('u');
            add('v');
            add('w');
            add('x');
            add('y');
            add('z');
        }};


        String str = "The quick brown fox jumps";
        str ="The quick brown fox jumps over the lazy dog";
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                set.remove(ch);
            }
        }

        if (set.isEmpty())
            System.out.println(true);
        else
            set.stream().forEach(System.out::print);


    }
}
;