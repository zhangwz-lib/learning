package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        int[] nums = new int[]{1, 2, 3, 4};
        StringBuilder state = new StringBuilder();
        permute(state, nums, new boolean[nums.length], res);
        res.forEach(System.out::println);
    }

    static void permute(StringBuilder state, int[] choices, boolean[] selected, List<String> res) {

        if (state.length() == 3) {
            res.add(state.toString());
            return;
        }
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            if (!selected[i]) {
                selected[i] = true;
                state.append(choice);
                permute(state, choices, selected, res);
                selected[i] = false;
                state.deleteCharAt(state.length() - 1);
            }
        }
    }
}
