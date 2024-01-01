package com.dsa.leetcode.trie;

import java.util.HashMap;

public class _208ImplementTriePrefixTree {


    class Trie {

        TrieNode root;

        public Trie() {
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

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

}
