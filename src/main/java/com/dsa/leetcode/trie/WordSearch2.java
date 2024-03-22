package com.dsa.leetcode.trie;

import java.util.ArrayList;
import java.util.List;

class WordSearch2 {
    List<String> ans;

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for (String s : words) t.insert(s);
        ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sol(board, i, j, t.root, new StringBuilder());
            }
        }
        return ans;
    }

    public void sol(char[][] mat, int i, int j, TrieNode root, StringBuilder sb) {
        char ch = mat[i][j];
        if (ch == '1' || root.children[ch - 'a'] == null) return;
        root = root.children[ch - 'a'];
        sb.append(ch);
        if (root.isWord) {
            ans.add(sb.toString());
            root.isWord = false;
        }
        mat[i][j] = '1';
        if (i > 0) sol(mat, i - 1, j, root, sb);
        if (j > 0) sol(mat, i, j - 1, root, sb);
        if (i < mat.length - 1) sol(mat, i + 1, j, root, sb);
        if (j < mat[0].length - 1) sol(mat, i, j + 1, root, sb);
        sb.deleteCharAt(sb.length() - 1);
        mat[i][j] = ch;
    }
}

class TrieNode {
    char data;
    boolean isWord;
    TrieNode[] children;

    public TrieNode(char data) {
        this.data = data;
        isWord = false;
        children = new TrieNode[26];
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        insert(root, word);
    }

    public void insert(TrieNode root, String s) {
        if (s.length() == 0) {
            root.isWord = true;
            return;
        }
        int idx = s.charAt(0) - 'a';
        TrieNode child = root.children[idx];
        if (child == null) {
            child = new TrieNode(s.charAt(0));
            root.children[idx] = child;
        }
        insert(child, s.substring(1));
    }

    public boolean search(String word) {
        return search(root, word);
    }

    public boolean search(TrieNode root, String s) {
        if (s.length() == 0) return root.isWord;
        int idx = s.charAt(0) - 'a';
        TrieNode child = root.children[idx];
        if (child == null) return false;
        return search(child, s.substring(1));
    }
}