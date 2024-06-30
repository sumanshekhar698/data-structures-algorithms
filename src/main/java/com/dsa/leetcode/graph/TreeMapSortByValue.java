package com.dsa.leetcode.graph;

import java.util.*;
public class TreeMapSortByValue {  
    public static void main(String[] args) {  
        // Create a TreeMap and populate it with key-value pairs  
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("John", 25);
        treeMap.put("Alice", 30);
        treeMap.put("Bob", 20);
        treeMap.put("Eve", 35);
        // Create a list from the entry set of the TreeMap  
        List<Map.Entry<String, Integer>> list = new ArrayList<>(treeMap.entrySet());  
        // Sort the list by values using a custom comparator  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {  
                return o1.getValue().compareTo(o2.getValue());  
            }  
        });  
        // Create a new TreeMap using the sorted list  
        TreeMap<String, Integer> sortedTreeMap = new TreeMap<>();  
        for (Map.Entry<String, Integer> entry : list) {  
            sortedTreeMap.put(entry.getKey(), entry.getValue());  
        }  
        // Print the sorted TreeMap by value  
        for (Map.Entry<String, Integer> entry : sortedTreeMap.entrySet()) {  
            System.out.println(entry.getKey() + ": " + entry.getValue());  
        }  
    }  
} 