package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0329 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> state = new ArrayList<Integer>();
        doCmbinationSum(0, target, candidates, state, result);
        return result;
    }

    private static void doCmbinationSum(int index, int target, int[] candidates, List<Integer> state, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(state));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            state.add(candidates[i]);
            doCmbinationSum(i, target - candidates[i], candidates, state, result);
            state.remove(state.size() - 1);
        }
    }
}
