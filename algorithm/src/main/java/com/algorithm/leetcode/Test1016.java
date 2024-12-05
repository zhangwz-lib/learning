package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test1016 {
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> state = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 1, k, state, res);
        return res;
    }

    public static List<List<Integer>> backtrack(int n, int index, int k, List<Integer> state, List<List<Integer>> res) {
        if (state.size() == k) {
            res.add(new ArrayList<>(state));
            return res;
        }

        if (index > n) {
            return res;
        }

        for (int i = index; i <= n; i++) {
            state.add(i);
            backtrack(n, i + 1, k, state, res);
            state.remove(state.size() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);

    }
}
