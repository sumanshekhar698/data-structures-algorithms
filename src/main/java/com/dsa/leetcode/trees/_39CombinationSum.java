package com.dsa.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class _39CombinationSum {

    List<List<Integer>> resultList = new ArrayList<>();
    int target;
    int[] candidates;

    public static void main(String[] args) {

        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> lists = new _39CombinationSum().combinationSum(arr, 7);
        System.out.println(lists);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {//the main issue is eliminating duplicate combinations
        this.target = target;
        this.candidates = candidates;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, list, 0);
        return this.resultList;

    }

    void dfs(int i, ArrayList<Integer> curList, int total) {
        //BASE CASE
        if (total == target) {
//            ArrayList<Integer> copy = new ArrayList<>(curList);
//            ArrayList<Integer> copy = new ArrayList<>(List.copyOf(curList));
//            this.resultList.add(List.copyOf(curList));
            this.resultList.add((List<Integer>) curList.clone());
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }

        curList.add(candidates[i]);
        dfs(i, curList, total + candidates[i]);//including

        curList.remove(curList.size() - 1);//pop and cleanup
        dfs(i + 1, curList, total);//not including


    }
}
