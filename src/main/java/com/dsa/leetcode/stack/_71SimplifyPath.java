package com.dsa.leetcode.stack;

import javax.swing.*;
import java.util.Stack;
import java.util.stream.Collectors;

public class _71SimplifyPath {
    public static void main(String[] args) {

        String path = "/home//foo/";
        String path2 = "/../home//./foo/";//   /home/foo/

        String s = new Solution().simplifyPathSimple(path2);
        System.out.println(s);


    }


    static class Solution {


        public String simplifyPathSimple(String path) {

            Stack<String> stack = new Stack<>();

            String[] split = path.split("/");

            for (String part : split) {
                if (part.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!part.equals(".") && !part.isEmpty()) {
                    stack.push(part);
                }
            }

            return "/" + String.join("/", stack);
        }

        public String simplifyPath(String path) {

//             /abc/.  IGNORE /abc
//            /home/..   pop 2 items -> /       we wil use stack for this case
//            // -> /

//            L - R

            Stack<String> stack = new Stack<String>();//we will only add files and folders
            String cur = "";


            for (int i = 0; i < path.length(); i++) {
                char ch = path.charAt(i);
                if (ch == '/') {
                    if (cur == "..") {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else if (cur != "" && cur != ".") {
                            stack.push(cur);
                        }
                        cur = "";
                    }
                } else {
                    cur += ch;
                }
            }

            String collect = stack.stream().collect(Collectors.joining("/", "/", ""));
            return collect;


        }
    }
}
