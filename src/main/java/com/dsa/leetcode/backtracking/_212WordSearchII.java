package com.dsa.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class _212WordSearchII {

    public static void main(String[] args) {


        char board[][] = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};


        _79WordSearch.Solution solution = new _79WordSearch.Solution();
        for (String word : words) {//Brute Force

            boolean exist = solution.exist(board, word);
            if (exist)
                System.out.println(word);//  words * n*m 4^(n*m)
        }

        System.out.println(findWords(board, words));


    }

    public static List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int column = board[board.length - 1].length;
        HashSet<String> result = new HashSet<>();
        HashSet<String> visit = new HashSet<>();

        PrefixTrie prefixTrie = new PrefixTrie();//feeding our prefixTrie
        for (String word : words) {//Brute Force
            prefixTrie.insert(word);
        }

        //        O(n) r *c * dfs^4 = r *c * word^4
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                dfs(board, "", visit, prefixTrie.root, result, i, j);
            }
        }

        return result.stream().collect(Collectors.toList());

    }


    static void dfs(char[][] board, String word, HashSet<String> visit, TrieNode node, HashSet<String> set, int i, int j) {
        int rows = board.length;
        int column = board[board.length - 1].length;

        if (i < 0 || j < 0 ||
                i >= rows || j >= column ||
                visit.contains(i + "_" + j) || !node.children.containsKey(board[i][j])) {
            return;
        }

        //if we found the element
        visit.add(i + "_" + j);
        node = node.children.get(board[i][j]);
        word += board[i][j];
        if (node.endOfWord == true) {
            set.add(word);
        }


        dfs(board, word, visit, node, set, i + 1, j);
        dfs(board, word, visit, node, set, i - 1, j);
        dfs(board, word, visit, node, set, i, j + 1);
        dfs(board, word, visit, node, set, i, j - 1);


        visit.remove(i + "_" + j);//clean up is ver important to resume the operation


    }


    static class PrefixTrie {

        TrieNode root;

        public PrefixTrie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curTrieNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                if (!curTrieNode.children.containsKey(word.charAt(i))) {
                    curTrieNode.children.put(word.charAt(i), new TrieNode());
                }
                curTrieNode = curTrieNode.children.get(word.charAt(i));
            }
            curTrieNode.endOfWord = true;//marking the last node as end of the word
        }

        public boolean search(String word) {

            TrieNode curTrieNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                if (!curTrieNode.children.containsKey(word.charAt(i))) {
                    return false;
                } else
                    curTrieNode = curTrieNode.children.get(word.charAt(i));
            }
            return curTrieNode.endOfWord;//id thelast node end of the word
        }

        public boolean startsWith(String prefix) {
            TrieNode curTrieNode = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                if (!curTrieNode.children.containsKey(prefix.charAt(i))) {
                    return false;
                } else
                    curTrieNode = curTrieNode.children.get(prefix.charAt(i));
            }
            return true;
        }
    }

    static public class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean endOfWord;//leaf node

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }



}


