package com.dsa.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class _22_M_GenerateParentheses {

    public static void main(String[] args) {
        List<String> res = new Solution().generateParenthesis(3);
        System.out.println(res);
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {

            // ADD Open (:: If currentCount(Open) < n)
            // ADD Close ) :: If currentCount(Open) > currentCount(Close)
            // Stop Condition :: currentCount(Open) = currentCount(Close) = n

            ArrayDeque<String> stack = new ArrayDeque<>();
            ArrayList<String> res = new ArrayList<>();


            class BackTrack {

                /*
                 * It is called backtracking because of a literal physical action the algorithm takes:
                 * it moves forward along a tentative path, hits either a dead end or a completed solution,
                 * and then literally tracks back to the previous junction by undoing its last step to try an alternative.
                 *
                 * */
                void backtrack(int openN, int closeN) {

                    if (openN == closeN && closeN == n) {
                        // Join with no delimiter: "(())"
                        String result = stack.stream()
//                                .map(String::valueOf)//Important if ArrayDequeue is of type Character
                                .collect(Collectors.joining());
                        res.add(result);
                    }

                    if (openN < n) {
                        stack.offerLast("(");
                        backtrack(openN + 1, closeN);
                        stack.pollLast();
                    }


                    if (closeN < openN) {
                        stack.offerLast(")");
                        backtrack(openN, closeN + 1);
                        stack.pollLast();
                    }


                }
            }

            new BackTrack().backtrack(0, 0);

            return res;


        }


        class SolutionJavaOptimized {
            public List<String> generateParenthesis(int n) {
                List<String> res = new ArrayList<>();
                StringBuilder sb = new StringBuilder(2 * n);
                backtrack(res, sb, 0, 0, n);
                return res;
            }

            private void backtrack(List<String> res, StringBuilder sb, int openN, int closeN, int n) {
                // Base case: formed a valid string of length 2n
                if (openN == n && closeN == n) {
                    res.add(sb.toString());
                    return; // Early exit prevents redundant checks
                }

                if (openN < n) {
                    sb.append('(');
                    backtrack(res, sb, openN + 1, closeN, n);
                    sb.deleteCharAt(sb.length() - 1); // backtrack
                }

                if (closeN < openN) {
                    sb.append(')');
                    backtrack(res, sb, openN, closeN + 1, n);
                    sb.deleteCharAt(sb.length() - 1); // backtrack
                }
            }
        }


        class SolutionJavaOverKillOptimized {
            public List<String> generateParenthesis(int n) {
                List<String> res = new ArrayList<>();
                char[] current = new char[2 * n];
                backtrack(res, current, 0, 0, 0, n);
                return res;
            }

            private void backtrack(List<String> res, char[] current, int index, int openN, int closeN, int n) {
                if (index == current.length) {
                    res.add(new String(current));
                    return;
                }

                if (openN < n) {
                    current[index] = '(';
                    backtrack(res, current, index + 1, openN + 1, closeN, n);
                }

                if (closeN < openN) {
                    current[index] = ')';
                    backtrack(res, current, index + 1, openN, closeN + 1, n);
                }
            }
        }

    }
}
