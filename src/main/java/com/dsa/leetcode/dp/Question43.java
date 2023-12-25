package com.dsa.leetcode.dp;

import java.util.*;

public class Question43 {
    public static void main(String args[]) {
        Set<String> set = new LinkedHashSet<String>();
        set.add("3");
        set.add("1");
        set.add("4");
        set.removeIf(s -> set.contains("1"));
        set.add("2");
        set.remove("2 ");
        set.remove("2 ");

    }
}
